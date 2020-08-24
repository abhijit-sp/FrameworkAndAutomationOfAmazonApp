import framework.utils.gestures.TouchActionsHelper;
import framework.utils.wait.WaitHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.factories.*;
import project.pages.homepage.HomePage;
import project.pages.password.PasswordPage;
import project.pages.proceedtobuy.impl.ProceedToBuyPagePortrait;
import project.pages.productdetails.ProductDetailsPage;
import project.pages.resultspage.ResultsPage;
import project.pages.signinoptions.SignInOptionsPage;
import project.pages.welcome.WelcomePage;
import project.pojos.Product;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PurchaseTests extends BaseTest {

    @Test
    public void purchaseTV() throws InterruptedException {
        SignInOptionsPage signInOptionsPage = SignInOptionsPageFactory.getInstance(driver);
        signInOptionsPage.clickSignInButton();
        WelcomePage welcomePage = WelcomePageFactory.getInstance(driver);

        WaitHelper.sleep(3000);
        Set<String> contexts = driver.getContextHandles();

        welcomePage.enterUsernameOrEmail("abhijit.phaniraj@gmail.com");
        welcomePage.clickContinueButton();
        WaitHelper.sleep(2000);
        PasswordPage passwordPage = PasswordPageFactory.getInstance(driver);
        passwordPage.enterPassword("@ugust18");
        passwordPage.clickLoginButton();

        HomePage homePage = HomePageFactory.getInstance(driver);
        WaitHelper.waitUntilVisibilityOfElement(driver
                , 15
                , homePage.getSearchField());
        homePage.clickSearchField();
        homePage.enterSearchText("65 inch tv");
        homePage.getSearchResults().get(0).click();
        ResultsPage resultsPage = ResultsPageFactory.getInstance(driver);
        List<MobileElement> results = resultsPage.getSearchResults();
        int size = results.size();
        MobileElement start = results.get(size - 1);
        MobileElement end = results.get(0);
        TouchActionsHelper.scrollAList(driver, start.getCenter(), end.getCenter(), 1);
        MobileElement tvToBeSelected = resultsPage.getSearchResults().get(2);
        Map<ResultsPage.ProductDetails, String> productDetails = resultsPage.getProductDetails(tvToBeSelected);
        String description = productDetails.get(ResultsPage.ProductDetails.DESCRIPTION);
        String price = productDetails.get(ResultsPage.ProductDetails.PRICE);
        System.out.println("Results price="+price);

        price = price.replaceAll("[^\\d]", "");
        System.out.println("Results price after replace="+price);
        Product searchScreenProduct = new Product(description
                , price);
        tvToBeSelected.click();
        System.out.println("Product to string="+searchScreenProduct.toString());
        WaitHelper.sleep(5000);
        System.out.println(driver.getContextHandles().toString());
        ProductDetailsPage productDetailsPage = ProductDetailsPageFactory.getInstance(driver);

        String detailsScreenDescription = productDetailsPage.getProductDescriptionElement().getText();
        //String detailsScreenPrice = productDetailsPage.getProductPriceElement().getText();
        //detailsScreenPrice = detailsScreenPrice.replaceAll("[^\\d]", "");
        System.out.println("Desc in Details="+detailsScreenDescription);

        //System.out.println("Price in Details="+detailsScreenPrice);


        //Product detailsScreenProduct = new Product(detailsScreenDescription
               // , detailsScreenPrice);
        //Assert.assertEquals(searchScreenProduct, detailsScreenProduct);
        int midX = TouchActionsHelper.getScreenWidth(driver)/2;
        int startY = (int)(TouchActionsHelper.getScreenHeight(driver)*0.9);
        int endY = (int)(TouchActionsHelper.getScreenHeight(driver)*0.3);

        TouchActionsHelper.scrollAList(driver, new Point(midX, startY), new Point(midX, endY), 2);
        productDetailsPage.clickAddToCartButton();
        productDetailsPage.clickOnCart();
        WaitHelper.sleep(5000);
        ProceedToBuyPagePortrait proceedToBuyPage = new ProceedToBuyPagePortrait(driver);
        String desc = proceedToBuyPage.getProductDescription(searchScreenProduct.getDescription()).getText();
        System.out.println("Buy screen desc="+desc);
    }

    private void scrollDownResultsPage(int percentage, ResultsPage resultsPage) {
/*     Dimension dimension = driver.manage().window().getSize();
     int midX = (dimension.getWidth())/2;
     int bottomY = (int) ((dimension.getHeight())*0.9);
     int topY = (int) ((dimension.getHeight())*0.1);

     Point start = new Point(midX, bottomY);
     Point end = new Point(midX, topY);

     Duration duration = Duration.ofMillis(1500);

     TouchActionsHelper.swipeFromPointToPoint(driver, start, end, duration, duration);*/
        percentage %= 100;

        MobileElement element = resultsPage.getSearchResults().get(resultsPage.getSearchResults().size() - 1);
        TouchAction t = new TouchAction(driver);
        Dimension dimension = driver.manage().window().getSize();
        int midX = (dimension.getWidth()) / 2;
        int topY = (int) ((dimension.getHeight()) * (percentage / 100));

        Point end = new Point(midX, topY);

        t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)))
                .moveTo(PointOption.point(end)).release().perform();


    }


}
