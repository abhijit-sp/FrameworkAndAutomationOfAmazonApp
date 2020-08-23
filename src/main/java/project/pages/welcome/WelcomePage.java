package project.pages.welcome;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import project.pages.BasePage;

import java.time.temporal.ChronoUnit;

public abstract class WelcomePage extends BasePage {


    public WelcomePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public abstract void enterUsernameOrEmail(String usernameOrEmail);

    public abstract void clickContinueButton();
}
