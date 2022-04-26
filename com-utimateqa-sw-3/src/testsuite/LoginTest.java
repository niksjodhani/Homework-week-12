package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void open() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {


        clickFindElement(By.linkText("Sign In"));
        asserties(By.xpath("//h1[@class='page__heading']"), "Welcome Back!", "error occured");


    }

    @Test
    public void verifyTheErrorMessage() {
        clickFindElement(By.linkText("Sign In"));
        sendTextToElement(By.id("user[email]"), "abc@gmail.com");
        sendTextToElement(By.id("user[password]"), "123456");
        clickFindElement(By.xpath("//input[@type='submit']"));
        asserties(By.xpath("//li[@class='form-error__list-item']"), "Invalid email or password.", "Error occured");
    }


    @After
    public void close() {
        closeBrowser();
    }


}
