package project.pages.welcome.impl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import project.pages.welcome.WelcomePage;

import java.time.temporal.ChronoUnit;
/*
A concrete implementation of the WelcomePage portrait mode.
 */
public class WelcomePagePortrait extends WelcomePage {

    public WelcomePagePortrait(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(className = "android.widget.EditText")
    @WithTimeout(time = 15, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement usernameOrEmailEditTextField;

    @AndroidFindBy(className = "android.widget.Button")
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement continueButton;

    @Override
    public void enterUsernameOrEmail(String usernameOrEmail) {
        usernameOrEmailEditTextField.sendKeys(usernameOrEmail);
    }

    @Override
    public void clickContinueButton() {
        continueButton.click();
    }
}
