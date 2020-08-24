package project.pages.productdetails.impl;

import framework.utils.gestures.TouchActionsHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import project.pages.productdetails.ProductDetailsPage;

import java.time.temporal.ChronoUnit;

public class ProductDetailsPagePortrait extends ProductDetailsPage {

    public ProductDetailsPagePortrait(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "action_bar_cart_image")
    @WithTimeout(time = 3, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement cartButton;

  /*  @AndroidFindBys({
            @AndroidBy(id = "title_feature_div"),
            @AndroidBy(className = "android.view.View")
    })
    @WithTimeout(time = 3, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement description;*/

    @AndroidFindBys({
            @AndroidBy(xpath = "//android.view.View[@resource-id='title_feature_div']"),
            @AndroidBy(className = "android.view.View")
    })
    @WithTimeout(time = 3, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement description;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/a-page\")).scrollIntoView(new UiSelector().textContains(\"Get an OTP on your phone\"));")
    @WithTimeout(time = 15, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement getOTPButton;

    //@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/a-page\")).scrollIntoView(new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/atfRedesign_priceblock_priceToPay\"));")
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/a-page\")).scrollIntoView(new UiSelector().textContains(\"rupees\"));")
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement price;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/a-page\")).scrollIntoView(new UiSelector().textContains(\"Add to Cart\"));")
    @WithTimeout(time = 2, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement addToCartButton;

    @Override
    public MobileElement getProductDescriptionElement() {
        return description;
    }

    @Override
    public MobileElement getProductPriceElement() {
        int maxSwipes = 5;
        MobileElement priceElement = null;
        try {
            if (price.getCenter()!=null) priceElement = price;
        }catch (NoSuchElementException e){}
        int midX = TouchActionsHelper.getScreenWidth(driver)/2;
        int startY = (int)(TouchActionsHelper.getScreenHeight(driver)*0.9);
        int endY = (int)(TouchActionsHelper.getScreenHeight(driver)*0.3);


        while (priceElement == null && maxSwipes-- > 0){
            TouchActionsHelper.scrollAList(driver, new Point(midX, startY), new Point(midX, endY), 1);
            try {
                if (price.getCenter()!=null) priceElement = price;
            }catch (NoSuchElementException e){}
        }
        return priceElement.findElementByClassName("android.widget.EditText");
    }

    @Override
    public void clickOnCart() {
        cartButton.click();
    }

    @Override
    public void clickAddToCartButton() {
        int maxSwipes = 5;
        MobileElement addToCartElement = null;
        try {
            if (addToCartButton.getCenter()!=null) addToCartElement = addToCartButton;
        }catch (NoSuchElementException e){}
        int midX = TouchActionsHelper.getScreenWidth(driver)/2;
        int startY = (int)(TouchActionsHelper.getScreenHeight(driver)*0.9);
        int endY = (int)(TouchActionsHelper.getScreenHeight(driver)*0.3);


        while (addToCartElement == null && maxSwipes-- > 0){
            TouchActionsHelper.scrollAList(driver, new Point(midX, startY), new Point(midX, endY), 1);
            try {
                if (addToCartButton.getCenter()!=null) addToCartElement = addToCartButton;
            }catch (NoSuchElementException e){}
        }
         addToCartElement.click();
    }
}
