package managers;

import dataProviders.ConfigFileReader;

/**
 * This class provides a common place which returns a Reader for all file types.
 */

public class FileReaderManager {

    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;

    private FileReaderManager() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static FileReaderManager getInstance( ) {
        return fileReaderManager;
    }

    /**
     * Gets config reader.
     *
     * @return the config reader
     */
    public static ConfigFileReader getConfigReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }
}
