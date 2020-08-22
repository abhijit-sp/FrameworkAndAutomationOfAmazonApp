package framework.testconfig;

import io.appium.java_client.remote.MobileCapabilityType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DeviceConfig {

    private static Map<String, Object> deviceConfigMap = new HashMap<String, Object>();
    private static final String DEVICE_NAME = MobileCapabilityType.DEVICE_NAME;
    private static final String DEVICE_UDID = MobileCapabilityType.UDID;

    public static Map<String, Object> getDeviceConfig() throws IOException {
        Properties properties = PropertiesReader.loadProperties(new FileInputStream("src/main/resources/device.properties"));
        String deviceNameValue = properties.getProperty("device.name");
        String deviceUDIDValue = properties.getProperty("device.udid");

        deviceConfigMap.put(DEVICE_NAME, deviceNameValue);
        deviceConfigMap.put(DEVICE_UDID, deviceUDIDValue);

        return deviceConfigMap;
    }
}
