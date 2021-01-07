package com.buaa.bbq.common;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Priority;

//log4j配置文件
public class Log4jMyAppender extends DailyRollingFileAppender {

    @Override
    public boolean isAsSevereAsThreshold(Priority priority) {
        //只判断是否相等，而不判断优先级
        return this.getThreshold().equals(priority);
    }

}
