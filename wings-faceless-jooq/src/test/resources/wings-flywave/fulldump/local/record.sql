-- revision=2019052101, apply_dt=2020-06-13 22:38:09

-- sys_constant_enum DmlInsert
INSERT INTO `sys_constant_enum`(`id`,`type`,`code`,`desc`,`info`) VALUES 
(1010100,'standard_timezone','id','标准时区','classpath:/wings-tmpl/StandardTimezoneTemplate.java'),
(1010101,'standard_timezone','GMT','格林威治时间(零时区)',''),
(1010201,'standard_timezone','Asia/Shanghai','北京时间：北京、上海、香港','中国'),
(1010301,'standard_timezone','America/Chicago','中部时(CST)：芝加哥、休斯顿','美国'),
(1010302,'standard_timezone','America/Los_Angeles','西部时间(PST)：西雅图、洛杉矶','美国'),
(1010303,'standard_timezone','America/New_York','东部时(EST)：纽约、华盛顿','美国'),
(1010304,'standard_timezone','America/Phoenix','山地时(MST)：丹佛、凤凰城','美国'),
(1010305,'standard_timezone','US/Alaska','阿拉斯加时间(AKST)：安克雷奇','美国'),
(1010306,'standard_timezone','US/Hawaii','夏威夷时间(HST)：火鲁奴奴','美国'),
(1010401,'standard_timezone','Asia/Jakarta','雅加达、泗水、棉兰','印度尼西亚'),
(1010402,'standard_timezone','Asia/Jayapura','查亚普拉、马诺夸里','印度尼西亚'),
(1010403,'standard_timezone','Asia/Makassar','望加锡、万鸦老、阿克','印度尼西亚'),
(1010501,'standard_timezone','Asia/Kuala_Lumpur','马来西亚：吉隆坡','马来西亚'),
(1010601,'standard_timezone','Asia/Seoul','韩国时间：首尔','韩国'),
(1010701,'standard_timezone','Asia/Singapore','新加坡时间','新加坡'),
(1010801,'standard_timezone','Asia/Tokyo','日本时间：东京','日本'),
(1010901,'standard_timezone','Canada/Atlantic','大西洋时(AST)：哈利法克斯','加拿大'),
(1010902,'standard_timezone','Canada/Central','中部时(CST)：温尼伯','加拿大'),
(1010903,'standard_timezone','Canada/Eastern','东部时(EST)：多伦多、渥太华、魁北克城','加拿大'),
(1010904,'standard_timezone','Canada/Mountain','山地时(MST)：埃德蒙顿、卡尔加里','加拿大'),
(1010905,'standard_timezone','Canada/Newfoundland','纽芬兰时(NST)：圣约翰斯','加拿大'),
(1010906,'standard_timezone','Canada/Pacific','太平洋时(PST)：温哥华','加拿大'),
(1020100,'standard_language','code','标准语言','classpath:/wings-tmpl/StandardLanguageTemplate.java'),
(1020101,'standard_language','ar_AE','阿拉伯联合酋长国',''),
(1020102,'standard_language','de_DE','德语',''),
(1020103,'standard_language','en_US','美国英语',''),
(1020104,'standard_language','es_ES','西班牙语',''),
(1020105,'standard_language','fr_FR','法语',''),
(1020106,'standard_language','it_IT','意大利语',''),
(1020107,'standard_language','ja_JP','日语',''),
(1020108,'standard_language','ko_KR','韩语',''),
(1020109,'standard_language','ru_RU','俄语',''),
(1020110,'standard_language','th_TH','泰国语',''),
(1020111,'standard_language','zh_CN','简体中文',''),
(1020112,'standard_language','zh_HK','繁体中文','');

-- sys_light_sequence DmlInsert
INSERT INTO `sys_light_sequence`(`seq_name`,`block_id`,`next_val`,`step_val`,`comments`) VALUES 
('singleton_lightid_blockid',0,10000000,100,'default block_id'),
('sys_commit_journal',0,1,100,'sys_commit_journal'),
('sys_constant_enum',0,100000000,100,'系统插入9位起，手动8位'),
('sys_standard_i18n',0,100000000,100,'系统插入9位起，手动8位');

-- sys_schema_journal DmlInsert
INSERT INTO `sys_schema_journal`(`table_name`,`create_dt`,`modify_dt`,`commit_id`,`ddl_updtbl`,`ddl_updtrg`,`ddl_deltbl`,`ddl_deltrg`,`log_update`,`log_delete`) VALUES 
('sys_schema_journal','2020-06-13 22:38:06.736','1000-01-01 00:00:00.000',0,'','','','','1000-01-01 00:00:00.000','1000-01-01 00:00:00.000'),
('sys_schema_version','2020-06-13 22:38:06.736','1000-01-01 00:00:00.000',0,'','','','','1000-01-01 00:00:00.000','1000-01-01 00:00:00.000');

