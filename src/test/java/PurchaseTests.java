import framework.driver.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import project.factories.SignInOptionsPageFactory;
import project.pages.signinoptions.SignInOptionsPage;

import java.util.concurrent.TimeUnit;

public class PurchaseTests extends BaseTest{

    @Test
    public void purchaseTV() throws InterruptedException{
        SignInOptionsPage signInOptionsPage = SignInOptionsPageFactory.getInstance(driver);
        signInOptionsPage.clickSignInButton();
    }

    @Test
    public void test(){
        System.out.println("asd");
    }


}
