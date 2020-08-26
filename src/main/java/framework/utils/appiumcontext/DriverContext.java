package framework.utils.appiumcontext;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import javax.annotation.Nullable;
import java.util.Set;

/**
 * This class helps in retrieving different contexts present at the time of automation.
 */
public class DriverContext {

    /**
     *  This method is used to get he web context value
     * @param driver accepts an AndroidDriver
     * @return The web context string value
     */
    @Nullable
    public static String getWebContextString(AndroidDriver<MobileElement> driver){
        Set<String> contexts = driver.getContextHandles();
        for(String currentContext : contexts){
            if(!currentContext.equals("NATIVE_APP")){
                return currentContext;
            }
        }
        return null;

    }
}