-- sys_schema_version DmlInsert
INSERT INTO `sys_schema_version`(`revision`,`create_dt`,`modify_dt`,`commit_id`,`apply_dt`,`comments`,`upto_sql`,`undo_sql`) VALUES 
(2019051201,'2020-06-13 22:38:06.670','2020-06-13 22:38:06.000',0,'2020-06-13 22:38:06.000','master/init/*-version-journal.sql','-- 时区统一(GMT+8)，编码统一(utf8mb4)\n-- CREATE DATABASE `wings_0` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;\n\nCREATE TABLE `sys_schema_version` (\n    `revision`  BIGINT(20)   NOT NULL COMMENT \'版本号+修订号\',\n    `create_dt` DATETIME(3)  NOT NULL DEFAULT NOW(3) COMMENT \'创建日时\',\n    `modify_dt` DATETIME(3)  NOT NULL DEFAULT \'1000-01-01 00:00:00\' ON UPDATE NOW(3) COMMENT \'修改日时\',\n    `commit_id` BIGINT(20)   NOT NULL COMMENT \'提交ID\',\n    `apply_dt`  DATETIME(3)  NOT NULL DEFAULT \'1000-01-01 00:00:00\' COMMENT \'执行日时\',\n    `comments`  VARCHAR(500) NOT NULL DEFAULT \'\' COMMENT \'sql路径信息\',\n    `upto_sql`  TEXT         NOT NULL COMMENT \'升级脚本\',\n    `undo_sql`  TEXT         NOT NULL COMMENT \'降级脚本\',\n    PRIMARY KEY (`revision`)\n) ENGINE = InnoDB\n  DEFAULT CHARSET = utf8mb4 COMMENT =\'101/表结构版本\';\n\nCREATE TABLE `sys_schema_journal` (\n    `table_name` VARCHAR(100) NOT NULL COMMENT \'主表表名\',\n    `create_dt`  DATETIME(3)  NOT NULL DEFAULT NOW(3) COMMENT \'创建日时\',\n    `modify_dt`  DATETIME(3)  NOT NULL DEFAULT \'1000-01-01\' ON UPDATE NOW(3) COMMENT \'修改日时\',\n    `commit_id`  BIGINT(20)   NOT NULL COMMENT \'提交ID\',\n    `ddl_updtbl` TEXT         NOT NULL COMMENT \'更新的跟踪表DDL\',\n    `ddl_updtrg` TEXT         NOT NULL COMMENT \'更新的触发器DDL\',\n    `ddl_deltbl` TEXT         NOT NULL COMMENT \'删除的跟踪表DDL\',\n    `ddl_deltrg` TEXT         NOT NULL COMMENT \'删除的触发器DDL\',\n    `log_update` DATETIME(3)  NOT NULL DEFAULT \'1000-01-01\' COMMENT \'开始跟踪更新的日时\',\n    `log_delete` DATETIME(3)  NOT NULL DEFAULT \'1000-01-01\' COMMENT \'开始跟踪删除的日时\',\n    PRIMARY KEY (`table_name`)\n) ENGINE = InnoDB\n  DEFAULT CHARSET = utf8mb4 COMMENT =\'102/数据触发器\';\n\n-- sys_schema_version@plain\nINSERT IGNORE INTO `sys_schema_version` (`revision`, `commit_id`, `upto_sql`, `undo_sql`, `apply_dt`)\nVALUES (2019051201, 0, \'\', \'\', NOW());\n\n-- sys_schema_journal@plain\nREPLACE INTO `sys_schema_journal` (`table_name`, `commit_id`, `ddl_updtbl`, `ddl_updtrg`, `ddl_deltbl`, `ddl_deltrg`)\nVALUES (\'sys_schema_journal\', 0, \'\', \'\', \'\', \'\'),\n       (\'sys_schema_version\', 0, \'\', \'\', \'\', \'\');','DROP TABLE IF EXISTS `sys_schema_version`;\nDROP TABLE IF EXISTS `sys_schema_journal`;\n'),
(2019052001,'2020-06-13 22:38:06.000','2020-06-13 22:38:08.995',0,'2020-06-13 22:38:08.000','master/m001/*-light-commit.sql','CREATE TABLE `sys_light_sequence` (\n    `seq_name` VARCHAR(100) NOT NULL COMMENT \'序列名\',\n    `block_id` INT(11)      NOT NULL DEFAULT 0 COMMENT \'分块序号\',\n    `next_val` BIGINT(20)   NOT NULL DEFAULT \'1\' COMMENT \'下一个序号\',\n    `step_val` INT(11)      NOT NULL DEFAULT \'100\' COMMENT \'序列步长\',\n    `comments` VARCHAR(200) NOT NULL COMMENT \'注释说明\',\n    PRIMARY KEY (`seq_name`, `block_id`)\n) ENGINE = InnoDB\n  DEFAULT CHARSET = utf8mb4 COMMENT =\'103/序号生成器\';\n\nCREATE TABLE `sys_commit_journal` (\n    `id`         BIGINT(20)   NOT NULL COMMENT \'主键\',\n    `create_dt`  DATETIME(3)  NOT NULL DEFAULT NOW(3) COMMENT \'创建日时\',\n    `event_name` VARCHAR(200) NOT NULL COMMENT \'事件名称\',\n    `target_key` VARCHAR(200) NOT NULL DEFAULT \'\' COMMENT \'目标数据特征\',\n    `login_info` TEXT COMMENT \'登陆信息，用户，终端等\',\n    `other_info` TEXT COMMENT \'其他信息，业务侧自定义\',\n    PRIMARY KEY (`id`)\n) ENGINE = InnoDB\n  DEFAULT CHARSET = utf8mb4 COMMENT =\'104/数据变更集\';\n\n-- sys_light_sequence@plain\nINSERT IGNORE INTO `sys_light_sequence` (`seq_name`, `block_id`, `next_val`, `step_val`, `comments`)\nVALUES (\'singleton_lightid_blockid\', 0, 10000000, 100, \'default block_id\'),\n       (\'sys_commit_journal\', 0, 1, 100, \'sys_commit_journal\');\n\n-- sys_commit_journal@plain\nREPLACE INTO `sys_commit_journal` (`id`, `event_name`)\nVALUES (0, \'system_manual_init\');\n','DROP TABLE IF EXISTS `sys_light_sequence`;\nDROP TABLE IF EXISTS `sys_commit_journal`;'),
(2019052101,'2020-06-13 22:38:07.000','2020-06-13 22:38:09.898',0,'2020-06-13 22:38:09.000','branch/features/enum-i18n/*-enum-i18n.sql','CREATE TABLE `sys_constant_enum` (\n    `id`   INT(11)      NOT NULL COMMENT \'id:动态9位数起，静态8位以下，建议3-2-2分段（表-段-值）,00结尾为SUPER\',\n    `type` VARCHAR(100) NOT NULL COMMENT \'enum分组:相同type为同一Enum，自动Pascal命名\',\n    `code` VARCHAR(100) NOT NULL COMMENT \'enum名字:为SUPER时固定code|id，表示对外key,编码友好\',\n    `desc` VARCHAR(100) NOT NULL COMMENT \'默认名字:线上\',\n    `info` VARCHAR(500) NOT NULL COMMENT \'扩展信息:分类，过滤等，如果SUPER时，为模板Resource格式\',\n    PRIMARY KEY (`id`)\n) ENGINE = InnoDB\n  DEFAULT CHARSET = utf8mb4 COMMENT =\'105/常量枚举:自动生成enum类\';\n\nCREATE TABLE `sys_standard_i18n` (\n    `base` VARCHAR(100)  NOT NULL COMMENT \'基集合:表或类\',\n    `kind` VARCHAR(100)  NOT NULL COMMENT \'多国语字段：code或列名\',\n    `ukey` VARCHAR(200)  NOT NULL COMMENT \'唯一键:code|id###\',\n    `lang` CHAR(5)       NOT NULL COMMENT \'国家语言标记，下划线分隔:zh_CN\',\n    `text` VARCHAR(3000) NOT NULL COMMENT \'语言内容:中国/东北三省|攻城狮\',\n    PRIMARY KEY (`base`, `kind`, `ukey`, `lang`)\n) ENGINE = InnoDB\n  DEFAULT CHARSET = utf8mb4 COMMENT =\'106/标准多国语\';\n\nINSERT IGNORE INTO `sys_light_sequence`(`seq_name`, `block_id`, `next_val`, `step_val`, `comments`)\nVALUES (\'sys_constant_enum\', 0, 100000000, 100, \'系统插入9位起，手动8位\'),\n       (\'sys_standard_i18n\', 0, 100000000, 100, \'系统插入9位起，手动8位\');\n\n-- type相同为同一enum，id以00结尾为SUPER元素，code为enum的name\nREPLACE INTO `sys_constant_enum` (`id`, `type`, `code`, `desc`, `info`)\nVALUES (1010100, \'standard_timezone\', \'id\', \'标准时区\', \'classpath:/wings-tmpl/StandardTimezoneTemplate.java\'),\n       (1010101, \'standard_timezone\', \'GMT\', \'格林威治时间(零时区)\', \'\'),\n       (1010201, \'standard_timezone\', \'Asia/Shanghai\', \'北京时间：北京、上海、香港\', \'中国\'),\n       (1010301, \'standard_timezone\', \'America/Chicago\', \'中部时(CST)：芝加哥、休斯顿\', \'美国\'),\n       (1010302, \'standard_timezone\', \'America/Los_Angeles\', \'西部时间(PST)：西雅图、洛杉矶\', \'美国\'),\n       (1010303, \'standard_timezone\', \'America/New_York\', \'东部时(EST)：纽约、华盛顿\', \'美国\'),\n       (1010304, \'standard_timezone\', \'America/Phoenix\', \'山地时(MST)：丹佛、凤凰城\', \'美国\'),\n       (1010305, \'standard_timezone\', \'US/Alaska\', \'阿拉斯加时间(AKST)：安克雷奇\', \'美国\'),\n       (1010306, \'standard_timezone\', \'US/Hawaii\', \'夏威夷时间(HST)：火鲁奴奴\', \'美国\'),\n       (1010401, \'standard_timezone\', \'Asia/Jakarta\', \'雅加达、泗水、棉兰\', \'印度尼西亚\'),\n       (1010402, \'standard_timezone\', \'Asia/Jayapura\', \'查亚普拉、马诺夸里\', \'印度尼西亚\'),\n       (1010403, \'standard_timezone\', \'Asia/Makassar\', \'望加锡、万鸦老、阿克\', \'印度尼西亚\'),\n       (1010501, \'standard_timezone\', \'Asia/Kuala_Lumpur\', \'马来西亚：吉隆坡\', \'马来西亚\'),\n       (1010601, \'standard_timezone\', \'Asia/Seoul\', \'韩国时间：首尔\', \'韩国\'),\n       (1010701, \'standard_timezone\', \'Asia/Singapore\', \'新加坡时间\', \'新加坡\'),\n       (1010801, \'standard_timezone\', \'Asia/Tokyo\', \'日本时间：东京\', \'日本\'),\n       (1010901, \'standard_timezone\', \'Canada/Atlantic\', \'大西洋时(AST)：哈利法克斯\', \'加拿大\'),\n       (1010902, \'standard_timezone\', \'Canada/Central\', \'中部时(CST)：温尼伯\', \'加拿大\'),\n       (1010903, \'standard_timezone\', \'Canada/Eastern\', \'东部时(EST)：多伦多、渥太华、魁北克城\', \'加拿大\'),\n       (1010904, \'standard_timezone\', \'Canada/Mountain\', \'山地时(MST)：埃德蒙顿、卡尔加里\', \'加拿大\'),\n       (1010905, \'standard_timezone\', \'Canada/Newfoundland\', \'纽芬兰时(NST)：圣约翰斯\', \'加拿大\'),\n       (1010906, \'standard_timezone\', \'Canada/Pacific\', \'太平洋时(PST)：温哥华\', \'加拿大\'),\n\n       (1020100, \'standard_language\', \'code\', \'标准语言\', \'classpath:/wings-tmpl/StandardLanguageTemplate.java\'),\n       (1020101, \'standard_language\', \'ar_AE\', \'阿拉伯联合酋长国\', \'\'),\n       (1020102, \'standard_language\', \'de_DE\', \'德语\', \'\'),\n       (1020103, \'standard_language\', \'en_US\', \'美国英语\', \'\'),\n       (1020104, \'standard_language\', \'es_ES\', \'西班牙语\', \'\'),\n       (1020105, \'standard_language\', \'fr_FR\', \'法语\', \'\'),\n       (1020106, \'standard_language\', \'it_IT\', \'意大利语\', \'\'),\n       (1020107, \'standard_language\', \'ja_JP\', \'日语\', \'\'),\n       (1020108, \'standard_language\', \'ko_KR\', \'韩语\', \'\'),\n       (1020109, \'standard_language\', \'ru_RU\', \'俄语\', \'\'),\n       (1020110, \'standard_language\', \'th_TH\', \'泰国语\', \'\'),\n       (1020111, \'standard_language\', \'zh_CN\', \'简体中文\', \'\'),\n       (1020112, \'standard_language\', \'zh_HK\', \'繁体中文\', \'\');\n\n-- https://24timezones.com/zh_clock/united_states_time.php\nREPLACE INTO `sys_standard_i18n`(`base`, `kind`, `ukey`, `lang`, `text`)\nVALUES (\'sys_constant_enum\', \'desc\', \'id1010101\', \'zh_CN\', \'格林威治时间(零时区)\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010101\', \'en_US\', \'Greenwich Mean Time\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010201\', \'zh_CN\', \'北京时间：北京、上海、香港\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010201\', \'en_US\', \'China: BeiJing, ShangHai, HongKong\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010301\', \'zh_CN\', \'中部时(CST)：芝加哥、休斯顿\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010301\', \'en_US\', \'CST: Chicago, Houston\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010302\', \'zh_CN\', \'西部时间(PST)：西雅图、洛杉矶\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010302\', \'en_US\', \'PST: L.A., Seattle\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010303\', \'zh_CN\', \'东部时(EST)：纽约、华盛顿\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010303\', \'en_US\', \'EST: NewYork, D.C.\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010304\', \'zh_CN\', \'山地时(MST)：丹佛、凤凰城\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010304\', \'en_US\', \'MST: Denver, Phoenix\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010305\', \'zh_CN\', \'阿拉斯加时间(AKST)：安克雷奇\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010305\', \'en_US\', \'AKST: Alaska, Fairbanks\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010306\', \'zh_CN\', \'夏威夷时间(HST)：火鲁奴奴\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010306\', \'en_US\', \'HST: Hawaii, Honolulu\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010401\', \'zh_CN\', \'印度尼西亚：雅加达、泗水、棉兰\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010401\', \'en_US\', \'Indonesia：Jakarta, Surabaya、Medan\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010402\', \'zh_CN\', \'印度尼西亚：查亚普拉、马诺夸里\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010402\', \'en_US\', \'Indonesia：Jayapura、Manokwari\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010403\', \'zh_CN\', \'印度尼西亚：望加锡、万鸦老、阿克\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010403\', \'en_US\', \'Indonesia：Makassar、Manado、Balikpapan\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010501\', \'zh_CN\', \'马来西亚：吉隆坡\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010501\', \'en_US\', \'Malaysia: KualaLumpur\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010601\', \'zh_CN\', \'韩国时间：首尔\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010601\', \'en_US\', \'Korea: Seoul\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010701\', \'zh_CN\', \'新加坡时间\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010701\', \'en_US\', \'Singapore\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010801\', \'zh_CN\', \'日本时间：东京\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010801\', \'en_US\', \'Japan: Tokyo\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010901\', \'zh_CN\', \'大西洋时(AST)：哈利法克斯\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010901\', \'en_US\', \'AST: Halifax\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010902\', \'zh_CN\', \'中部时(CST)：温尼伯\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010902\', \'en_US\', \'CST: Winnipeg\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010903\', \'zh_CN\', \'东部时(EST)：多伦多、渥太华、魁北克城\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010903\', \'en_US\', \'EST: Toronto, Ottawa, Quebec\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010904\', \'zh_CN\', \'山地时(MST)：埃德蒙顿、卡尔加里\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010904\', \'en_US\', \'MST: Edmonton, Calgary\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010905\', \'zh_CN\', \'纽芬兰时(NST)：圣约翰斯\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010905\', \'en_US\', \'NST: St.John\'),\n\n       (\'sys_constant_enum\', \'desc\', \'id1010906\', \'zh_CN\', \'太平洋时(PST)：温哥华\'),\n       (\'sys_constant_enum\', \'desc\', \'id1010906\', \'en_US\', \'PST: Vancouver\');\n\n-- java.util.Locale#toLanguageTag\nREPLACE INTO `sys_standard_i18n`(`base`, `kind`, `ukey`, `lang`, `text`)\nVALUES (\'sys_constant_enum\', \'desc\', \'zh_CN\', \'zh_CN\', \'简体中文\'),\n       (\'sys_constant_enum\', \'desc\', \'zh_CN\', \'en_US\', \'Simplified Chinese\'),\n\n       (\'sys_constant_enum\', \'desc\', \'zh_HK\', \'zh_HK\', \'繁體中文\'),\n       (\'sys_constant_enum\', \'desc\', \'zh_HK\', \'zh_CN\', \'繁体中文\'),\n       (\'sys_constant_enum\', \'desc\', \'zh_HK\', \'en_US\', \'Traditional Chinese\'),\n\n       (\'sys_constant_enum\', \'desc\', \'ja_JP\', \'ja_JP\', \'日本語\'),\n       (\'sys_constant_enum\', \'desc\', \'ja_JP\', \'zh_CN\', \'日语\'),\n       (\'sys_constant_enum\', \'desc\', \'ja_JP\', \'en_US\', \'Japanese\'),\n\n       (\'sys_constant_enum\', \'desc\', \'ko_KR\', \'ko_KR\', \'한국어\'),\n       (\'sys_constant_enum\', \'desc\', \'ko_KR\', \'zh_CN\', \'韩语\'),\n       (\'sys_constant_enum\', \'desc\', \'ko_KR\', \'en_US\', \'Korean\'),\n\n       (\'sys_constant_enum\', \'desc\', \'ru_RU\', \'ru_RU\', \'русский язык\'),\n       (\'sys_constant_enum\', \'desc\', \'ru_RU\', \'zh_CN\', \'俄语\'),\n       (\'sys_constant_enum\', \'desc\', \'ru_RU\', \'en_US\', \'Russian\'),\n\n       (\'sys_constant_enum\', \'desc\', \'de_DE\', \'de_DE\', \'Deutsch\'),\n       (\'sys_constant_enum\', \'desc\', \'de_DE\', \'zh_CN\', \'德语\'),\n       (\'sys_constant_enum\', \'desc\', \'de_DE\', \'en_US\', \'German\'),\n\n       (\'sys_constant_enum\', \'desc\', \'es_ES\', \'es_ES\', \'Español\'),\n       (\'sys_constant_enum\', \'desc\', \'es_ES\', \'zh_CN\', \'西班牙语\'),\n       (\'sys_constant_enum\', \'desc\', \'es_ES\', \'en_US\', \'Spanish\'),\n\n       (\'sys_constant_enum\', \'desc\', \'fr_FR\', \'fr_FR\', \'Français\'),\n       (\'sys_constant_enum\', \'desc\', \'fr_FR\', \'zh_CN\', \'法语\'),\n       (\'sys_constant_enum\', \'desc\', \'fr_FR\', \'en_US\', \'Franch\'),\n\n       (\'sys_constant_enum\', \'desc\', \'it_IT\', \'it_IT\', \'Italiano\'),\n       (\'sys_constant_enum\', \'desc\', \'it_IT\', \'zh_CN\', \'意大利语\'),\n       (\'sys_constant_enum\', \'desc\', \'it_IT\', \'en_US\', \'Italian\'),\n\n       (\'sys_constant_enum\', \'desc\', \'th_TH\', \'th_TH\', \'ภาษาไทย\'),\n       (\'sys_constant_enum\', \'desc\', \'th_TH\', \'zh_CN\', \'泰国语\'),\n       (\'sys_constant_enum\', \'desc\', \'th_TH\', \'en_US\', \'Thai\'),\n\n       (\'sys_constant_enum\', \'desc\', \'ar_AE\', \'ar_AE\', \'عربي ،\'),\n       (\'sys_constant_enum\', \'desc\', \'ar_AE\', \'zh_CN\', \'阿拉伯联合酋长国\'),\n       (\'sys_constant_enum\', \'desc\', \'ar_AE\', \'en_US\', \'Arabic\'),\n\n       (\'sys_constant_enum\', \'desc\', \'en_US\', \'en_US\', \'English(US)\'),\n       (\'sys_constant_enum\', \'desc\', \'en_US\', \'zh_CN\', \'美国英语\');','DROP TABLE IF EXISTS `sys_constant_enum`;\nDROP TABLE IF EXISTS `sys_standard_i18n`;'),
(2019060101,'2020-06-13 22:38:07.000','1000-01-01 00:00:00.000',0,'1000-01-01 00:00:00.000','master/*-test.sql','-- apply@tst_.* error@stop\nCREATE TABLE `tst_中文也分表` (\n    `id`         BIGINT(20)  NOT NULL COMMENT \'主键\',\n    `create_dt`  DATETIME(3) NOT NULL DEFAULT NOW(3) COMMENT \'创建日时\',\n    `modify_dt`  DATETIME(3) NOT NULL DEFAULT \'1000-01-01\' ON UPDATE NOW(3) COMMENT \'修改日时\',\n    `delete_dt`  DATETIME(3) NOT NULL DEFAULT \'1000-01-01\' COMMENT \'标记删除\',\n    `commit_id`  BIGINT(20)  NOT NULL COMMENT \'提交ID\',\n    `login_info` TEXT COMMENT \'登陆信息，用户，终端等\',\n    `other_info` TEXT COMMENT \'其他信息，业务侧自定义\',\n    PRIMARY KEY (`id`)\n) ENGINE = InnoDB\n  DEFAULT CHARSET = utf8mb4 COMMENT =\'201/奇葩测试\';\n','DROP TABLE IF EXISTS `tst_中文也分表`;'),
(2019060102,'2020-06-13 22:38:08.000','1000-01-01 00:00:00.000',0,'1000-01-01 00:00:00.000','master/*-test.sql','-- @plain error@skip\nREPLACE INTO `tst_中文也分表`(`id`, `commit_id`, `login_info`, `other_info`)\nVALUES (100, -1, \'LOGIN_INFO-00\', \'OTHER_INFO-00\'),\n       (101, -1, \'LOGIN_INFO-01\', \'OTHER_INFO-01\'),\n       (102, -1, \'LOGIN_INFO-02\', \'OTHER_INFO-02\'),\n       (103, -1, \'LOGIN_INFO-03\', \'OTHER_INFO-03\'),\n       (104, -1, \'LOGIN_INFO-04\', \'OTHER_INFO-04\'),\n       (105, -1, \'LOGIN_INFO-05\', \'OTHER_INFO-05\'),\n       (106, -1, \'LOGIN_INFO-06\', \'OTHER_INFO-06\'),\n       (107, -1, \'LOGIN_INFO-07\', \'OTHER_INFO-07\'),\n       (108, -1, \'LOGIN_INFO-08\', \'OTHER_INFO-08\'),\n       (109, -1, \'LOGIN_INFO-09\', \'OTHER_INFO-09\'),\n       (110, -1, \'LOGIN_INFO-10\', \'OTHER_INFO-10\'),\n       (111, -1, \'LOGIN_INFO-11\', \'OTHER_INFO-11\'),\n       (112, -1, \'LOGIN_INFO-12\', \'OTHER_INFO-12\'),\n       (113, -1, \'LOGIN_INFO-13\', \'OTHER_INFO-13\'),\n       (114, -1, \'LOGIN_INFO-14\', \'OTHER_INFO-14\'),\n       (115, -1, \'LOGIN_INFO-15\', \'OTHER_INFO-15\'),\n       (116, -1, \'LOGIN_INFO-16\', \'OTHER_INFO-16\'),\n       (117, -1, \'LOGIN_INFO-17\', \'OTHER_INFO-17\'),\n       (118, -1, \'LOGIN_INFO-18\', \'OTHER_INFO-18\'),\n       (119, -1, \'LOGIN_INFO-19\', \'OTHER_INFO-19\');\n','-- @plain\nTRUNCATE `tst_中文也分表`;');

