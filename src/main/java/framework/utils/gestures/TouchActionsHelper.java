package framework.utils.gestures;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

/**
 * A helper class which acts as a wrapper around TouchAction methods provided
 * by Appium to perform various mobile gestures.
 */
public class TouchActionsHelper {

    /**
     * Scrolls a list up or down one or more times based
     * on starting and ending points provided.
     * @param driver AndroidDriver
     * @param start The coordinates of the starting point.
     * @param end The coordinates of the ending point.
     * @param numberOfTimes The number of times to be scrolled.
     */
    public static void scrollAList(AndroidDriver<MobileElement> driver, Point start, Point end, int numberOfTimes) {
        TouchAction touchAction = new TouchAction(driver);

        while (numberOfTimes-- > 0) {
            touchAction.longPress(PointOption.point(start))
                    .moveTo(PointOption.point(end))
                    .release()
                    .perform();
        }
    }

    /**
     *  Scrolls down a list slowly multiple times starting from a UI element.
     * @param driver AndroidDriver
     * @param start A MobileElement from where the scrolling should start.
     * @param numberOfTimes Nn int values of how times scrolling should take place.
     */
    public static void scrollDownAList(AndroidDriver<MobileElement> driver, MobileElement start, int numberOfTimes) {
        TouchAction touchAction = new TouchAction(driver);

        while (numberOfTimes-- > 0) {
            touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(start)))
                    .moveTo(PointOption.point(0, 0))
                    .release()
                    .perform();
        }
    }

    /**
     *  Retrieves the screen dimensions of the mobile device.
     * @param driver AndroidDriver
     * @return Dimension object containing the dimensions of the screen.
     */
    public static Dimension getScreenDimensions(AndroidDriver<MobileElement> driver) {
        return driver.manage().window().getSize();
    }

    /**
     * Retrieves the X axis (width) of the mobile screen.
     * @param driver AndroidDriver
     * @return int value of the X axis length of the screen.
     */
    public static int getScreenWidth(AndroidDriver<MobileElement> driver) {
        return getScreenDimensions(driver).getWidth();
    }

    /**
     *  Retrieves the Y axis (height) of the mobile screen.
     * @param driver AndroidDriver
     * @return int value of the Y axis length of the screen.
     */
    public static int getScreenHeight(AndroidDriver<MobileElement> driver) {
        return getScreenDimensions(driver).getHeight();
    }
}
