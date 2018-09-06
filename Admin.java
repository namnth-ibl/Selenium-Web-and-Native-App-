package TC_WEB_ECOMMERCIAL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * Created by Nam on 8/11/2018.
 */
public class Admin {

    public static WebDriver driver = new ChromeDriver();
    public static ChromeOptions cOptions = new ChromeOptions();
    public static CollectionManagement coll = new CollectionManagement();

    public static void Admin_Management() {
        String geckoPath = "C://Users//Nam//BrowserDriver//chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",geckoPath);
        // Enable automation and disabled message info on Chrome
        cOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        cOptions.addArguments("disable-infobars");
        cOptions.addArguments("--disable-extensions");
        driver = new ChromeDriver(cOptions);
    }

    public static void Admin_Access(){
        // Access to Home page
        driver.get("http://ishopgo-admin.cktc.online");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println("Accessed to Admin page.");
        // Maximize the window
        driver.manage().window().maximize();
        System.out.println("Maximixed the window.");
    }
    
    public static void Admin_Login(){
        // Enter username
        driver.findElement(By.xpath("//*[@id=\"sign_in\"]/div[2]/div/input"))
                .sendKeys("ngocht");
        System.out.println("Entered username.");
        // Enter password
        driver.findElement(By.xpath("//*[@id=\"sign_in\"]/div[3]/div/input"))
                .sendKeys("123@");
        System.out.println("Entered password.");
        // Click Sign in
        driver.findElement(By.xpath("//*[@id=\"sign_in\"]/div[4]/div[2]/button")).click();
        System.out.println("Clicked Sign in.");
    }

    public static void Admin_Create_Group_Category(String name){
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
                .sendKeys(name);
        System.out.println("Entered Name.");

        // Upload icon 01
        WebElement Group_Cate_iconUpload = driver.findElement(By.name("icon"));
        Group_Cate_iconUpload.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        try {
            Runtime.getRuntime().exec("E://File_Setup//Studying//AutoIT//GroupCategory_Upload_Icon.exe");
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
            Runtime.getRuntime().exec("E://File_Setup//Studying//AutoIT//GroupCategory_Upload_Icon.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Uploaded Thumb");
        // Click CREATE
        driver.findElement(By.xpath("//*[@id=\"create_form\"]/button")).click();
        System.out.println("Clicked CREATE.");
    }

    public static void Admin_Create_Category(){
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
    }

    public static void Admin_Create_Product(){
        // Select Product
        driver.findElement(By.xpath("//*[@id=\"leftsidebar\"]/div[2]/ul/li[4]/a/span"));
        System.out.println("Selected Product.");
        // Click icon
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/section[2]/div/div/div[2]/div/div/div[1]/ul/li/a/i"))
                .click();
        // Click Create
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/section[2]/div/div/div[2]/div/div/div[1]/ul/li/ul/li/a/i"))
                .click();

        // Upload Product's image
        WebElement Pro_thumbUpload = driver.findElement(By.name("thumb"));
        Pro_thumbUpload.click();
        try {
            Runtime.getRuntime().exec("E://File_Setup//Studying//AutoIT//Product_Upload_Jacket001.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Uploaded Image.");

        // Enter Product Code
        driver.findElement(By.name("code")).sendKeys("SH001");
        System.out.println("Entered Product Code.");
        // Enter Product Name
        driver.findElement(By.name("name")).sendKeys("Levis Short");
        System.out.println("Entered Product Name.");
        // Enter Price
        driver.findElement(By.name("price")).sendKeys("26");
        System.out.println("Entered Price.");
        // Enter Sale Off
        driver.findElement(By.name("price_promo")).sendKeys("21");
        System.out.println("Entered Sale Off.");
        // Enter Quantity
        driver.findElement(By.name("quantity")).sendKeys("1");
        System.out.println("Entered Quantity");
        // Enter Total
        driver.findElement(By.name("total")).sendKeys("10");
        System.out.println("Entered Total.");
        // Enter Summary
        driver.findElement(By.xpath("//*[@id=\"create_form\"]/div[1]/div[2]/div[5]/div/div/div/textarea"))
                .sendKeys("This pair has just the right amount of stretch for all-day comfort. Great for all body types.");
        System.out.println("Entered Summary.");
        // Enter Brand
        driver.findElement(By.name("brand")).sendKeys("1A Cambridge");
        System.out.println("Entered Brand.");
        // // Select to Today Deal
        driver.findElement(By.xpath("//*[@id=\"create_form\"]/div[1]/div[2]/div[6]/div[2]/label")).click();
        System.out.println("Seleted Today Deal.");
        // Enter Description
        driver.findElement(By.xpath("//*[@id=\"rdw-wrapper-2078\"]/div[2]/div/div/div"))
                .sendKeys("This pair has just the right amount of stretch for all-day comfort. Great for all body types.");
        System.out.println("Entered Description.");
        // Click Create
        driver.findElement(By.xpath("//*[@id=\"create_form\"]/button")).click();
        System.out.println("Clicked Create.");
    }

    public static void Calculate_Time() {
        // START TIME
        long startTime = System.currentTimeMillis();
        // END TIME
        long endTime = System.currentTimeMillis();
        // Calculate Time
        long totalTime = endTime - startTime;
        System.out.println("-----------------------------------------");
        System.out.println("Total execution time: " + totalTime + " (milliseconds)");
        System.out.println("-----------------------------------------");
    }

    public static void AfterTest()
    {
        driver.close(); // Close browser BUT keep driver actives.
        System.out.println("Closed browser.");
        driver.quit(); // Deactivate driver
        System.out.println("Driver is deactivated.");
    }
}
