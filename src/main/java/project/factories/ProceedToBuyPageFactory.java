package project.factories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import project.pages.proceedtobuy.ProceedToBuyPage;
import project.pages.proceedtobuy.impl.ProceedToBuyPageLandscape;
import project.pages.proceedtobuy.impl.ProceedToBuyPagePortrait;

/*
    A factory that creates a portrait or landscape ProceedToBuyPage
    based on the screen orientation.
 */
public class ProceedToBuyPageFactory {

    public static ProceedToBuyPage getInstance(AndroidDriver<MobileElement> driver){
        if (driver.getOrientation().equals(ScreenOrientation.PORTRAIT)){
            System.out.println("Returning portrait PTB Page");
            return new ProceedToBuyPagePortrait(driver);
        } else if (driver.getOrientation().equals(ScreenOrientation.LANDSCAPE)){
            System.out.println("Returning landscape PTB Page");
            return new ProceedToBuyPageLandscape(driver);
        }
        System.out.println("Returning portrait PTB Page");
        return new ProceedToBuyPagePortrait(driver);
    }
}
