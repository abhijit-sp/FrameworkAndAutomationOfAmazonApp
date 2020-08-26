package framework.driver;


import framework.testconfig.AppConfig;
import framework.testconfig.CapabilitiesConfig;
import framework.testconfig.DeviceConfig;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

/**
 * This class creates an AndroidDriver by setting the user mention desired capabilities from configuration files.
 */

public class Driver {

    private static AndroidDriver<MobileElement> driver;
    private static Set<Map.Entry<String, Object>> capabilitiesConfig;
    private static Set<Map.Entry<String, Object>> deviceConfig;
    private static Set<Map.Entry<String, Object>> appConfig;

    /**
     *
     * @return AndroidDriver
     */
    public static AndroidDriver<MobileElement> getDriver() {

        DesiredCapabilities caps = new DesiredCapabilities();
        try {
            capabilitiesConfig = CapabilitiesConfig.getCapabilitiesConfig().entrySet();
            deviceConfig = DeviceConfig.getDeviceConfig().entrySet();
            appConfig = AppConfig.getAppConfig().entrySet();
        } catch (IOException e) {
        }

        for (Map.Entry<String, Object> currentCapability : capabilitiesConfig) {
            caps.setCapability(currentCapability.getKey(), currentCapability.getValue());
        }
        for (Map.Entry<String, Object> currentCapability : deviceConfig) {
            caps.setCapability(currentCapability.getKey(), currentCapability.getValue());
        }
        for (Map.Entry<String, Object> currentCapability : appConfig) {
            caps.setCapability(currentCapability.getKey(), currentCapability.getValue());
        }

        try {
            URL url = new URL("http://localhost:4725/wd/hub");
            driver = new AndroidDriver<MobileElement>(url, caps);
        } catch (MalformedURLException e) {
        }
        return driver;
    }
}

