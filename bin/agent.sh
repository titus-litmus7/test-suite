#!/bin/sh

# setup basic paths 
AGENT_HOME=`pwd`
AGENT_CONFIG_DIR=$AGENT_HOME/config
cd "`dirname "$0"`/.."
XLT_HOME=`pwd`
export XLT_HOME
cd "$AGENT_HOME"

# setup Java class path
CP_PATCHES="$AGENT_HOME"/patches/classes:"$AGENT_HOME"/patches/lib/*
CP_XLT="$XLT_HOME"/target/classes:"$XLT_HOME"/lib/*
CP_STD="$AGENT_HOME"/classes:"$AGENT_HOME"/lib/*
CP_MVN="$AGENT_HOME"/target/classes:"$AGENT_HOME"/target/test-classes:"$AGENT_HOME"/target/dependency/*
CP_ECL="$AGENT_HOME"/bin
CLASSPATH="$CP_PATCHES":"$CP_XLT":"$CP_STD":"$CP_MVN":"$CP_ECL"

# setup other Java options
JAVA_OPTIONS=
#JAVA_OPTIONS="$JAVA_OPTIONS -Djava.endorsed.dirs=\"$XLT_HOME\""
JAVA_OPTIONS="$JAVA_OPTIONS -Dcom.xceptance.xlt.home=\"$XLT_HOME\""
JAVA_OPTIONS="$JAVA_OPTIONS -Dcom.xceptance.xlt.agent.home=\"$AGENT_HOME\""
JAVA_OPTIONS="$JAVA_OPTIONS -Dlog4j.configuration=\"file:$AGENT_CONFIG_DIR/log4j.properties\""
JAVA_OPTIONS="$JAVA_OPTIONS -Dorg.apache.xml.dtm.DTMManager=org.apache.xml.dtm.ref.DTMManagerDefault"
#JAVA_OPTIONS="$JAVA_OPTIONS -agentlib:jdwp=transport=dt_socket,address=localhost:6666,server=y,suspend=n"
JAVA_OPTIONS="$JAVA_OPTIONS -cp \"$CLASSPATH\""

# append custom Java options
JVM_CFG_FILE=$AGENT_CONFIG_DIR/jvmargs.cfg

if [ -f "$JVM_CFG_FILE" ]; then
    JAVA_OPTIONS=$JAVA_OPTIONS\ `cat "$JVM_CFG_FILE" | tr -d "\r" | cut -d# -f1`
fi

# run Java
CMD="java $JAVA_OPTIONS com.xceptance.xlt.agent.Main"
echo $CMD "$@" > results/agentCmdLine
ARGS=""
I=1
while [ $I -le $# ]; do
    eval x=\${$I}
    ARGS="$ARGS \"$x\""
    I=$((I+1))
done
eval $CMD "$ARGS"
