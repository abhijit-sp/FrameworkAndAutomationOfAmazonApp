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
        String noResetValue = properties.getProperty("noReset");
        String fullResetValue = properties.getProperty("fullReset");
        if (!noResetValue.isEmpty()) {
            capabilitiesConfigMap.put(NO_RESET, Boolean.parseBoolean(noResetValue));
        }
        if (!noResetValue.isEmpty()) {
            capabilitiesConfigMap.put(FULL_RESET, Boolean.parseBoolean(fullResetValue));
        }

        capabilitiesConfigMap.put(PLATFORM_NAME, platformNameValue);
        capabilitiesConfigMap.put(AUTOMATION_NAME, automationNameValue);

        System.out.println(capabilitiesConfigMap.toString());
        return capabilitiesConfigMap;
    }
}