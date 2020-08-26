package project.pages.resultspage.impl;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import org.openqa.selenium.By;
import project.pages.resultspage.ResultsPage;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
A concrete implementation of the ResultsPage in landscape mode.
 */
public class ResultsPageLandscape extends ResultsPage {

    public ResultsPageLandscape(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    By description_By = By.id("item_title");
    By priceContainer_By = By.id("rs_results_styled_price_v2");
    By price_By = By.className("android.widget.TextView");

    @AndroidFindBy(id = "rs_vertical_stack_view")
    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    public MobileElement resultsParent;

    @AndroidFindAll({
            @AndroidBy(id = "list_product_linear_layout")
    })
    @WithTimeout(time = 5, chronoUnit = ChronoUnit.SECONDS)
    public List<MobileElement> resultContainers;

    @Override
    public List<MobileElement> getSearchResults() {
        return resultContainers;

    }

    @Override
    public void selectSearchResult(int index) {
        resultContainers.get(index).click();
    }

    @Override
    public Map<ProductDetails, String> getProductDetails(MobileElement product) {
        String description = product.findElement(description_By).getText();
        String price = product.findElement(priceContainer_By).findElement(price_By).getText();

        price = price.split(" ")[0];
        Map<ProductDetails, String> productDetails = new HashMap<>();
        productDetails.put(ProductDetails.DESCRIPTION, description);
        productDetails.put(ProductDetails.PRICE, price);
        return productDetails;
    }
}
