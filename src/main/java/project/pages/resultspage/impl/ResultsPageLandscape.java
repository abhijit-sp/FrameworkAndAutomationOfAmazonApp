package project.pages.resultspage.impl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import project.pages.resultspage.ResultsPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultsPageLandscape extends ResultsPage {

    public ResultsPageLandscape(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Override
    public List<MobileElement> getSearchResults() {
        return new ArrayList<MobileElement>();

    }

    @Override
    public void selectSearchResult(int index) {

    }

    @Override
    public Map<ProductDetails, String> getProductDetails(MobileElement product) {
        return null;
    }
}
