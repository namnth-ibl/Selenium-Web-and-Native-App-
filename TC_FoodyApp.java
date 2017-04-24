package TC_FOODY;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.security.krb5.internal.crypto.Des;

import java.net.MalformedURLException;
import java.net.URL;
import static junit.framework.Assert.assertEquals;

/**
 * Created by Nam on 4/22/2017.
 */
public class TC_FoodyApp {
    // Using AndroidDriver
    AndroidDriver driver;
    // String of connection
    String connectionString = "http://127.0.0.1:4723/wd/hub";

    // Initial phase
    @BeforeTest
    public void BeforeTest() throws MalformedURLException {
        // Create instance of DesiredCapabilities
        DesiredCapabilities cap = new DesiredCapabilities();
        // Set information of device (Emulator)
        cap.setCapability("platformName","ANDROID");
        cap.setCapability("deviceName","CB5A1UP4XV");
        cap.setCapability("packageName","com.foody.vn.activity");
        cap.setCapability("appActivity","com.foody.ui.activities.NewFlashActivity");

        // Create connection to server
        driver = new AndroidDriver(new URL(connectionString), cap);
    }

    // Run App 1st time - Using for the 1st installation
    @Test(priority = 1)
    public void SelectLanguages()throws  MalformedURLException
    {
        // Print name of current screen
        String currentScreen = driver.currentActivity();
        System.out.println(currentScreen);
        // Click on "Indonesia"
        driver.findElementById("com.foody.vn.activity:id/tvTwo").click();
        //Click on "VietNam"
        driver.findElementById("com.foody.vn.activity:id/tvOne").click();
        // Click Next
        driver.findElementById("com.foody.vn.activity:id/btnDone").click();
        // Next Page - click Done
        driver.findElementById("com.foody.vn.activity:id/btnDone").click();
        // Skip
        WebDriverWait wait_for_Loading = new WebDriverWait(driver,20);
        wait_for_Loading.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.foody.vn.activity:id/buttonSkipIntro")));
        driver.findElementById("com.foody.vn.activity:id/buttonSkipIntro").click();

    }

    @Test(priority = 2)
    public  void Register() throws InterruptedException {
        Thread.sleep(20000);
        WebDriverWait wait_for_TabMore = new WebDriverWait(driver,10);
        wait_for_TabMore.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.foody.vn.activity:id/llTabMore")));
        // Click "Tai Khoan" Tab
        driver.findElementById("com.foody.vn.activity:id/llTabMore").click();
        // Click "Dang Nhap"
        WebDriverWait wait_for_tvLogin = new WebDriverWait(driver,10);
        wait_for_tvLogin.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.foody.vn.activity:id/tvLogin")));
        driver.findElementById("com.foody.vn.activity:id/tvLogin").click();
        // Click "Dang nhap bang sdt"
        driver.findElementById("com.foody.vn.activity:id/llLoginByPhoneNumber").click();
        // Input wrong phone number
        driver.findElementById("com.foody.vn.activity:id/com_accountkit_phone_number").sendKeys("123456789");
        // Click "Tiep"
        driver.findElementById("com.foody.vn.activity:id/com_accountkit_next_button").click();
        // Compare Error Text
        String errorText = driver.findElementById("com.foody.vn.activity:id/com_accountkit_title").getText();
        assertEquals(errorText,"Please enter a valid phone number.");
        // Click "Thu lai" to retry
        driver.findElementById("com.foody.vn.activity:id/com_accountkit_start_over_button").click();


    }
}
