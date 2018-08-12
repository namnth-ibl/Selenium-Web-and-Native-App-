package TC_WEB_ECOMMERCIAL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;
/**
 * Created by Nam on 5/27/2018.
 */
public class Client_Home {
    public static WebDriver driver = new ChromeDriver();
    public static ChromeOptions cOptions = new ChromeOptions();
    public static void Home_Search()
    {
        String geckoPath = "C://Users//Nam//BrowserDriver//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",geckoPath);
        // Enable automation and disabled message info on Chrome
        cOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        cOptions.addArguments("disable-infobars");
        cOptions.addArguments("--disable-extensions");
        driver = new ChromeDriver(cOptions);
        // Access to Home page
        driver.get("http://ishopgo.cktc.online/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println("Accessed to Home page.");
        // Maximize the window
        driver.manage().window().maximize();
        System.out.println("Maximixed the window.");
        // Enter special characters to search textbox
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div/div[2]/div/div/form/input"))
                .sendKeys("~!@#$%^&*()_-=+");
        System.out.println("Entered - ~!@#$%^&*()_-=+ - to search textbox.");
        // Click icon search
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        System.out.println("Clicked search.");

        // Enter a string of space to search textbox
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div/div[2]/div/div/form/input"))
                .sendKeys("                 ");
        System.out.println("Entered a string of space to search textbox.");
        // Click icon search
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        System.out.println("Clicked search.");

        // Enter a string of script to search textbox
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div/div[2]/div/div/form/input"))
                .sendKeys("<script>alert('hello');</script>");
        System.out.println("Entered a string of script to search textbox.");
        // Click icon search
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        System.out.println("Clicked search.");

        // Enter a string of SQL Injection to search textbox
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div/div[2]/div/div/form/input"))
                .sendKeys("SELECT * FROM tbl_Category");
        System.out.println("Entered a string of SQL Injection to search textbox.");
        // Click icon search
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        System.out.println("Clicked search.");
    }

    public static void AfterTest()
    {
        driver.close(); // Close browser BUT keep driver actives.
        System.out.println("Closed browser.");
        driver.quit(); // Deactivate driver
        System.out.println("Driver is deactivated.");
    }
}
