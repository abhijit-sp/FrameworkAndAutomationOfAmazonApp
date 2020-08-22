package framework.testconfig;

import io.appium.java_client.remote.MobileCapabilityType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CapabilitiesConfig {

    private static Map<String, Object> capabilitiesConfigMap = new HashMap<String, Object>();
    private static final String PLATFORM_NAME = MobileCapabilityType.PLATFORM_NAME;
    private static final String AUTOMATION_NAME = MobileCapabilityType.AUTOMATION_NAME;
    private static final String NO_RESET = "noReset";
    private static final String FULL_RESET = "fullReset";

    public static Map<String, Object> getCapabilitiesConfig() throws IOException {
        Properties properties = PropertiesReader.loadProperties(new FileInputStream("src/main/resources/capabilities.properties"));

        String platformNameValue = properties.getProperty("platform.name");
        String automationNameValue = properties.getProperty("automation.name");
        Boolean noResetValue = Boolean.getBoolean(properties.getProperty("noReset"));
        Boolean fullResetValue = Boolean.getBoolean(properties.getProperty("fullReset"));

        capabilitiesConfigMap.put(PLATFORM_NAME, platformNameValue);
        capabilitiesConfigMap.put(AUTOMATION_NAME, automationNameValue);
        capabilitiesConfigMap.put(NO_RESET, noResetValue);
        capabilitiesConfigMap.put(FULL_RESET, fullResetValue);

        return capabilitiesConfigMap;
    }
}