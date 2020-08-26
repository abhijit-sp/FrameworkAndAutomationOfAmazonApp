package project.factories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import project.pages.password.PasswordPage;
import project.pages.password.impl.PasswordPageLandscape;
import project.pages.password.impl.PasswordPagePortrait;

/*
    A factory that creates a portrait or landscape PaswordPage
    based on the screen orientation.
 */
public class PasswordPageFactory {

    public static PasswordPage getInstance(AndroidDriver<MobileElement> driver) {
        ScreenOrientation screenOrientation = driver.getOrientation();
        if (screenOrientation.equals(ScreenOrientation.LANDSCAPE)) {
            return new PasswordPageLandscape(driver);
        }
        return new PasswordPagePortrait(driver);
    }
}
