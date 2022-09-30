package tulay;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class TestCase3 extends TestBase {

    @Test
    public void name() {
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

    //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[@alt='Website for automation practice']")).isDisplayed());

    //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

    //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());

    //6. Enter incorrect email address and password
    //7. Click 'login' button
        Actions actions=new Actions(driver);
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("tulay@gmail.com");
        actions.sendKeys(Keys.TAB).sendKeys("123456")
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

    //8. Verify error 'Your email or password is incorrect!' is visible
        String expectedData="Your email or password is incorrect!";
        String actualData= driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).getText();
        Assert.assertEquals(actualData, expectedData);
}
}