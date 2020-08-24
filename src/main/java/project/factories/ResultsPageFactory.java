package project.factories;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import project.pages.resultspage.ResultsPage;
import project.pages.resultspage.impl.ResultsPageLandscape;
import project.pages.resultspage.impl.ResultsPagePortrait;

public class ResultsPageFactory {

    private static ResultsPage resultsPage;

    public static ResultsPage getInstance(AndroidDriver<MobileElement> driver){
        if (driver.getOrientation().equals(ScreenOrientation.PORTRAIT)){
            resultsPage = new ResultsPagePortrait(driver);
        } else if (driver.getOrientation().equals(ScreenOrientation.LANDSCAPE)){
            resultsPage = new ResultsPageLandscape(driver);
        }
        return resultsPage;
    }
}
