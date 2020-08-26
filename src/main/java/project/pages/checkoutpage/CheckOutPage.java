package project.pages.impl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import project.pages.BasePage;

public abstract class DeliveryAddressPage extends BasePage {

    public DeliveryAddressPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public abstract void clickDeliverToThisAddressButton();
}
