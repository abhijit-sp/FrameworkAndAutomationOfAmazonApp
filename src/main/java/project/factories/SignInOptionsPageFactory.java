package project.factories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import project.pages.signinoptions.SignInOptionsPage;
import project.pages.signinoptions.impl.SignInOptionsLandscapePage;
import project.pages.signinoptions.impl.SignInOptionsPortraitPage;

public class SignInOptionsPageFactory {

    private static SignInOptionsPage signInOptionsPage;

    public static SignInOptionsPage getInstance(AndroidDriver<MobileElement> driver){
        if (driver.getOrientation().equals(ScreenOrientation.PORTRAIT)){
            signInOptionsPage = new SignInOptionsPortraitPage(driver);
        } else if(driver.getOrientation().equals(ScreenOrientation.LANDSCAPE)){
            signInOptionsPage =  new SignInOptionsLandscapePage(driver);
        }
        return signInOptionsPage;
    }
}
