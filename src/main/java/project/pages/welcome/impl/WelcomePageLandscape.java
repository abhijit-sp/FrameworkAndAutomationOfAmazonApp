package project.pages.welcome.impl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import project.pages.welcome.WelcomePage;

import java.time.temporal.ChronoUnit;

public class WelcomePageLandscape extends WelcomePage {

    public WelcomePageLandscape(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(className = "android.widget.EditText")
    @WithTimeout(time = 15, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement usernameOrEmailEditTextField;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/a-page\")).scrollIntoView(new UiSelector().textContains(\"Continue\"));")
    @WithTimeout(time = 15, chronoUnit = ChronoUnit.SECONDS)
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
