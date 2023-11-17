#!/bin/bash
THIS_VERSION=2023-05-25

cat <<EOF
#################################################
# Version $THIS_VERSION # for Mac&Lin
# use 'ln -s' to link this script to the execution 'target/workdir', and,
# the same basename '.env' (wings-release.env) will be auto loaded.
# If PACK_JAR is directory, SUB_FLAT determines the overwrite behavior.
#################################################
EOF
################ modify the following params ################
USER_RUN="$USER"                                   # the user to execute the script
WORK_DIR=''                                        # work dir, ie. project dir
DEST_DIR=''                                        # target list, local or remote directory [user@]host:[path] or scp://[user@]host[:port][/path]
PACK_JAR='*.jar'                                   # list of packaged files or directories
SUB_FLAT=true                                      # if the target is a directory, transfer its contents or the entire directory
SCP_ARGS=''                                        # common scp arguments
PRE_PACK=''                                        # command to execute before `pack`
PRE_PUSH=''                                        # command to execute before `push`, support for `$_JAR` variable
MVN_PACK='-U -Dmaven.test.skip=true clean compile package' # mvn package
JDK_HOME=''                                        # mvn jdk version
WEB_PACK='build'                                   # package command of web

################ NO NEED to modify the following ################
function check_cmd() {
    if ! which "$1" >/dev/null; then
        echo -e "\033[31mERROR: need command $1 \033[0m"
        exit
    fi
}

function _pre_pack() {
    if [[ "$PRE_PACK" != "" ]]; then
        _pcm=$(eval "echo \"$PRE_PACK\"")
        echo -e "\033[37;42;1m ==== PRE_PACK $_pcm \033[0m"
        if ! eval "$_pcm"; then
            echo -e "\033[31mERROR: failed PRE_PACK \033[0m"
            exit
        fi
    fi
}

function _pre_push() {
    if [[ "$PRE_PUSH" != "" ]]; then
        _JAR=$1
        _pcm=$(eval "echo \"$PRE_PUSH\"")
        echo -e "\033[37;42;1m ==== PRE_PUSH $_pcm \033[0m"
        if ! eval "$_pcm"; then
            echo -e "\033[31mERROR: failed PRE_PUSH $_JAR \033[0m"
            exit
        fi
    fi
}

function build_mvn() {
    # java home & path
    if [[ "$JDK_HOME" != "" && "$JDK_HOME" != "$JAVA_HOME" ]]; then
        PATH=$JDK_HOME/bin:$PATH
        JAVA_HOME=$JDK_HOME
        echo -e "\033[37;42;1mINFO: ==== JAVA_HOME=$JAVA_HOME ==== \033[0m"
    fi

    check_cmd mvn
    check_cmd git

    echo -e "\033[37;42;1m ==== Compile $WORK_DIR ==== \033[0m"
    _pre_pack

    _git_log="git-log.txt"
    _res_log="git-log.tmp"
    echo '#Generated by Wings Release Script' >$_git_log
    git branch -v >>$_git_log
    git log --pretty=format:'%H - %an, %ad %d : %s' --graph -10 >>$_git_log
    find . -type d -name 'resources' | grep '/src/main/' | while read -r res; do
        echo "$res" >>$_res_log
        cp $_git_log "$res/"
    done

    echo -e "\033[37;42;1m ==== Package $WORK_DIR ==== \033[0m"
    # shellcheck disable=SC2086
    mvn $MVN_PACK

    echo -e "\033[37;42;1m ==== GitLogs $WORK_DIR ==== \033[0m"
    cat "$_git_log"
    echo
    echo -e "\033[32m ==== git-log into ==== \033[0m"
    cat "$_res_log"
    echo -e "\033[32m ==== git status ==== \033[0m"
    rm -f "$_git_log" "$_res_log"
    git status
    echo -e "\033[32m ==== mvn version ==== \033[0m"
    mvn --version
}

