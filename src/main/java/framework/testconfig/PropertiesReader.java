package framework.testconfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * A helper class to read properties files.
 */
public class PropertiesReader {

    private static Properties properties;

    /**
     * This method reads and returns the properties defined in a properties file.
     * @param fileInputStream
     * @return Properties object containing all the properties defined in a file.
     * @throws IOException
     */
    public static Properties loadProperties(FileInputStream fileInputStream) throws IOException {
        properties = new Properties();
        properties.load(fileInputStream);
        return properties;
    }
}
