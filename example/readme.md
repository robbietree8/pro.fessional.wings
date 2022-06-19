# 9.演示例子(example)

运行`demo-devops/wings-init-project.sh`生成一个样板工程。

## 9.1.前置条件

* 了解 `maven`，缺什么，补什么。
* 了解 `spring*`，`看官方文档，不要百度` x 3！
* 了解 `mysql*`数据库，mysql

## 9.2.自建环境

```bash
# 设置变量
PASS=S4f3_Password@MoilionCircle

# 创建一个mysql数据库
docker run -d \
--name demo-mysql-8.0 \
-e MYSQL_DATABASE=wings_example \
-e MYSQL_ROOT_PASSWORD=${PASS} \
-p 3306:3306 \
mysql:8.0
```

参考以下文档或脚本，根据需要创建程序运行或数据维护用户

* wings-faceless/readme.md - 单一用户
* demo-devops/bin/wings-mysql-user.sh - 分离用户

## 9.3.压力测试

压力测试，必须`ulimit -n`在10k以上，同一内网以忽略带宽限制。

### maven 打包和启动

```bash
mvn -U clean package
demo-devops/wings-starter.sh start
# Ctrl-C停止日志输出
demo-devops/wings-starter.sh stop
```

### jmeter 模拟10K用户

无界面启动Jmeter，如果jmeter不在PATH中，则需要自行制定全路径
如 `~/Applications-cli/apache-jmeter-5.4.1/bin/jmeter`

```bash
ulimit -n 20000

JVM_ARGS="-Xmx4G -XX:+UseG1GC -XX:MaxGCPauseMillis=100 -XX:G1ReservePercent=20"

rm -rf demo-devops/target/load-test/ &&\
mkdir -p demo-devops/target/load-test/report

jmeter -n \
-t demo-devops/src/test/jmeter/load-test.jmx \
-l demo-devops/target/load-test/load-test.jtl \
-j demo-devops/target/load-test/load-test.log \
-e -o demo-devops/target/load-test/report
```

## 9.4. 程序部署

复制 wings-starter.sh 到服务器，并使用软连接建立启动脚本和env文件，以demo-admin为例。

```bash
# 建立启动脚本，一个boot一个
ln -s wings-starter.sh demo-admin.sh
# 复制 wings-starter.env内容，与启动脚本同名(扩展名不同)
vi demo-admin.env
```

在env中，port,jar,log容易理解，按项目需要配置即可。
BOOT_CNF是用来替换默认配置的运行时配置，结构如下。

```text
├── application.properties // 程序级设置
├── wings-conf // 自动配置，按需覆盖内部文件
│     └── spring-datasource.properties
```

## 9.5. Nginx配置

通常的配置参考，包括强制https，保护误操作.git，前后端分离。

```nginx
upstream demo_admin {
    ip_hash;
    server demo_appser_01:8090;
    server demo_appser_02:8090;
    keepalive 300; # 长连接
}

server {
    listen       80;
    listen       443 ssl;
    server_name  admin.moilioncircle.com;

    access_log /data/logs/nginx/admin.moilioncircle.com-access.log;
    error_log  /data/logs/nginx/admin.moilioncircle.com-error.log;

    ssl_certificate     /data/nginx/cert/moilioncircle.com/fullchain.pem;
    ssl_certificate_key /data/nginx/cert/moilioncircle.com/privkey.pem;

    #if ($scheme = http) {
    #    return 301 https://$host$request_uri;
    #}
    
    # 防御性设置，禁止发布git工程
    location .git {
        access_log off;
        log_not_found off;
        deny all;
    }

    # 后端分流，资源类遵循res-id-{base64_urlsafe}.{pdf}格式
    location ~* (\.json|/res-id-[\-=_0-9a-z]+\.[0-9a-z]+)$ {
        proxy_pass http://demo_admin;
        proxy_http_version  1.1;
        proxy_cache_bypass  $http_upgrade;
    
        proxy_set_header  Connection   "";            # 长连接
        #proxy_set_header Connection   "upgrade";     # ws
        #proxy_set_header Upgrade      $http_upgrade; # ws
        proxy_set_header  Host         $host;
        proxy_set_header  X-Real-IP    $remote_addr;
        proxy_redirect    http://      $scheme://;    # https
    }

    # 前端分流
    location / {
        #add_header 'Access-Control-Allow-Origin' '*'; #允许跨域
        root /data/static/demo-admin-spa/;
        if ($request_filename ~* \.(html|htm)$){
            add_header Cache-Control no-cache,no-store,max-age=0,must-revalidate;
        }
    }
}
```

挂旗维护，重定向到维护倒计时界面 500.html

* sudo ln -s /data/nginx/conf/nginx.nginx /etc/nginx/nginx.conf
* include /data/nginx/conf/vhost/*.nginx;
* include /data/nginx/down/*.nginx;

```nginx
# sudo vi /etc/nginx/nginx.conf

server {
    listen       80;
    listen       443 ssl;
    server_name  _;
    root           /data/nginx/down;
    error_page 403 /500.html;
    error_page 404 /500.html;
}
```

http段有关的长连接和反向代理设置。

```nginx
http {
    keepalive_timeout 1800;
    keepalive_requests 8192;

    client_max_body_size    50m;
    send_timeout            1800;
    
    proxy_connect_timeout   1800;
    proxy_send_timeout      1800;
    proxy_read_timeout      1800;

    proxy_buffering on;
    proxy_buffer_size 4k;           #设置代理服务器（nginx）保存用户头信息的缓冲区大小
    proxy_buffers 4 32k;            #proxy_buffers缓冲区，网页平均在32k以下的设置
    proxy_busy_buffers_size 64k;    #高负荷下缓冲大小（proxy_buffers*2）
    proxy_temp_file_write_size 64k;
    proxy_max_temp_file_size 0;
}
```