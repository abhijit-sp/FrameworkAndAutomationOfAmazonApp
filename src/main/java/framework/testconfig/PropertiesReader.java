package framework.testconfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static Properties properties;

    public static Properties loadProperties(FileInputStream fileInputStream) throws IOException {
        properties = new Properties();
        properties.load(fileInputStream);
        return properties;
    }
}
