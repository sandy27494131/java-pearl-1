#/bin/bash

java -cp ../../../../ -Xms680M -Xmx680M -Xmn80M -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintTenuringDistribution -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCApplicationConcurrentTime -Xloggc:./gc.log com.robert.jvm.gc.CmsVsParallel 