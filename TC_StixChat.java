package TC_STIXCHAT_APP;

/**
 * Created by Nam on 6/7/2017.
 */

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static junit.framework.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

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
import java.util.concurrent.TimeUnit;

public class TC_StixChat {

    AndroidDriver driver;
//    String appName = "StixChat.apk";
//    File appPath = new File("src/main/resources/" + appName);
    @BeforeTest
    public  void  BeforeTest() throws MalformedURLException
    {
        DesiredCapabilities cap = new DesiredCapabilities();

//        cap.setCapability("App",appPath);
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"4d00922fb8f060fb");
        cap.setCapability(MobileCapabilityType.APP_PACKAGE,"com.stixchat.app");
        cap.setCapability(MobileCapabilityType.APP_ACTIVITY,"com.gnt.stixchat.LandingActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
    }

    @Test
    public  void LaunchApp()
    {
        driver.findElementById("com.stixchat.app:id/signUp").click();
        System.out.println("Đã click Get Started.");
        driver.findElementById("com.stixchat.app:id/txtCountry").click();
        System.out.println("Đã click Country");
        driver.findElementById("com.stixchat.app:id/search_src_text").sendKeys("vi");
        System.out.println("Đã enter vi");
        driver.findElementByName("Vietnam").click();
        System.out.println("Đã chọn Vietnam");
        driver.findElementById("com.stixchat.app:id/editTextPhoneNumber").sendKeys("1999888777");
        System.out.println("Đã enter sdt");
        driver.findElementById("com.stixchat.app:id/btnNext").click();
        System.out.println("Đã click Next");
    }

    @AfterTest
    public  void Aftertest(){
        driver.quit();
    }
}
