/**
 * Created by Nam on 3/5/2017.
 */

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import static  com.thoughtworks.selenium.SeleneseTestCase.assertNotEquals;
import java.net.URL;

public class TC_Browser {
    AndroidDriver driver;
    WebElement btnSignIn;
    WebElement iconSkype;
    WebElement userName;
    WebElement password;

    @BeforeTest
    public  void  BeforeTest() throws MalformedURLException
    {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("platformName","ANDROID");
        cap.setCapability("deviceName","emulator-5554");
        cap.setCapability(MobileCapabilityType.APP,"Browser");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
    }

    @Test
    public void LauchBrowser() throws MalformedURLException
    {
        String screenHome = driver.currentActivity();
        driver.navigate().to("https://www.skype.com");
        btnSignIn = (WebElement) driver.findElementByClassName("title");
        btnSignIn.click();
        iconSkype = (WebElement) driver.findElementByClassName("icon icon-skype");
        iconSkype.click();
        WebDriverWait wait_01 = new WebDriverWait(driver,10);

        String screenUsername = driver.currentActivity();
        assertNotEquals(screenHome,screenUsername);
        userName = (WebElement) driver.findElementByClassName("placeholder");
        userName.sendKeys("nam.nguyen2003");
        driver.findElementById("idSIButton9").click();
        WebDriverWait wait_02 = new WebDriverWait(driver,5);

        String screenPassword = driver.currentActivity();
        assertNotEquals(screenUsername,screenPassword);
        password = (WebElement) driver.findElementByClassName("placeholder");
        password.sendKeys("123qwe789");
        driver.findElementById("idSIButton9").click();
        WebDriverWait wait_03 = new WebDriverWait(driver,5);

    }
}
