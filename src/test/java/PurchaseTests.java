import framework.testconfig.PropertiesReader;
import framework.utils.datareader.ExcelReader;
import framework.utils.gestures.TouchActionsHelper;
import framework.utils.wait.WaitHelper;
import io.appium.java_client.MobileElement;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import project.factories.*;
import project.pages.checkoutpage.CheckOutPage;
import project.pages.homepage.HomePage;
import project.pages.password.PasswordPage;
import project.pages.proceedtobuy.ProceedToBuyPage;
import project.pages.productdetails.ProductDetailsPage;
import project.pages.resultspage.ResultsPage;
import project.pages.signinoptions.SignInOptionsPage;
import project.pages.welcome.WelcomePage;
import project.pojos.Product;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

public class PurchaseTests extends BaseTest {

    @Test(dataProvider = "provideQueryData")
    public void purchaseTV(String username, String password, String query) {
        // Sign in to the Amazon App
        SignInOptionsPage signInOptionsPage = SignInOptionsPageFactory.getInstance(driver);
        signInOptionsPage.clickSignInButton();

        // Enter the username and continue
        WelcomePage welcomePage = WelcomePageFactory.getInstance(driver);
        WaitHelper.sleep(3000);
        welcomePage.enterUsernameOrEmail(username);
        welcomePage.clickContinueButton();
        WaitHelper.sleep(2000);
        //Enter the password and continue
        PasswordPage passwordPage = PasswordPageFactory.getInstance(driver);
        passwordPage.enterPassword(password);
        passwordPage.clickLoginButton();

        //Search for 65 inch TV and select a random one except first and last
        HomePage homePage = HomePageFactory.getInstance(driver);
        WaitHelper.waitUntilVisibilityOfElement(driver
                , 15
                , homePage.getSearchField());
        homePage.clickSearchField();
        WaitHelper.sleep(1000);
        homePage.enterSearchText(query);//65 inch tv
        homePage.getSearchResults().get(0).click();
        ResultsPage resultsPage = ResultsPageFactory.getInstance(driver);
        List<MobileElement> results = resultsPage.getSearchResults();
        int size = results.size();
        MobileElement start = results.get(size - 1);
        MobileElement end = results.get(0);
        TouchActionsHelper.scrollAList(driver, start.getCenter(), end.getCenter(), 1);
        MobileElement tvToBeSelected = resultsPage.getSearchResults().get(0);
        // Get the details of the selected tv on results list page
        Map<ResultsPage.ProductDetails, String> productDetails = resultsPage.getProductDetails(tvToBeSelected);
        String description = productDetails.get(ResultsPage.ProductDetails.DESCRIPTION);
        String price = productDetails.get(ResultsPage.ProductDetails.PRICE);
        // get rif of currency symbol and comma
        price = price.replaceAll("[^\\d]", "");
        // Store the details of the tv in Product class.
        Product searchScreenProduct = new Product(description, price);
        tvToBeSelected.click();
        WaitHelper.sleep(5000);
        ProductDetailsPage productDetailsPage = ProductDetailsPageFactory.getInstance(driver);

        String detailsScreenDescription = productDetailsPage.getProductDescriptionElement().getText();
        String detailsScreenPrice = productDetailsPage.getProductPriceElement().getText();
        detailsScreenPrice = detailsScreenPrice.replaceAll("[^\\d]", "");
        Product detailsScreenProduct = new Product(detailsScreenDescription, detailsScreenPrice);

        // Check whether search screen TV is same as details screen TV
        Assert.assertEquals(searchScreenProduct, detailsScreenProduct);

        // Add TV to cart
        productDetailsPage.clickAddToCartButton();
        productDetailsPage.clickOnCart();
        WaitHelper.sleep(5000);

        ProceedToBuyPage proceedToBuyPage = ProceedToBuyPageFactory.getInstance(driver);
        String checkOutDescription = proceedToBuyPage.getProductDescription(searchScreenProduct.getDescription()).getText();

        String checkOutPrice = proceedToBuyPage.getProductPrice().getText();
        checkOutPrice = checkOutPrice.replaceAll("[^\\d\\.]", "");
        checkOutPrice = checkOutPrice.substring(0, checkOutPrice.indexOf('.'));

        Product checkoutScreenProduct = new Product(checkOutDescription, checkOutPrice);

        // Check whether details screen TV is same as checkout screen TV
        Assert.assertEquals(checkoutScreenProduct, detailsScreenProduct);
        proceedToBuyPage.clickProceedToBuyButton();
        WaitHelper.sleep(500);
        CheckOutPage checkOutPage = CheckOutPageFactory.getInstance(driver);
        checkOutPage.clickDeliverToThisAddressButton();
        WaitHelper.sleep(500);
        checkOutPage.clickContinueButton();
    }

    /*
    Make sure you have an Excel file created amd in the 1st sheet's 1st row add Amazon username,
    Amazon password and the search query in the first 3 cells respectively.
     */
    @DataProvider
    public Object[][] provideQueryData() {
        String[][] data = new String[1][3];
        try {
            String testDataFilePath = PropertiesReader
                    .loadProperties(new FileInputStream("src/main/resources/testdata.properties"))
                    .getProperty("testdata.file.path");

            ExcelReader excelReader = new ExcelReader();

            XSSFRow xssfRow = excelReader
                    .getExcelSheet(testDataFilePath, 0)
                    .getRow(0);
            data[0][0] = xssfRow
                    .getCell(0)
                    .getStringCellValue();
            data[0][1] = xssfRow
                    .getCell(1)
                    .getStringCellValue();
            data[0][2] = xssfRow
                    .getCell(2)
                    .getStringCellValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

}
