package project.factories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import project.pages.welcome.WelcomePage;
import project.pages.welcome.impl.WelcomePageLandscape;
import project.pages.welcome.impl.WelcomePagePortrait;

/*
    A factory that creates a portrait or landscape WelcomePage
    based on the screen orientation.
 */
public class WelcomePageFactory {

    public static WelcomePage getInstance(AndroidDriver<MobileElement> driver){
        ScreenOrientation screenOrientation = driver.getOrientation();
        if (screenOrientation.equals(ScreenOrientation.PORTRAIT)){
            return new WelcomePagePortrait(driver);
        } else if (screenOrientation.equals(ScreenOrientation.LANDSCAPE)){
            return new WelcomePageLandscape(driver);
        }
        return new WelcomePagePortrait(driver);
    }
}
