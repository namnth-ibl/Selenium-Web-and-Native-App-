/**
 * Created by Nam on 2/21/2017.
 */

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class TC_SkypeSignIn {
    AndroidDriver _driver;
    String fileName = "Skype.apk";
    File filePath = new File("src/main/resources/" + fileName);

    @BeforeTest
    public void BeforeTest() throws MalformedURLException {
        DesiredCapabilities _cap = new DesiredCapabilities();

        _cap.setCapability("App", filePath);
        // Platform
        _cap.setCapability("platformName", "ANDROID");
        // Device name
        _cap.setCapability("deviceName", "emulator-5554");

        _driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), _cap);
    }

    @Test(priority = 1)
    public void SignInFailed() {
        WebElement username;
        WebElement btnContinue;

        // Input Wrong Username
        username = (WebElement) _driver.findElementsByClassName("android.widget.EditText").get(0);
        username.sendKeys("nam.nguyen2003");
        // Press Continue Arrow
        btnContinue = (WebElement) _driver.findElementsByClassName("android.widget.TextView").get(1);
        btnContinue.click();
        // Wait until Password field appears
        WebDriverWait waitingTime = new WebDriverWait(_driver,5);
    }

    @Test(priority = 2)
    public void SignInSuccess() {
        WebElement username_secondTime;
        WebElement password;
        WebElement btnContinue2nd;

        // Find and Clear Username Field
        username_secondTime = (WebElement) _driver.findElementsByClassName("android.widget.EditText").get(2);
        username_secondTime.clear();
        username_secondTime.sendKeys("namnguyen2003");

        // Fine ARROW to Continue
        btnContinue2nd = (WebElement) _driver.findElementsByClassName("android.widget.TextView").get(3);
        btnContinue2nd.click();
        // Wait until Password filed appears
        WebDriverWait watingTime = new WebDriverWait(_driver, 5);
        // Input Password
        password = (WebElement)_driver.findElementsByClassName("android.widget.EditText").get(4);
        password.sendKeys("Abc123@@");
        // Find ARROW to Continue
        btnContinue2nd.click();
    }
}
