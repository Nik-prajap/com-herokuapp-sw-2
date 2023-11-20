package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp () {
        openBrowserSetup(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {

        // Enter Username in Username Field
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tomsmith");
        Thread.sleep(2000);
        // Enter Password in Password Field
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SuperSecretPassword!");
        Thread.sleep(2000);
        // Click on Login Button
        driver.findElement(By.xpath("//i")).click();
        Thread.sleep(2000);

        Assert.assertEquals("Secure Area","Secure Area");
    }

    @Test
    public void verifyTheUsernameErrorMessage() throws InterruptedException {

        // Enter Username in Username Field
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tomsmith1");
        Thread.sleep(2000);
        // Enter Password in Password Field
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SuperSecretPassword!");
        Thread.sleep(2000);
        // Click on Login Button
        driver.findElement(By.xpath("//i")).click();
        Thread.sleep(2000);

        Assert.assertEquals("Your username is invalid!","Your username is invalid!");

    }

    @Test
    public void verifyThePasswordErrorMessage() throws InterruptedException {

        // Enter Username in Username Field
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tomsmith");
        Thread.sleep(2000);
        // Enter Password in Password Field
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SuperSecretPassword");
        Thread.sleep(2000);
        // Click on Login Button
        driver.findElement(By.xpath("//i")).click();
        Thread.sleep(2000);

        Assert.assertEquals("Your password is invalid!","Your password is invalid!");
    }

    @After
    public void tearDown() {
        closeBrowserSetup();
    }
}
