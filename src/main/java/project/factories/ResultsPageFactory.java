package project.factories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import project.pages.resultspage.ResultsPage;
import project.pages.resultspage.impl.ResultsPageLandscape;
import project.pages.resultspage.impl.ResultsPagePortrait;

/*
    A factory that creates a portrait or landscape ResultsPage
    based on the screen orientation.
 */
public class ResultsPageFactory {

    public static ResultsPage getInstance(AndroidDriver<MobileElement> driver){
        if (driver.getOrientation().equals(ScreenOrientation.PORTRAIT)){
            return new ResultsPagePortrait(driver);
        } else if (driver.getOrientation().equals(ScreenOrientation.LANDSCAPE)){
            return new ResultsPageLandscape(driver);
        }
        return new ResultsPagePortrait(driver);
    }
}
