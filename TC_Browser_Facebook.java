package TC_WEB;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Nam on 5/25/2017.
 */
public class TC_Browser_Facebook {
    public static  void Registration() throws InterruptedException {
        // Setup gecko driver to run Firefox (Should: Selenium > 3.0)
        String geckoPath = "C://Users//Nam//FireFoxDriver//geckodriver.exe";
        System.setProperty("webdriver.gecko.driver",geckoPath);

        WebDriver driver = new FirefoxDriver();

        // Enter link
        driver.get("https://www.facebook.com");

        // Check if English is disabled (its mean: !enable)
        WebElement labelEnglish = driver.findElement(By.xpath("//*[@id=\"pageFooter\"]/ul/li[2]/a"));
        if(!labelEnglish.isSelected())
        {
            // Enable - click it
            driver.findElement(By.xpath("//*[@id=\"pageFooter\"]/ul/li[2]/a")).click();
            System.out.println("Selected English.");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        // Enter Email
        driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
        System.out.println("Entered Email");

        // Enter Password
        driver.findElement(By.id("pass")).sendKeys("123456789");
        System.out.println("Entered Password");

        // Click Đăng nhập
        //driver.findElement(By.id("u_0_0")).click();
        //System.out.println("Clicked Đăng Nhập");

        // Enter First Name
        driver.findElement(By.name("firstname")).sendKeys("Nicolas");
        System.out.println("Entered First Name");

        // Enter Last Name
        driver.findElement(By.name("lastname")).sendKeys("Cage");
        System.out.println("Entered Last Name");

        //Enter Mobile Number or Email
        driver.findElement(By.name("reg_email__")).sendKeys("abc123@gmail.com");
        System.out.println("Entered Email");

        // Re-Enter Email
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("abc123@gmail.com");
        System.out.println("Re-Enter Email");

        // Enter New Password
        driver.findElement(By.name("reg_passwd__")).sendKeys("113qwe779");
        System.out.println("Entered New Password");

        // Select Day/Month/Year
        // Find Day dropdown list
        WebElement day = driver.findElement(By.name("birthday_day"));
        Select dl_Day = new Select(day);
        // -------- Get value of Day --------
        dl_Day.selectByValue("20");
        System.out.println("1 - Selected Day: 20");

        WebDriverWait wait_5_unitl_Moth = new WebDriverWait(driver, 5);

        // Find Month dropdown list
        WebElement month = driver.findElement(By.name("birthday_month"));
        Select dl_Month = new Select(month);
        // -------- Get value of Month --------
        dl_Month.selectByValue("6");
        System.out.println("2 - Selected Month: 6");

        WebDriverWait wait_5_unitl_Year = new WebDriverWait(driver, 5);

        // Find Year dropdown list
        WebElement year = driver.findElement(By.name("birthday_year"));
        Select dl_Year = new Select(year);
        // -------- Get value of Year --------
        dl_Year.selectByValue("1992");
        System.out.println("3 - Selected Year: 1992");

        // Select Gender
        WebDriverWait waitForrbMale = new WebDriverWait(driver,7);
        waitForrbMale.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"u_0_4\"]")));
        driver.findElement(By.xpath("//*[@id=\"u_0_4\"]")).click();
        System.out.println("Selected Male");

        Thread.sleep(2000);

        // Click Create an account
        driver.findElement(By.xpath("//*[@id=\"reg_form_box\"]/div[9]/button")).click();
        System.out.println("Clicked Create an account");

        // Wait until Error mess. appears
        WebDriverWait wait_for_error = new WebDriverWait(driver,40);
        wait_for_error.until(ExpectedConditions.visibilityOfElementLocated(By.id("reg_error_inner")));

        // Create a string to compare with element error mess.
        String same_Email = "Too many users have this email listed as pending.";
        String error = "An error occurred. Please try again.";
        String sameEmailUser = driver.findElement(By.id("reg_error_inner")).getText();
        System.out.println("Mess. ERROR: " + sameEmailUser.toString());

         //Compare with var. error mess.
        assertEquals(sameEmailUser,error);
        System.out.println("Same text.");

        // Click on "Quên tài khoản"
        driver.findElement(By.xpath("//*[@id=\"login_form\"]/table/tbody/tr[3]/td[2]/div/a")).click();
        System.out.println("Clicked Quên tài khoản?");

        // Enter Email or phone No.
        driver.findElement(By.id("identify_email")).sendKeys("01234567890");
        System.out.println("Entered Phone No.");

        // Click Tìm kiếm
        driver.findElement(By.id("u_0_2")).click();
        System.out.println("Clicked Tìm kiếm");

        // Backt to Home Page
        driver.navigate().back();
        System.out.println("Back the 1st time.");
        driver.navigate().back();
        System.out.println("Back the 2nd times.");
        // Wait for page loading
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Wait for Loading Page - 5s.");

        // Click on "Data Policy"
        driver.findElement(By.xpath("//*[@id=\"privacy-link\"]")).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)).getTitle();
        System.out.println("Switch to new Tab.");

        System.out.println("Done Test...");
    }

    public  static  void main (String[] args ) throws InterruptedException {
        try {
            Registration();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
