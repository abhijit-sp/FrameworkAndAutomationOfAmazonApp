package project.factories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import project.pages.productdetails.ProductDetailsPage;
import project.pages.productdetails.impl.ProductDetailsPageLandscape;
import project.pages.productdetails.impl.ProductDetailsPagePortrait;

/*
    A factory that creates a portrait or landscape ProductDetailsPage
    based on the screen orientation.
 */
public class ProductDetailsPageFactory {

    public static ProductDetailsPage getInstance(AndroidDriver<MobileElement> driver){
        if (driver.getOrientation().equals(ScreenOrientation.PORTRAIT)){
            return new ProductDetailsPagePortrait(driver);
        }else if (driver.getOrientation().equals(ScreenOrientation.LANDSCAPE)){
            return new ProductDetailsPageLandscape(driver);
        }
        return new ProductDetailsPagePortrait(driver);
    }
}
