package project.pages.password.impl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import project.pages.password.PasswordPage;

import java.time.temporal.ChronoUnit;

/*
A concrete implementation of the PasswordPage in landscape mode.
 */
public class PasswordPageLandscape extends PasswordPage {


    public PasswordPageLandscape(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(className = "android.widget.EditText")
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement passwordField;

    @AndroidFindBy(className = "android.widget.Button")
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement loginButton;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/a-page\")).scrollIntoView(new UiSelector().textContains(\"Get an OTP on your phone\"));")
    @WithTimeout(time = 15, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement getOTPButton;

    @Override
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    @Override
    public void clickLoginButton() {
        loginButton.click();
    }

    @Override
    public void clickGetOTPButton() {
        getOTPButton.click();
    }
}
