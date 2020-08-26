package framework.utils.wait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * A helper class to wait for UI transitions during automation.
 */
public class WaitHelper {

    /**
     *  Explicit wait for a defined duration of time.
     * @param millis long value defining time in milli seconds.
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Implicit wait until an element appears on the screen.
     * @param driver AndroidDriver
     * @param seconds long value of maximum seconds to wait.
     * @param element MobileElement the element to wait for.
     * @return WebElement The element that appeared on the UI after the wait.
     */
    public static WebElement waitUntilVisibilityOfElement(AndroidDriver<MobileElement> driver, long seconds, MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