function build_web() {
    # node version
    if [[ -f ".nvmrc" ]]; then
        # shellcheck disable=SC1090
        source ~/.nvm/nvm.sh
        nvm use
    fi

    _pre_pack

    _cmd=$1
    if [[ "$_cmd" == "" ]]; then
        if [[ -f "pnpm-lock.yaml" ]]; then
            _cmd=pnpm
        elif [[ -f "yarn.lock" ]]; then
            _cmd=yarn
        elif [[ -f "package-lock.json" ]]; then
            _cmd=npm
        fi
    fi

    # build
    echo -e "\033[32m web pack $_cmd \033[m"
    if [[ "$_cmd" == "pnpm" ]]; then
        pnpm install
        pnpm $WEB_PACK
    elif [[ "$_cmd" == "yarn" ]]; then
        yarn install
        yarn $WEB_PACK
    elif [[ "$_cmd" == "npm" ]]; then
        npm install
        npm run $WEB_PACK
    else
        echo -e "\033[31mWARN: skip unknown command $_cmd \033[0m"
    fi

    # git hash
    echo -e "\033[37;42;1m ==== GitHash $WORK_DIR ==== \033[0m"
    check_cmd git
    _ver=$(git log --pretty=format:'%H - %ad %d' -1)
    for _jar in $PACK_JAR; do
        if [[ -d "$_jar" ]]; then
            find "$_jar" -maxdepth 1 -name 'index.html' | while read -r _idx; do
                echo -e "append git hash to $_idx"
                echo "<!-- WingsGitHash $_ver -->" >>"$_idx"
            done
        else
            echo "skip append git hash to $_jar"
        fi
    done

    echo -e "\033[32m ==== node version ==== \033[0m"
    node --version
    echo -e "\033[32m ==== $_cmd version ==== \033[0m"
    $_cmd --version
}

function build_auto() {

    # only pre
    if [[ "$1" == "pre" ]]; then
        _pre_pack
        exit
    fi

    # mvn
    if [[ -f "pom.xml" || "$1" == "mvn" ]]; then
        build_mvn
        return
    fi
    # web
    if [[ -f "package.json" ]]; then
        build_web "$1"
        return
    fi

    echo -e "\033[31mERROR: unknown build type \033[0m"
}

#############
# load env
echo -e "\033[37;42;1mINFO: ==== boot env ==== \033[0m"
this_file="$0"
if [[ -L "$this_file" ]]; then
    link_file=$(realpath "$this_file")
    link_envs=${link_file%.*}.env
    if [[ -f "$link_envs" ]]; then
        echo "env-link=$link_envs"
        # shellcheck disable=SC1090
        source "$link_envs"
    fi
fi

this_envs=${this_file%.*}.env
if [[ -f "$this_envs" ]]; then
    echo "env-file=$this_envs"
    # shellcheck disable=SC1090
    source "$this_envs"
else
    echo -e "\033[31mERROR: no env file found. $this_envs \033[0m"
    exit
fi

if [[ "$USER_RUN" != "$USER" ]]; then
    echo -e "\033[37;41;1mERROR: need user $USER_RUN to run \033[0m"
    exit
fi

# change workdir
if [[ "$WORK_DIR" == "" ]]; then
    WORK_DIR=$(dirname "$this_file")
fi
cd "$WORK_DIR" || exit
WORK_DIR=$(realpath -s "$WORK_DIR")
echo "work-dir=$WORK_DIR"

