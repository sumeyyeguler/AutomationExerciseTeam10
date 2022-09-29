package tulay;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase5 extends TestBase {

    @Test
    public void test1() {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']")).isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());

        //6. Enter name and already registered email address
        //7. Click 'Signup' button
        Actions actions=new Actions(driver);
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("tulay");
        actions.sendKeys(Keys.TAB).sendKeys("tulay28@gmail.com")
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        //8. Verify error 'Email Address already exist!' is visible
        String expectedData="Email Address already exist!";
        String actualData= driver.findElement(By.xpath("//*[text()='Email Address already exist!']")).getText();
        Assert.assertEquals(actualData, expectedData);
    }
}