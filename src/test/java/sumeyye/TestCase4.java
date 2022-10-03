package sumeyye;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
    public class TestCase4 extends TestBase {
        @Test
        public void test01() {
            //1. Launch browser
            //2. Navigate to url 'http://automationexercise.com'
            driver.get("http://automationexercise.com");
            //3. Verify that home page is visible successfully
            WebElement homePage=driver.findElement(By.xpath("(//div[@class='col-sm-6'])[1]"));
            Assert.assertTrue(homePage.isDisplayed());
            //4. Click on 'Signup / Login' button
            driver.findElement(By.xpath("//a[@href='/login']")).click();
            //5. Verify 'Login to your account' is visible
            Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed());
            //6. Enter correct email address and password
            Actions actions=new Actions(driver);
            WebElement emailElementi=driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]"));
            actions.click(emailElementi)
                    .sendKeys("sumsum@gmail.com")
                    .sendKeys(Keys.TAB)
                    .sendKeys("123456")
                    .sendKeys(Keys.ENTER).perform();//burada login demiş olduk
            //7. Click 'login' button
            //driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
            //8. Verify that 'Logged in as username' is visible
            Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed());
            //9. Click 'Logout' button
            driver.findElement(By.xpath("//*[text()=' Logout']")).click();
            //10. Verify that user is navigated to login page
            String actualUrl=driver.getCurrentUrl();
            String expectedUrl="https://automationexercise.com/login";
            Assert.assertEquals(expectedUrl,actualUrl);
        }
    }

