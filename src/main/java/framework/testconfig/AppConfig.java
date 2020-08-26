package framework.testconfig;

import io.appium.java_client.remote.MobileCapabilityType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *  This class helps in retrieving all the app related configuration desired and defined by the user.
 */
public class AppConfig {

    private static Map<String, Object> appConfigMap = new HashMap<String, Object>();
    private static final String APP_PATH = MobileCapabilityType.APP;

    /**
     *  This method retrieves the app config defined in app.properties
     * @return Map of user defined properties and respective values
     * @throws IOException
     */
    public static Map<String, Object> getAppConfig() throws IOException {
        Properties properties = PropertiesReader.loadProperties(new FileInputStream("src/main/resources/app.properties"));

        String appPathValue = properties.getProperty("app.path");

        appConfigMap.put(APP_PATH, appPathValue);

        return appConfigMap;
    }
}
