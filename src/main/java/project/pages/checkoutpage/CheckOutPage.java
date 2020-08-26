package project.pages.checkoutpage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import project.pages.BasePage;

/*
    A generic representation of the actions that can be performed on the check out screen.
 */
public abstract class CheckOutPage extends BasePage {

    public CheckOutPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    // Clicks on the deliver to this address button.
    public abstract void clickDeliverToThisAddressButton();

    // Clicks o the continue button.
    public abstract void clickContinueButton();
}