-- sys_standard_i18n DmlInsert
INSERT INTO `sys_standard_i18n`(`base`,`kind`,`ukey`,`lang`,`text`) VALUES 
('sys_constant_enum','desc','ar_AE','ar_AE','عربي ،'),
('sys_constant_enum','desc','ar_AE','en_US','Arabic'),
('sys_constant_enum','desc','ar_AE','zh_CN','阿拉伯联合酋长国'),
('sys_constant_enum','desc','de_DE','de_DE','Deutsch'),
('sys_constant_enum','desc','de_DE','en_US','German'),
('sys_constant_enum','desc','de_DE','zh_CN','德语'),
('sys_constant_enum','desc','en_US','en_US','English(US)'),
('sys_constant_enum','desc','en_US','zh_CN','美国英语'),
('sys_constant_enum','desc','es_ES','en_US','Spanish'),
('sys_constant_enum','desc','es_ES','es_ES','Español'),
('sys_constant_enum','desc','es_ES','zh_CN','西班牙语'),
('sys_constant_enum','desc','fr_FR','en_US','Franch'),
('sys_constant_enum','desc','fr_FR','fr_FR','Français'),
('sys_constant_enum','desc','fr_FR','zh_CN','法语'),
('sys_constant_enum','desc','id1010101','en_US','Greenwich Mean Time'),
('sys_constant_enum','desc','id1010101','zh_CN','格林威治时间(零时区)'),
('sys_constant_enum','desc','id1010201','en_US','China: BeiJing, ShangHai, HongKong'),
('sys_constant_enum','desc','id1010201','zh_CN','北京时间：北京、上海、香港'),
('sys_constant_enum','desc','id1010301','en_US','CST: Chicago, Houston'),
('sys_constant_enum','desc','id1010301','zh_CN','中部时(CST)：芝加哥、休斯顿'),
('sys_constant_enum','desc','id1010302','en_US','PST: L.A., Seattle'),
('sys_constant_enum','desc','id1010302','zh_CN','西部时间(PST)：西雅图、洛杉矶'),
('sys_constant_enum','desc','id1010303','en_US','EST: NewYork, D.C.'),
('sys_constant_enum','desc','id1010303','zh_CN','东部时(EST)：纽约、华盛顿'),
('sys_constant_enum','desc','id1010304','en_US','MST: Denver, Phoenix'),
('sys_constant_enum','desc','id1010304','zh_CN','山地时(MST)：丹佛、凤凰城'),
('sys_constant_enum','desc','id1010305','en_US','AKST: Alaska, Fairbanks'),
('sys_constant_enum','desc','id1010305','zh_CN','阿拉斯加时间(AKST)：安克雷奇'),
('sys_constant_enum','desc','id1010306','en_US','HST: Hawaii, Honolulu'),
('sys_constant_enum','desc','id1010306','zh_CN','夏威夷时间(HST)：火鲁奴奴'),
('sys_constant_enum','desc','id1010401','en_US','Indonesia：Jakarta, Surabaya、Medan'),
('sys_constant_enum','desc','id1010401','zh_CN','印度尼西亚：雅加达、泗水、棉兰'),
('sys_constant_enum','desc','id1010402','en_US','Indonesia：Jayapura、Manokwari'),
('sys_constant_enum','desc','id1010402','zh_CN','印度尼西亚：查亚普拉、马诺夸里'),
('sys_constant_enum','desc','id1010403','en_US','Indonesia：Makassar、Manado、Balikpapan'),
('sys_constant_enum','desc','id1010403','zh_CN','印度尼西亚：望加锡、万鸦老、阿克'),
('sys_constant_enum','desc','id1010501','en_US','Malaysia: KualaLumpur'),
('sys_constant_enum','desc','id1010501','zh_CN','马来西亚：吉隆坡'),
('sys_constant_enum','desc','id1010601','en_US','Korea: Seoul'),
('sys_constant_enum','desc','id1010601','zh_CN','韩国时间：首尔'),
('sys_constant_enum','desc','id1010701','en_US','Singapore'),
('sys_constant_enum','desc','id1010701','zh_CN','新加坡时间'),
('sys_constant_enum','desc','id1010801','en_US','Japan: Tokyo'),
('sys_constant_enum','desc','id1010801','zh_CN','日本时间：东京'),
('sys_constant_enum','desc','id1010901','en_US','AST: Halifax'),
('sys_constant_enum','desc','id1010901','zh_CN','大西洋时(AST)：哈利法克斯'),
('sys_constant_enum','desc','id1010902','en_US','CST: Winnipeg'),
('sys_constant_enum','desc','id1010902','zh_CN','中部时(CST)：温尼伯'),
('sys_constant_enum','desc','id1010903','en_US','EST: Toronto, Ottawa, Quebec'),
('sys_constant_enum','desc','id1010903','zh_CN','东部时(EST)：多伦多、渥太华、魁北克城'),
('sys_constant_enum','desc','id1010904','en_US','MST: Edmonton, Calgary'),
('sys_constant_enum','desc','id1010904','zh_CN','山地时(MST)：埃德蒙顿、卡尔加里'),
('sys_constant_enum','desc','id1010905','en_US','NST: St.John'),
('sys_constant_enum','desc','id1010905','zh_CN','纽芬兰时(NST)：圣约翰斯'),
('sys_constant_enum','desc','id1010906','en_US','PST: Vancouver'),
('sys_constant_enum','desc','id1010906','zh_CN','太平洋时(PST)：温哥华'),
('sys_constant_enum','desc','it_IT','en_US','Italian'),
('sys_constant_enum','desc','it_IT','it_IT','Italiano'),
('sys_constant_enum','desc','it_IT','zh_CN','意大利语'),
('sys_constant_enum','desc','ja_JP','en_US','Japanese'),
('sys_constant_enum','desc','ja_JP','ja_JP','日本語'),
('sys_constant_enum','desc','ja_JP','zh_CN','日语'),
('sys_constant_enum','desc','ko_KR','en_US','Korean'),
('sys_constant_enum','desc','ko_KR','ko_KR','한국어'),
('sys_constant_enum','desc','ko_KR','zh_CN','韩语'),
('sys_constant_enum','desc','ru_RU','en_US','Russian'),
('sys_constant_enum','desc','ru_RU','ru_RU','русский язык'),
('sys_constant_enum','desc','ru_RU','zh_CN','俄语'),
('sys_constant_enum','desc','th_TH','en_US','Thai'),
('sys_constant_enum','desc','th_TH','th_TH','ภาษาไทย'),
('sys_constant_enum','desc','th_TH','zh_CN','泰国语'),
('sys_constant_enum','desc','zh_CN','en_US','Simplified Chinese'),
('sys_constant_enum','desc','zh_CN','zh_CN','简体中文'),
('sys_constant_enum','desc','zh_HK','en_US','Traditional Chinese'),
('sys_constant_enum','desc','zh_HK','zh_CN','繁体中文'),
('sys_constant_enum','desc','zh_HK','zh_HK','繁體中文');

