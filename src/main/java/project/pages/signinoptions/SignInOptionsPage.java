package project.pages.signinoptions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import project.pages.BasePage;

import java.time.temporal.ChronoUnit;

/*
A generic representation of the sign in options screen.
 */
public abstract class SignInOptionsPage extends BasePage {

    public SignInOptionsPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public abstract void clickSignInButton();
    public abstract void clickSkipSignInButton();
}
