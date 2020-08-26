package project.pages.signinoptions.impl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import project.pages.signinoptions.SignInOptionsPage;

import java.time.temporal.ChronoUnit;

/*
A concrete implementation of the SignInOptionsPage portrait mode.
 */
public class SignInOptionsPortraitPage extends SignInOptionsPage {

    public SignInOptionsPortraitPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "sign_in_button")
    @WithTimeout(time = 15, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement signInButton;

    @AndroidFindBy(id = "skip_sign_in_button")
    @WithTimeout(time = 15, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement skipSignInButton;

    @Override
    public void clickSignInButton() {
        signInButton.click();
    }

    @Override
    public void clickSkipSignInButton() {
        skipSignInButton.click();
    }
}
