package project.pages.proceedtobuy.impl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.WithTimeout;
import project.pages.proceedtobuy.ProceedToBuyPage;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/*
A concrete implementation of the ProceedToBuyPage in portrait mode.
 */
public class ProceedToBuyPagePortrait extends ProceedToBuyPage {

    public ProceedToBuyPagePortrait(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBys({
            @AndroidBy(xpath = "//android.view.View[@resource-id='activeCartViewForm']"),
            @AndroidBy(xpath = "(//android.view.View)[1]"),
            @AndroidBy(xpath = "(//android.view.View)[2]"),
            @AndroidBy(xpath = "(//android.view.View)[1]"),
            @AndroidBy(xpath = "(//android.view.View)[3]"),
            @AndroidBy(xpath = "(//android.widget.ListView)[1]"),
            @AndroidBy(xpath = "(//android.view.View)[1]"),
    })
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement productPrice;

    @AndroidFindBys({
            @AndroidBy(xpath = "//android.view.View[@resource-id='sc-mini-buy-box']"),
            @AndroidBy(className = "android.widget.Button")
    })
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement proceedToBuyButton;

    @Override
    public MobileElement getProductDescription(String description) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String locator = "new UiScrollable(new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/a-page\"))"+
                ".scrollIntoView(new UiSelector().textContains(\""+description+"\"));";
        return driver.findElementByAndroidUIAutomator(locator);
    }

    @Override
    public MobileElement getProductPrice() {
        return productPrice;
    }

    @Override
    public void clickProceedToBuyButton() {
        proceedToBuyButton.click();
    }
}

