package project.pages.password;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import project.pages.BasePage;

public abstract class PasswordPage extends BasePage {

    public PasswordPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public abstract void enterPassword(String password);

    public abstract void clickLoginButton();

    public abstract void clickGetOTPButton();
}
