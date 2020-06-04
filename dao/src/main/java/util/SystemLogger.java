package util;

import org.apache.log4j.Logger;

/**
 * Class for logging all exceptions in app
 */
public class SystemLogger {
    private Logger logger;
    private static SystemLogger instance;

    private SystemLogger() {
    }

    public static synchronized SystemLogger getInstance() {
        if (instance == null) {
            instance = new SystemLogger();
        }
        return instance;
    }

    public void setLogger(Class sender, Throwable e) {
        logger = Logger.getLogger(sender);
        logger.error(e);

    }
}
