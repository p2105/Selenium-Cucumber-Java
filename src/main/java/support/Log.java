package support;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * This the configuration class for Log4j.
 * Log4j properties files is present at the project's root folder log4j.properties
 * A new log file with the naming format "Log_dd-mm-yyyy-hh-mm-ss.log" will be created for each run
 * Its the user's responsibility to delete the old unwanted logs
 */

public class Log {

// Initialize Log4j logs

    private static Logger Log = Logger.getLogger(Log.class.getName());//


    /**
     * Sets log level.
     *
     * @param level the level
     */
    public static void setLogLevel(String level) {
        switch (level.toUpperCase()){
            case "DEBUG":
                Logger.getRootLogger().setLevel(Level.DEBUG);
                break;
            case "INFO":
                Logger.getRootLogger().setLevel(Level.INFO);
                break;
            default:
                throw new RuntimeException("Supported Log levels are INFO and DEBUG. Pls put the correct log" +
                        "level in the file src/configs/Configuration.properties");
        }

    }

    /**
     * Start test case.
     *
     * @param sTestCaseName the test case name
     */
    public static void startTestCase(String sTestCaseName) {

        Log.info("****************************************************************************************");
        Log.info("#######################       " + sTestCaseName + "       #######################");
        Log.info("****************************************************************************************");

    }

    /**
     * End test case.
     */
    public static void endTestCase() {
        Log.info("****************************************************************************************");
        Log.info("#######################       " + "-E---N---D-" + "       #######################");
        Log.info("****************************************************************************************");

    }

    /**
     * Info.
     *
     * @param message the message
     */
    public static void info(String message) {

        Log.info(message);

    }

    /**
     * Warn.
     *
     * @param message the message
     */
    public static void warn(String message) {

        Log.warn(message);

    }

    /**
     * Error.
     *
     * @param message the message
     */
    public static void error(String message) {

        Log.error(message);

    }

    /**
     * Fatal.
     *
     * @param message the message
     */
    public static void fatal(String message) {

        Log.fatal(message);

    }

    /**
     * Debug.
     *
     * @param message the message
     */
    public static void debug(String message) {

        Log.debug(message);

    }

}
