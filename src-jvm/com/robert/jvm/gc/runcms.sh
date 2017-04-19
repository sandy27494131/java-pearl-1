#/bin/bash

java -cp ../../../../ -Xms680M -Xmx680M -Xmn80M -XX:+UseConcMarkSweepGC -XX:+UseCMSCompactAtFullCollection -XX:+UseParNewGC -XX:CMSMaxAbortablePrecleanTime=5 -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintTenuringDistribution -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCApplicationConcurrentTime -Xloggc:./gc.log com.robert.jvm.gc.CmsVsParallel 