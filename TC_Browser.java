/**
 * Created by Nam on 3/5/2017.
 */

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TC_Browser {
    AndroidDriver driver;

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
        driver.navigate().to("https://www.google.com.vn");
        driver.findElementById("lst-ib").sendKeys("Appium");
       driver.findElementById("lst-ib").sendKeys(Keys.ENTER);
    }
}