# check arg
case "$1" in
    pull)
        check_cmd git

        echo -e "\033[37;42;1m ==== PULL $WORK_DIR ==== \033[0m"
        git pull
        echo -e "\033[37;42;1m ==== DONE $WORK_DIR ==== \033[0m"
        git status
        git log --pretty=format:'%H - %an, %ad %d : %s' --graph -10
        ;;
    pack)
        echo -e "\033[37;42;1m ==== BUILD $WORK_DIR ==== \033[0m"
        build_auto "$2"
        ;;
    push)
        echo -e "\033[37;42;1m ==== SEEK package ==== \033[0m"
        _jar_need=""
        _jar_info=""
        _yna="n"
        for _jar in $PACK_JAR; do
            _tmp=""
            if [[ -f "$_jar" || -d "$_jar" ]]; then
                _tmp=$_jar
            else
                _tmp=$(find . -type f -name "$_jar")
                if [[ ! -f "$_tmp" ]]; then
                    echo -e "\033[31mERROR: not file. $_jar \033[0m"
                    _jar_info="$_jar_info skip \033[31m $_jar \033[m => not find\n"
                    continue
                fi
            fi

            _rp=$(realpath "$_tmp")
            if [[ "$_yna" != "a" ]]; then
                echo -e "[y/n/a]? \033[32m $_jar \033[m => $_rp"
                read -r _yna </dev/tty
            fi

            if [[ "$_yna" != "n" ]]; then
                _pre_push "$_tmp"
                _jar_need="$_jar_need $_tmp"
                _jar_info="$_jar_info need \033[32m $_jar \033[m => $_rp\n"
            else
                _jar_info="$_jar_info skip \033[33m $_jar \033[m => $_rp\n"
            fi
        done

        echo -e "\033[37;42;1m ==== LIST package ==== \033[0m"
        echo -e "$_jar_info"

        if [[ "$2" == "pre" || "$_jar_need" == "" ]]; then
            echo -e "\033[31mERROR: not file to push \033[0m"
            exit
        fi

        _yna="n"
        echo -e "\033[37;42;1m ==== PUSH package ==== \033[0m"
        for _dst in $DEST_DIR; do
            if [[ "$_yna" != "a" ]]; then
                echo -e "[y/n/a]? \033[32m $_dst \033[m"
                read -r _yna </dev/tty
            fi
            if [[ "$_yna" == "n" ]]; then
                continue
            fi

            for _jar in $_jar_need; do
                _cmd="cp -r"
                _tgt=$_dst
                if [[ ! -d "$_dst" ]]; then
                    _cmd="scp -r $SCP_ARGS"
                    # [user@]host:[path] scp://[user@]host[:port][/path]
                    if [[ $_dst =~ scp:// && "$(man scp | grep scp://)" == "" ]]; then
                        pt=$(echo "$_dst" | sed -E 's=scp://([^:]*:)([0-9]*)(.*)=\2=')
                        if [[ $pt =~ ^[0-9]+$ ]]; then
                            _cmd="$_cmd -P $pt"
                            _tgt=$(echo "$_dst" | sed -E 's=scp://([^:]*:)([0-9]*)(.*)=\1\3=')
                        fi
                    fi
                fi
                echo "$_jar => $_dst"
                if [[ -d "$_jar" && "$SUB_FLAT" == "true" ]]; then
                    # shellcheck disable=SC2086
                    $_cmd $_jar/* "$_tgt"
                else
                    # shellcheck disable=SC2086
                    $_cmd $_jar "$_tgt"
                fi
            done
        done
        ;;
    *)
        echo -e '\033[37;42;1mNOTE: help info, use the following\033[m'
        echo -e '\033[32m pull \033[m git pull remote'
        echo -e '\033[32m pack \033[m auto mvn/npm/yarn/pnpm '
        echo -e '\033[32m pack mvn \033[m mvn clean compile package'
        echo -e '\033[32m pack npm \033[m npm build'
        echo -e '\033[32m pack pnpm \033[m pnpm build'
        echo -e '\033[32m pack yarn \033[m yarn build'
        echo -e '\033[32m pack pre \033[m only exec PRE_PACK'
        echo -e '\033[32m push \033[m push to dest'
        echo -e '\033[32m push pre \033[m only exec PRE_PUSH'
        ;;
esac
echo
