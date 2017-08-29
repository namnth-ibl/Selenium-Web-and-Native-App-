package TC_WEB;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

/**
 * Created by Nam on 5/25/2017.
 */
public class TC_Browser_Facebook {
    public static  void Registration()
    {
        // Setup gecko driver to run Firefox (Should: Selenium > 3.0)
        String geckoPath = "C://Users//Nam//FireFoxDriver//geckodriver.exe";
        System.setProperty("webdriver.gecko.driver",geckoPath);

        WebDriver driver = new FirefoxDriver();

        // Enter link
        driver.get("https://www.facebook.com");

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
        driver.findElement(By.id("u_0_7")).click();
        System.out.println("Selected Male");

        System.out.println("Done Test...");
    }

    public  static  void main (String[] args )
    {
        Registration();
    }
}
