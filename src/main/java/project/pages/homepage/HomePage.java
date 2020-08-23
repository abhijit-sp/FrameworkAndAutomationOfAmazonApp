package project.pages.homepage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import project.pages.BasePage;

import java.util.List;

public abstract class HomePage extends BasePage {

    public HomePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public abstract void clickSearchField();

    public abstract void enterSearchText(String query);

    public abstract List<MobileElement> getSearchResults();

    public abstract void selectSearchResult(int index);

    public abstract void selectSearchResult(String result);

    public abstract MobileElement getSearchField();
}
