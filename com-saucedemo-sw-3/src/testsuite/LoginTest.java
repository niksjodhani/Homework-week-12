package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void open() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {


        sendTextToElement(By.id("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        clickFindElement(By.id("login-button"));
        asserties(By.xpath("//span[@class = 'title']"), "PRODUCTS", "error occurs");

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        sendTextToElement(By.id("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        clickFindElement(By.id("login-button"));
        assertiesInt(By.className("inventory_item"), 6, "not found");

    }

    @After
    public void close() {

        closeBrowser();
    }
}