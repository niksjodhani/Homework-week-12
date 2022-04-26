package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        //from BaseTest class.. calling method
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //find userName WebElement by id
        sendTextToElement(By.id("username"), "tomsmith");
        //find password field webelement by name and Sending password to password filed element
        sendTextToElement(By.id("password"), "SuperSecretPassword!");
        //find login element and click
        clickFindElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        //verify user is login page
        asserties(By.xpath("//h2[contains(text(),'Secure Area')]"), "Secure Area", "user not found");
    }

    @Test
    public void verifyTheUsernameErrorMessage() {

        sendTextToElement(By.id("username"), "tomsmith1");
        sendTextToElement(By.id("password"), "SuperSecretPassword!");
        clickFindElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        getActulmassageexpectedword(By.xpath("//div[@id='flash']"), 0, 25, "Your username is invalid!", "not found");

    }

    @Test
    public void verifyThePasswordErrorMessage() {
        sendTextToElement(By.id("username"), "tomsmith");
        sendTextToElement(By.id("password"), "SuperSecretPassword");
        clickFindElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        getActulmassageexpectedword(By.xpath("//div[@id='flash']"), 0, 25, "Your password is invalid!", "not found");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}