package project.pages.proceedtobuy.impl;

import framework.utils.gestures.TouchActionsHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.Point;
import project.pages.proceedtobuy.ProceedToBuyPage;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/*
A concrete implementation of the ProceedToBuyPage in landscape mode.
 */
public class ProceedToBuyPageLandscape extends ProceedToBuyPage {

    public ProceedToBuyPageLandscape(AndroidDriver<MobileElement> driver) {
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

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Proceed to Buy']")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement proceedToBuyButton;

    @Override
    public MobileElement getProductDescription(String description) {
        int midX = TouchActionsHelper.getScreenWidth(driver)/2;
        int startY = (int)(TouchActionsHelper.getScreenHeight(driver)*0.9);
        int endY = (int)(TouchActionsHelper.getScreenHeight(driver)*0.5);
        TouchActionsHelper.scrollAList(driver, new Point(midX, startY), new Point(midX, endY), 1);
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
