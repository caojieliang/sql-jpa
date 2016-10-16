package com.landian.sql.jpa.log;

import org.apache.log4j.Logger;

/**
 * date 15/09/25
 * 为了方便个人排错而建
 * 非本人不要使用
 */
public class JieLoggerProxy {

    private static final Logger infoSQLLogger = Logger.getLogger("infoSQL");
    private static final Logger infoJOBLogger = Logger.getLogger("infoJOB");
    private static final Logger errorCjlLogger = Logger.getLogger("errorCjl");
    private static final Logger warnCjlLogger = Logger.getLogger("warnCjl");
    private static final Logger infoCjlLogger = Logger.getLogger("infoCjl");

    public static void error(Logger logger, Exception e){
        if(null != errorCjlLogger){
            errorCjlLogger.error(e.getMessage(),e);
        }
        logger.error(e.getMessage(), e);
    }

    public static void error(Logger logger, String errorMsg){
        if(null != errorCjlLogger){
            errorCjlLogger.error(errorMsg);
        }
        logger.error(errorMsg);
    }

    public static String subErrorMsg(Exception e){
        String message = e.getMessage();
        String msg = "";
        if(null != message){
           msg = e.getMessage().length() > 1000 ? message.substring(0, 900) : e.getMessage();
        }
        return msg;
    }

    public static void infoSQL(Object object){
        if(null != infoSQLLogger){
            infoSQLLogger.info(object);
        }
    }

    public static void info(Object object){
        if(null != infoCjlLogger){
            infoCjlLogger.info(object);
        }
    }

    public static void infoJOB(Object object){
        if(null != infoJOBLogger){
            infoJOBLogger.info(object);
        }
    }

    public static void warn(Object message){
        warnCjlLogger.warn(message);
    }

    public static void deprecatedErrorInfo(Logger logger){
        String errorMsg = "此方法已过期不维护！！！";
        if(null != errorCjlLogger){
            errorCjlLogger.error(errorMsg);
        }
        logger.error(errorMsg);
    }
}
