/**
 * Created by Nam on 2/21/2017.
 */

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static com.thoughtworks.selenium.SeleneseTestCase.assertNotEquals;
import static junit.framework.Assert.assertEquals;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import  java.util.Collection;
import java.util.List;


public class TC_SkypeApp {
    AndroidDriver _driver;

//    String appName = "Skype.apk";
//    File pathFile = new File("src/main/resources" + appName);

    @BeforeTest
    public void BeforeTest() throws MalformedURLException {
        DesiredCapabilities _cap = new DesiredCapabilities();

//        // Find and Install App
//        _cap.setCapability("App",pathFile);
        // Platform
        _cap.setCapability("platformName", "ANDROID");
        // Device name
        _cap.setCapability("deviceName", "emulator-5554");
        // Package Name
        _cap.setCapability("packageName","com.skype.raider");
        // App Activity
        _cap.setCapability("appActivity","com.skype.android.app.main.SplashActivity");

        _driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), _cap);
    }

    @Test(priority = 1)
    /* Testcase flow:
    1. Input username
    2. Press Continue
    3. Input Password
    4. Press Continue
    Wait 5s
    */

    public void SignInFailed() {
        String screenUserName = _driver.currentActivity();
        WebDriverWait waitToPresent = new WebDriverWait(_driver,10);

        waitToPresent.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.skype.raider:id/sign_in_userid")));

        // 1. Input Username
        _driver.findElementById("com.skype.raider:id/sign_in_userid").sendKeys("namnguyen");

        // 2. Press Continue
        _driver.findElementById("com.skype.raider:id/sign_in_next_btn").click();

        WebDriverWait wait_1st = new WebDriverWait(_driver,10);
        wait_1st.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.skype.raider:id/signin_password")));

        String screenPassword = _driver.currentActivity();
        assertNotEquals(screenUserName,screenPassword);

        // 3. Input Password
        _driver.findElementById("com.skype.raider:id/signin_password").sendKeys("******");
        // 4. Press Continue
        _driver.findElementById("com.skype.raider:id/sign_in_btn").click();

        // 5. Wait 5s
        WebDriverWait wait_2nd = new WebDriverWait(_driver,10);
        wait_2nd.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.skype.raider:id/error_message")));
        // Get Error Message
        String errorMess = _driver.findElementById("com.skype.raider:id/error_message").getText();
        // Check error message is the same
        assertEquals(errorMess,"Oops, please check your details.");

    }

//    @Test(priority = 2)
//    public void SignInSuccess() {
//        WebElement username_secondTime;
//        WebElement password;
//        WebElement btnContinue2nd;
//
//        // Find and Clear Username Field
//        username_secondTime = (WebElement) _driver.findElementsByClassName("android.widget.EditText").get(1);
//        username_secondTime.clear();
//        username_secondTime.sendKeys("namnguyen2");
//
//        // Fine ARROW to Continue
//        btnContinue2nd = (WebElement) _driver.findElementsByClassName("android.widget.TextView").get(2);
//        btnContinue2nd.click();
//        // Wait until Password filed appears
//        WebDriverWait watingTime = new WebDriverWait(_driver, 5);
//        // Input Password
//        password = (WebElement)_driver.findElementsByClassName("android.widget.EditText").get(3);
//        password.sendKeys("******");
//        // Find ARROW to Continue
//        btnContinue2nd.click();
//    }

    @AfterTest
    public  void QuitDriver()
    {
        _driver.quit();
    }
}
