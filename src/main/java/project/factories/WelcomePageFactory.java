package project.factories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import project.pages.welcome.WelcomePage;
import project.pages.welcome.impl.WelcomePageLandscape;
import project.pages.welcome.impl.WelcomePagePortrait;

public class WelcomePageFactory {

    private static WelcomePage welcomePage;

    public static WelcomePage getInstance(AndroidDriver<MobileElement> driver){
        ScreenOrientation screenOrientation = driver.getOrientation();
        if (screenOrientation.equals(ScreenOrientation.PORTRAIT)){
            welcomePage = new WelcomePagePortrait(driver);
        } else if (screenOrientation.equals(ScreenOrientation.LANDSCAPE)){
            welcomePage = new WelcomePageLandscape(driver);
        }
        return welcomePage;
    }
}
