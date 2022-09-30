package tulay;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase4 extends TestBase {
        @Test
        public void test() throws InterruptedException {
            //   1. Launch browser
            //   2. Navigate to url 'http://automationexercise.com'
            driver.get("http://automationexercise.com");

            //   3. Verify that home page is visible successfully
            Assert.assertTrue(driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']")).isDisplayed());

            //   4. Click on 'Signup / Login' button
            driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

            //   5. Verify 'Login to your account' is visible
            Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());

            //   6. Enter correct email address and password
            driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("eyup@gmail.com");
            Actions actions=new Actions(driver);
            actions.sendKeys(Keys.TAB).sendKeys("123456").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

            //   7. Click 'login' button
            //   8. Verify that 'Logged in as username' is visible
            Thread.sleep(3000);
            Assert.assertTrue(driver.findElement(By.xpath("//*[@class='fa fa-user']")).isDisplayed());

            //   9. Click 'Logout' button
            driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

            //   10. Verify that user is navigated to login page
            Assert.assertTrue(driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']")).isDisplayed());

    }
}
