#!/bin/bash
jar_name='interface-0.1.0.jar'
echo 'kill interface-0.1.0.jar start...'
if [ $(pgrep -f ${jar_name} | wc -l) -gt 0 ]; then
  pkill -9 -f ${jar_name}
fi
echo 'start interface-0.1.0.jar ...'
nohup java -jar target/${jar_name} &
sleep 3
echo 'start success...!'
