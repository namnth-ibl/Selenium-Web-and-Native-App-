package TC_WEB_ECOMMERCIAL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by Nam on 8/11/2018.
 */
public class Admin_Signin {

    public static WebDriver driver = new ChromeDriver();
    public static ChromeOptions cOptions = new ChromeOptions();

    public static void Admin_Login()
    {
        String geckoPath = "C://Users//Nam//BrowserDriver//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",geckoPath);
        // Enable automation and disabled message info on Chrome
        cOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        cOptions.addArguments("disable-infobars");
        cOptions.addArguments("--disable-extensions");
        driver = new ChromeDriver(cOptions);
        // START TIME
        long startTime = System.currentTimeMillis();
        // Access to Home page
        driver.get("http://ishopgo-admin.cktc.online");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println("Accessed to Admin page.");
        // Maximize the window
        driver.manage().window().maximize();
        System.out.println("Maximixed the window.");
        // Enter username
        driver.findElement(By.xpath("//*[@id=\"sign_in\"]/div[2]/div/input"))
                .sendKeys("ngocht");
        System.out.println("Entered username.");
        // Enter password
        driver.findElement(By.xpath("//*[@id=\"sign_in\"]/div[3]/div/input"))
                .sendKeys("123@Ngoc");
        System.out.println("Entered password.");
        // Click Sign in
        driver.findElement(By.xpath("//*[@id=\"sign_in\"]/div[4]/div[2]/button")).click();
        System.out.println("Clicked Sign in.");

        // Click Group Categories
        driver.findElement(By.xpath("//*[@id=\"leftsidebar\"]/div[2]/ul/li[2]/a/span")).click();
        System.out.println("Clicked Group Categories.");
        // Click icon
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/section[2]/div/div/div[2]/div/div/div[1]/ul/li/a/i"))
                .click();
        System.out.println("Clicked icon.");
        // Click Create
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/section[2]/div/div/div[2]/div/div/div[1]/ul/li/ul/li/a/i"))
                .click();
        // Enter Name of Group Category
        driver.findElement(By.xpath("//*[@id=\"create_form\"]/div/div[2]/div[1]/div/div/div/input"))
                .sendKeys("Jeans Zara");
        System.out.println("Entered Name.");

        // Upload icon 01
        WebElement Group_Cate_iconUpload = driver.findElement(By.name("icon"));
        Group_Cate_iconUpload.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        try {
            Runtime.getRuntime().exec("E://File_Setup//Studying//AutoIT//Upload.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Uploaded Icon.");
        // Upload Icon 02
        WebElement Group_Cate_thumbUpload =  driver.findElement(By.name("thumb"));
        Group_Cate_thumbUpload.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        try {
            Runtime.getRuntime().exec("E://File_Setup//Studying//AutoIT//Upload.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Uploaded Thumb");
        // Click CREATE
        //driver.findElement(By.xpath("//*[@id=\"create_form\"]/button")).click();
        //System.out.println("Clicked CREATE.");
        // Select Category
        driver.findElement(By.xpath("//*[@id=\"leftsidebar\"]/div[2]/ul/li[3]/a/span")).click();
        System.out.println("Selected Category.");
        // Click icon
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/section[2]/div/div/div[2]/div/div/div[1]/ul/li/a/i"))
                .click();
        System.out.println("Clicked icon.");
        // Click Create
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/section[2]/div/div/div[2]/div/div/div[1]/ul/li/ul/li/a/i"))
                .click();
        System.out.println("Clicked Create.");
        // Enter Category Name
        driver.findElement(By.name("category-name")).sendKeys("Jeans");
        System.out.println("Entered Category Name");
        // Select Combo box
        driver.findElement(By.xpath("//*[@id=\"create_form\"]/div/div[2]/div[2]/div/div/button/span[2]/span"))
                .click();
        System.out.println("Selected Combo box");
        // Select the 2nd item
        driver.findElement(By.xpath("//*[@id=\"create_form\"]/div/div[2]/div[2]/div/div/div/ul/li[2]/a/span[1]"))
                .click();
        System.out.println("Selected 2nd item");
        // Upload Thumb
        WebElement Cate_iconUpload = driver.findElement(By.name("thumb"));
        Cate_iconUpload.click();
        try {
            Runtime.getRuntime().exec("E://File_Setup//Studying//AutoIT//Upload.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Uploaded Thumb");
        // Click Create
        //driver.findElement(By.xpath("//*[@id=\"create_form\"]/button")).click();
        //System.out.println("Clicked CREATE");

        // END TIME
        long endTime = System.currentTimeMillis();
        // Calculate Time
        long totalTime = endTime - startTime;
        System.out.println("-----------------------------------------");
        System.out.println("Total execution time: " + totalTime + " (milliseconds)");
    }

    public static void AfterTest()
    {
        driver.close(); // Close browser BUT keep driver actives.
        System.out.println("Closed browser.");
        driver.quit(); // Deactivate driver
        System.out.println("Driver is deactivated.");
    }
}
