package sumeyye;


import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
    public class TestCase3 extends TestBase {
        @Test
        public void test03() {
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
            //6. Enter incorrect email address and password
            Faker faker=new Faker();
            Actions actions=new Actions(driver);
            WebElement emailElementi=driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]"));
            actions.click(emailElementi)
                    .sendKeys(faker.internet().emailAddress())
                    .sendKeys(Keys.TAB)
                    .sendKeys(faker.internet().password())
                    .sendKeys(Keys.ENTER).perform();
            //7. Click 'login' button
            driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
            //8. Verify error 'Your email or password is incorrect!' is visible
            WebElement incorrectYaziElementi= driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"));
            Assert.assertTrue(incorrectYaziElementi.isDisplayed());
        }
    }

