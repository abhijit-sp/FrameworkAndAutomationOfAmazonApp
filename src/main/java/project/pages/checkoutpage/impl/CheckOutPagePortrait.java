package project.pages.checkoutpage.impl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import project.pages.checkoutpage.CheckOutPage;

import java.time.temporal.ChronoUnit;

/*
    A concrete implementation of the actions that can be performed on the portrait version of check out screen.
 */
public class CheckOutPagePortrait extends CheckOutPage {

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='a-autoid-0-announce']")
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement deliverToThisAddressButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement continueButton;

    public CheckOutPagePortrait(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void clickDeliverToThisAddressButton() {
        deliverToThisAddressButton.click();
    }

    @Override
    public void clickContinueButton() {
        continueButton.click();
    }
}
