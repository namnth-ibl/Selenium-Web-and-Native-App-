package StixChat;

/**
 * Created by Administrator on 6/12/2017.
 */

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import java.util.Collection;
import java.util.List;
import java.util.Set;


public class TC_StixChat {

    AndroidDriver driver;

    @BeforeTest
    public void BeforeTest() throws MalformedURLException
    {
        DesiredCapabilities cap = new DesiredCapabilities();
        // Information of App and Device
        String platformName = "ANDROID";
        String deviceName   = "d15c51e4";
        String packageName  = "com.stixchat.app";
        String appActivity  = "com.gnt.stixchat.LandingActivity";
        // File .APK
        String appName = "Stixchat.apk";
        File appPath = new File("src/main/resources/" + appName);
        // Setting Capabilities
        cap.setCapability(MobileCapabilityType.APP,appPath);
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
        cap.setCapability(MobileCapabilityType.APP_PACKAGE,packageName);
        cap.setCapability(MobileCapabilityType.APP_ACTIVITY,appActivity);
        // Connect to Appium Server
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
    }

    @Test
    public  void  LaunchApp()
    {
        // Get current Activity
        String currScreen = driver.currentActivity();
        System.out.println("Current Screen: " + currScreen);
        // Click GET STARTED
        driver.findElementById("com.stixchat.app:id/signUp").click();
        System.out.println("Clicked GET STARTED.");
        // Click COUNTRY DropDownList
        driver.findElementById("com.stixchat.app:id/txtCountry").click();
        System.out.println("Clicked Drop Down List.");
        // Enter COUNTRY "vi"
        driver.findElementById("com.stixchat.app:id/search_src_text").sendKeys("vi");
        System.out.println("Entered vi.");
        // Select "Vietnam"
        driver.findElementByName("Vietnam").click();
        System.out.println("Clicked Vietnam.");
        // Enter Phone Number
        driver.findElementById("com.stixchat.app:id/editTextPhoneNumber").sendKeys("1999888777");
        System.out.println("Entered 1999888777.");
        // Click NEXT
        driver.findElementById("com.stixchat.app:id/btnNext").click();
        System.out.println("Clicked NEXT.");
        WebDriverWait wait_1st = new WebDriverWait(driver,5);
    }

    @AfterTest
    public void AfterTest()
    {
        // Quit driver for closing app
        driver.quit();
        System.out.println("Driver is quit.");
    }

}
