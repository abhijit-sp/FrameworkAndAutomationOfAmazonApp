package project.factories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import project.pages.homepage.HomePage;
import project.pages.homepage.impl.HomePageLandscape;
import project.pages.homepage.impl.HomePagePortrait;

/*
    A factory that creates a portrait or landscape HomePage
    based on the screen orientation.
 */
public class HomePageFactory {

    public static HomePage getInstance(AndroidDriver<MobileElement> driver) {
        ScreenOrientation screenOrientation = driver.getOrientation();
        if (screenOrientation.equals(ScreenOrientation.LANDSCAPE)) {
            return new HomePageLandscape(driver);
        }
        return new HomePagePortrait(driver);
    }
}
