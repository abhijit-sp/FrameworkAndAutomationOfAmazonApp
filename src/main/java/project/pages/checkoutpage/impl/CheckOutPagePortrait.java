package project.pages.impl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;

import java.time.temporal.ChronoUnit;

public class DeliveryAddressPagePortrait extends DeliveryAddressPage {

    @AndroidFindBy()
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement deliverToThisAddressButton;

    public DeliveryAddressPagePortrait(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public void clickDeliverToThisAddressButton() {
        deliverToThisAddressButton.click();
    }
}
