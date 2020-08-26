package project.pages.resultspage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import project.pages.BasePage;

import java.util.List;
import java.util.Map;

/*
A generic representation of the results page.
 */
public abstract class ResultsPage extends BasePage {

    public enum ProductDetails{
        DESCRIPTION, PRICE;
    }

    public ResultsPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public abstract List<MobileElement> getSearchResults();

    public abstract void selectSearchResult(int index);

    public abstract Map<ProductDetails, String> getProductDetails(MobileElement product);

}
