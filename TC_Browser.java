package TC_WEB;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

/**
 * Created by Nam on 5/25/2017.
 */
public class TC_Browser {

    public static  void Registration()
    {
        // Setup gecko driver to run Firefox (Should: Selenium > 3.0)
        String geckoPath = "C://Users//Nam//FireFoxDriver//geckodriver.exe";
        System.setProperty("webdriver.gecko.driver",geckoPath);

        WebDriver driver = new FirefoxDriver();
        // Enter link
        driver.get("https://www.foody.vn");
        driver.getTitle();
        // Click "Đăng Nhập"
        driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[1]/div/a/span")).click();
        // Enter "Email"
        driver.findElement(By.id("Email")).sendKeys("nam@gmail.com");
        // Enter "Password"
        driver.findElement(By.id("Password")).sendKeys("123qw234");
        // Click "Đăng Nhập"
        driver.findElement(By.id("signin_submit")).click();
        // Close popup of Firefox
        Alert alertPopup = driver.switchTo().alert();
        alertPopup.dismiss();
        // Click "Đăng Ký" link
        driver.findElement(By.className("register")).click();
        // get Title Page one more time
        driver.getTitle();
        // Handle switch page
        Set<String> windowHandler = driver.getWindowHandles();
        for(String windowMem : driver.getWindowHandles())
        {
            driver.switchTo().window(windowMem);
        }
//        WebDriverWait wait_for_Eelement = new WebDriverWait(driver,10);
//        wait_for_Eelement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"registerForm\"]/table/tbody/tr[10]/td[2]/button")));
//        // Click "Đăng Ký" button without information
//        driver.findElement(By.xpath("//*[@id=\"registerForm\"]/table/tbody/tr[10]/td[2]/button")).click();
        // Enter "Tên"
        WebDriverWait wait_for_Eelement = new WebDriverWait(driver,10);
        wait_for_Eelement.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirstName")));
        driver.findElement(By.id("FirstName")).sendKeys("Nam");
        // Enter "Họ"
        driver.findElement(By.id("LastName")).sendKeys("Nguyễn");
        // Enter "Email"
        driver.findElement(By.id("register_email")).sendKeys("hoainamvn2014@gmail.com");
        System.out.println("Đã enter Email");
        // Click "Chọn tỉnh/thành"
        WebDriverWait wait_5s = new WebDriverWait(driver,5);
        driver.findElement(By.xpath("//*[@id=\"StateProvinceId\"]")).click();
        System.out.println("Đã chọn Combo Box");
        // Select "TP. HCM"
        WebDriverWait wait_3s = new WebDriverWait(driver,3);
        driver.findElement(By.xpath("//*[@id=\"StateProvinceId\"]/option[2]")).click();
        System.out.println("Đã chọn HCM");
        // Enter "Mật Khẩu"
        driver.findElement(By.id("register_pass")).sendKeys("123123123");
        System.out.println("Đã enter mật khẩu");
        // Enter "Nhập Lại Mật Khẩu"
        WebDriverWait wait_for_Eelement01 = new WebDriverWait(driver,10);
        wait_for_Eelement01.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ConfirmPassword']")));
        driver.findElement(By.xpath("//*[@id='ConfirmPassword']")).sendKeys("123123123");
        System.out.println("Đã enter confirm mật khẩu");
        // Check "I'm not a robot"
        // ---- Switch to iFrame ----
        WebElement iFrame = driver.findElement(By.xpath("//*[@id=\"reCaptchaRegister\"]/div/div/iframe"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[5]")).click();
        System.out.println("Đã click Robot Captcha");
        // Click "Đăng Ký"
        driver.findElement(By.className("registerbutton")).click();
        System.out.println("Đã click đăng ký");
    }

    public  static  void main (String[] args )
    {
        Registration();
    }
}
