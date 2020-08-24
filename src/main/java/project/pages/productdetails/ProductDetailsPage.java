package project.pages.productdetails;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import project.pages.BasePage;

public abstract class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public abstract MobileElement getProductDescriptionElement();

    public abstract MobileElement getProductPriceElement();

    public abstract void clickOnCart();

    public abstract void clickAddToCartButton();
}
