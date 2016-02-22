package net.sunmingchun.www.base.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by smc on 2015/12/6.
 */
public final class LogFactory {


    public static Logger getLogger(String logName){
        return LoggerFactory.getLogger(logName);
    }

    public static Logger getLogger(Class  logClass){
        return LoggerFactory.getLogger(logClass);
    }
}
