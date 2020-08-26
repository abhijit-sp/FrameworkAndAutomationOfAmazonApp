package project.pages.checkoutpage.impl;

import framework.utils.gestures.TouchActionsHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import project.pages.checkoutpage.CheckOutPage;

import java.time.temporal.ChronoUnit;

/*
    A concrete implementation of the actions that can be performed on the landscape version of check out screen.
 */
public class CheckOutPageLandscape extends CheckOutPage {

    public CheckOutPageLandscape(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='a-autoid-0-announce']")
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement deliverToThisAddressButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continue']")
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement continueButton;

    @Override
    public void clickDeliverToThisAddressButton() {
        deliverToThisAddressButton.click();
    }

    @Override
    public void clickContinueButton() {
        int maxSwipes = 2;
        MobileElement continueButtonElement = null;
        try {
            if (continueButton.getCenter() != null) continueButtonElement = continueButton;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        int midX = TouchActionsHelper.getScreenWidth(driver) / 2;
        int startY = (int) (TouchActionsHelper.getScreenHeight(driver) * 0.9);
        int endY = (int) (TouchActionsHelper.getScreenHeight(driver) * 0.3);

        while (continueButtonElement == null && maxSwipes-- > 0) {
            TouchActionsHelper.scrollAList(driver, new Point(midX, startY), new Point(midX, endY), 1);
            try {
                if (continueButton.getCenter() != null) continueButtonElement = continueButton;
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
        continueButtonElement.click();
    }
}
