import framework.driver.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.aspectj.lang.annotation.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    AndroidDriver<MobileElement> driver;

    @BeforeSuite(alwaysRun = true)
    public void setup(){
        driver = Driver.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
