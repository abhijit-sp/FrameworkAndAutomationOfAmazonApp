package project.factories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import project.pages.password.PasswordPage;
import project.pages.password.impl.PasswordPageLandscape;
import project.pages.password.impl.PasswordPagePortrait;

public class PasswordPageFactory {

    private static PasswordPage passwordPage;

    public static PasswordPage getInstance(AndroidDriver<MobileElement> driver){
        ScreenOrientation screenOrientation = driver.getOrientation();
        if (screenOrientation.equals(ScreenOrientation.PORTRAIT)){
            passwordPage = new PasswordPagePortrait(driver);
        } else if (screenOrientation.equals(ScreenOrientation.LANDSCAPE)){
            passwordPage = new PasswordPageLandscape(driver);
        }
        return passwordPage;
    }
}
