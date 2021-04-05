package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


/**
 * This class provides a list of methods that can be used to read the properties from the
 * src/configs/Configuration.properties file.
 */
public class ConfigFileReader {
    private final Properties properties;
    private final String propertyFilePath = "src/configs/Configuration.properties";


    /**
     * Instantiates a new Config file reader.
     */
    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    /**
     * Gets driver path.
     *
     * @return the driver path
     */
    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null) return driverPath;
        else
            throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");
    }

    /**
     * Gets firefox executable path.
     *
     * @return the firefox executable path
     */
    public String getFirefoxExecutablePath() {
        String firefoxExecutable = properties.getProperty("pathToFirefoxExecutable");
        if (firefoxExecutable != null) return firefoxExecutable;
        else
            throw new RuntimeException("Firefox executable path not specified in the Configuration.properties file for the Key:pathToFirefoxExecutable");
    }

    /**
     * Gets browser.
     *
     * @return the browser
     */
    public String getBrowser() {
        String browserName = properties.getProperty("browser");
        if (browserName == null || browserName.equals("chrome")) return "CHROME";
        else if (browserName.equalsIgnoreCase("firefox")) return "FIREFOX";
        else if (browserName.equalsIgnoreCase("ie")) return "IE";
        else
            throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

    /**
     * Gets app url.
     *
     * @return app url
     */
    public String getAppUrl() {
        return properties.getProperty("appUrl");
    }

    /**
     * Gets log level.
     *
     * @return the log level
     */
    public String getLogLevel() {
        return properties.getProperty("logLevel");
    }


    /**
     * Gets max wait in seconds.
     *
     * @return the max wait in seconds
     */
    public int getMaxWaitInSeconds() {
        int maxWait = Integer.parseInt(properties.getProperty("maxWait"));
        return maxWait;
    }
}