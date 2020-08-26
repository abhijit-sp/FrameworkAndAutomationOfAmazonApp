package project.pages.proceedtobuy;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import project.pages.BasePage;

/*
A generic representation of the actions that can be performed on the proceed to buy page..
 */
public abstract class ProceedToBuyPage extends BasePage {

    public ProceedToBuyPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public abstract MobileElement getProductDescription(String description);

    public abstract MobileElement getProductPrice();

    public abstract void clickProceedToBuyButton();
}
