package framework.utils.gestures;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

public class TouchActionsHelper {

    public static void scrollAList(AndroidDriver<MobileElement> driver, Point start, Point end, int numberOfTimes) {
        TouchAction touchAction = new TouchAction(driver);

        while (numberOfTimes-- > 0) {
            touchAction.longPress(PointOption.point(start))
                    .moveTo(PointOption.point(end))
                    .release()
                    .perform();
        }
    }

    public static Dimension getScreenDimensions(AndroidDriver<MobileElement> driver){
        return driver.manage().window().getSize();
    }

    public static int getScreenWidth(AndroidDriver<MobileElement> driver){
        return getScreenDimensions(driver).getWidth();
    }

    public static int getScreenHeight(AndroidDriver<MobileElement> driver){
        return getScreenDimensions(driver).getHeight();
    }
}
