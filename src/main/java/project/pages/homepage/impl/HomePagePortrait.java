package project.pages.homepage.impl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import project.pages.homepage.HomePage;

import java.time.temporal.ChronoUnit;
import java.util.List;

/*
A concrete implementation of the HomePage in portrait mode.
 */
public class HomePagePortrait extends HomePage {

    public HomePagePortrait(AndroidDriver<MobileElement> driver) {
        super(driver);
    }


    @AndroidFindBy(id = "rs_search_src_text")
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement searchField;

    @AndroidFindAll({
            @AndroidBy(id = "iss_search_dropdown_item_text")
    })
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    public List<MobileElement> searchResults;


    @Override
    public void clickSearchField() {
        searchField.click();
    }

    @Override
    public void enterSearchText(String query) {
        searchField.sendKeys(query);
    }

    @Override
    public List<MobileElement> getSearchResults() {
        return searchResults;
    }

    @Override
    public void selectSearchResult(int index) {
        searchResults.get(index).click();
    }

    @Override
    public void selectSearchResult(String result) {
        String locator = "new UiScrollable(new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/iss_search_suggestions_list_view\")).scrollIntoView(new UiSelector().textContains(\""+result+"\"));";
        driver.findElementByAndroidUIAutomator(locator).click();
    }

    @Override
    public MobileElement getSearchField() {
        return searchField;
    }
}
