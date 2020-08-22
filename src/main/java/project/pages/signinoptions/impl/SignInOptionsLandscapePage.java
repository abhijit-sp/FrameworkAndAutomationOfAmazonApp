package project.pages.signinoptions.impl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import project.pages.signinoptions.SignInOptionsPage;

import java.time.temporal.ChronoUnit;

public class SignInOptionsLandscapePage extends SignInOptionsPage {

    public SignInOptionsLandscapePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/wish_list_bottom_sheet_layout\")).scrollIntoView(new UiSelector().textContains(\"Already a customer? Sign in\"));")
    @WithTimeout(time = 15, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement signInButton;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/wish_list_bottom_sheet_layout\")).scrollIntoView(new UiSelector().textContains(\"Skip sign in\"));")
    @WithTimeout(time = 15, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement skipSignInButton;

    @Override
    public void clickSignInButton() {
        //signInButton.click();
        skipSignInButton.click();
    }

    @Override
    public void clickSkipSignInButton() {
        skipSignInButton.click();
    }
}
