package project.factories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import project.pages.signinoptions.SignInOptionsPage;
import project.pages.signinoptions.impl.SignInOptionsLandscapePage;
import project.pages.signinoptions.impl.SignInOptionsPortraitPage;

/*
    A factory that creates a portrait or landscape SignInOptionsPage
    based on the screen orientation.
 */
public class SignInOptionsPageFactory {

    public static SignInOptionsPage getInstance(AndroidDriver<MobileElement> driver){
        if (driver.getOrientation().equals(ScreenOrientation.PORTRAIT)){
            return new SignInOptionsPortraitPage(driver);
        } else if(driver.getOrientation().equals(ScreenOrientation.LANDSCAPE)){
            return new SignInOptionsLandscapePage(driver);
        }
        return new SignInOptionsPortraitPage(driver);
    }
}
