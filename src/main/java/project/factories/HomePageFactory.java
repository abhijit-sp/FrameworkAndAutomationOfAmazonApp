package project.factories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import project.pages.homepage.HomePage;
import project.pages.homepage.impl.HomePageLandscape;
import project.pages.homepage.impl.HomePagePortrait;
import project.pages.welcome.WelcomePage;
import project.pages.welcome.impl.WelcomePageLandscape;
import project.pages.welcome.impl.WelcomePagePortrait;

public class HomePageFactory {

    private static HomePage homePage;

    public static HomePage getInstance(AndroidDriver<MobileElement> driver){
        ScreenOrientation screenOrientation = driver.getOrientation();
        if (screenOrientation.equals(ScreenOrientation.PORTRAIT)){
            homePage = new HomePagePortrait(driver);
        } else if (screenOrientation.equals(ScreenOrientation.LANDSCAPE)){
            homePage = new HomePageLandscape(driver);
        }
        return homePage;
    }
}
