package TC_WEB;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Nam on 5/25/2017.
 */
public class TC_Browser {

    public  static  void main (String[] args )
    {
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
        // Click "Dăng Ký" button without information
        driver.findElement(By.xpath("//*[@id=\"registerForm\"]/table/tbody/tr[10]/td[2]/button")).click();
        // Enter "Tên"
        driver.findElement(By.id("FirstName")).sendKeys("Nam");
        // Enter "Họ"
        driver.findElement(By.id("LastName")).sendKeys("Nguyễn");
        // Enter "Email"
        driver.findElement(By.id("register_email")).sendKeys("hoainamvn2014@gmail.com");
        // Click "Chọn tỉnh/thành"
        driver.findElement(By.id("StateProvinceId")).click();
        // Select "TP. HCM"
        driver.findElement(By.xpath("//*[@id=\"StateProvinceId\"]/option[2]")).click();
        // Enter "Mật Khẩu"
        driver.findElement(By.id("register_pass")).sendKeys("lamjcopassAnh2");
        // Enter "Nhập Lại Mật Khẩu"
        driver.findElement(By.id("ConfrimPassword")).sendKeys("lamjcopassAnh2");
        // Check "I'm not a robot"
        driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[5]")).click();
        // Click "Đăng Ký"
        driver.findElement(By.xpath("//*[@id=\"registerForm\"]/table/tbody/tr[10]/td[2]/button")).click();
    }
}
