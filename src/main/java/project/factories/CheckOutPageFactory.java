package project.factories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import project.pages.checkoutpage.CheckOutPage;
import project.pages.checkoutpage.impl.CheckOutPageLandscape;
import project.pages.checkoutpage.impl.CheckOutPagePortrait;

/*
    A factory that creates a portrait or landscape CheckOutPage
    based on the screen orientation.
 */
public class CheckOutPageFactory {

    public static CheckOutPage getInstance(AndroidDriver<MobileElement> driver) {
        if (driver.getOrientation().equals(ScreenOrientation.LANDSCAPE)) {
            return new CheckOutPageLandscape(driver);
        }
        return new CheckOutPagePortrait(driver);
    }
}
