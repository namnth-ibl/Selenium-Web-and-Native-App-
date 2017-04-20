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
import java.util.Collection;
import java.util.List;
import java.util.Set;


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
        _cap.setCapability("packageName", "com.skype.raider");
        // App Activity
        _cap.setCapability("appActivity", "com.skype.android.app.main.SplashActivity");

        _driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), _cap);
    }

    /* Testcase flow:
    1. Input username
    2. Press Continue
    3. Input Password
    4. Press Continue
    Wait 5s
    */
    @Test(priority = 1)
    public void SignInFailed() {
        String screenUserName = _driver.currentActivity();
        WebDriverWait waitToPresent = new WebDriverWait(_driver, 10);
        // Wait until element is presented
        waitToPresent.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.skype.raider:id/sign_in_userid")));

        // 1. Input Username
        _driver.findElementById("com.skype.raider:id/sign_in_userid").sendKeys("namnguyen");

        // 2. Press Continue
        _driver.findElementById("com.skype.raider:id/sign_in_next_btn").click();

        WebDriverWait wait_1st = new WebDriverWait(_driver, 10);
        wait_1st.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.skype.raider:id/signin_password")));

        String screenPassword = _driver.currentActivity();
        assertNotEquals(screenUserName, screenPassword);

        // 3. Input Password
        _driver.findElementById("com.skype.raider:id/signin_password").sendKeys("******");
        // 4. Press Continue
        _driver.findElementById("com.skype.raider:id/sign_in_btn").click();

        // 5. Wait 5s
        WebDriverWait wait_2nd = new WebDriverWait(_driver, 10);
        wait_2nd.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.skype.raider:id/error_message")));
        // Get Error Message
        String errorMess = _driver.findElementById("com.skype.raider:id/error_message").getText();
        // Check error message is the same
        assertEquals(errorMess, "Oops, please check your details.");

    }

    @Test(priority = 2)
    public void Register() throws InterruptedException {
        _driver.navigate().back();

        // Part 1 of Register
        _driver.findElementById("com.skype.raider:id/create_account_label").click();

        Thread.sleep(5000);

        Set<String> contextNames = _driver.getContextHandles();
        for(String contextMem : contextNames) {
            //System.out.println("List of Contexts: " + contextNames);
            if(contextMem.contains("WEBVIEW_com.skype.raider"))
            {
                _driver.context(contextMem);
                System.out.println("Switch 1st to: "+ contextMem);
            }
        }
        List<WebElement> listEditText;
        WebDriverWait wait_for_register = new WebDriverWait(_driver,10);
        _driver.findElementById("MemberName").sendKeys("123456789");
        _driver.findElementById("Password").sendKeys("123qwe789");
        _driver.findElementById("iSignupAction").click();
        WebDriverWait wait_for_next_regiter = new WebDriverWait(_driver,5);
        // Part 2 of Register
        for(String contextMem2nd : contextNames) {
            //System.out.println("List of Contexts: " + contextNames);
            if(contextMem2nd.contains("NATIVE_APP"))
            {
                _driver.context(contextMem2nd);
                System.out.println("Switch 2nd to: "+ contextMem2nd);
            }
        }
        // Input Name
        listEditText = (List<WebElement>)_driver.findElementsByClassName("android.widget.EditText");
        listEditText.get(0).sendKeys("Nam");
        listEditText.get(1).sendKeys("Nguyen");
        // Click button Next
        List<WebElement> listBtn = _driver.findElementsByClassName("android.widget.Button");
        listBtn.get(1).click();
        WebDriverWait wait_for_verifyCode = new WebDriverWait(_driver, 5);
        // Part 3 of Register
        _driver.findElementByClassName("android.widget.EditText").sendKeys("2895");
        List<WebElement> listButton2nd = _driver.findElementsByClassName("android.widget.Button");
        listButton2nd.get(1).click();
        WebDriverWait wait_for_process = new WebDriverWait(_driver,10);

        _driver.context("NATIVE_APP");
    }

//    @Test(priority = 3)
//    public void SignInSuccess() {
//        // Clear content of Username field
//        _driver.findElementById("com.skype.raider:id/signin_skypename").clear();
//        // Input Username
//        _driver.findElementById("com.skype.raider:id/signin_skypename").sendKeys("123456789");
//        // Clear content of Password field
//        _driver.findElementById("com.skype.raider:id/signin_password").clear();
//        // Input Password
//        _driver.findElementById("com.skype.raider:id/signin_password").sendKeys("********");
//        // Click button Continue
//        _driver.findElementById("com.skype.raider:id/sign_in_btn").click();
//        WebDriverWait wait_3rd = new WebDriverWait(_driver, 10);
//    }

    @AfterTest
    public void QuitDriver() {
        _driver.quit();
    }
}
