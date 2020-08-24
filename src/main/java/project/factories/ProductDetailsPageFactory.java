package project.factories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import project.pages.productdetails.ProductDetailsPage;
import project.pages.productdetails.impl.ProductDetailsPagePortrait;

public class ProductDetailsPageFactory {

    private static ProductDetailsPage productDetailsPage;

    public static ProductDetailsPage getInstance(AndroidDriver<MobileElement> driver){
        if (driver.getOrientation().equals(ScreenOrientation.PORTRAIT)){
            productDetailsPage = new ProductDetailsPagePortrait(driver);
        }else if (driver.getOrientation().equals(ScreenOrientation.LANDSCAPE)){
            productDetailsPage = new ProductDetailsPagePortrait(driver);
        }
        return productDetailsPage;
    }
}
