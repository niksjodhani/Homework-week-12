package testsuite;

import browserfactory.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

//before run this class  pls run RegisterTest class once
public class LoginTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void navigateToLogin() {
        //find login link and click on login link
        clickFindElement(By.linkText("Log in"));
        asserties(By.xpath("//div[@class='master-wrapper-content']//div[@class='page-title']"), "Welcome, Please Sign In!", "Not found");
    }

    //before run this methode pls run RegisterTest class once
    @Test
    public void loginverify() {

        clickFindElement(By.linkText("Log in"));
        sendTextToElement(By.id("Email"), "prime1234561@gmail.com");
        sendTextToElement(By.id("Password"), "123456@");

        clickFindElement(By.xpath("//button[@class='button-1 login-button']"));
        asserties(By.xpath("//div[@class=\"message-error validation-summary-errors\"]"), "Login was unsuccessful. Please correct the errors and try again.", "Not found");

    }

    @Test
    public void logout() {

        clickFindElement(By.linkText("Log in"));
        WebElement emailField = driver.findElement(By.id("Email"));
        sendTextToElement(By.id("Email"), "prime1234561@gmail.com");
        sendTextToElement(By.id("Password"), "123456@");
        asserties(By.xpath("//div[@class='header-links']//a[@href='/logout']"), "Log out", "User is Not Login Page");
        clickFindElement(By.xpath("//div[@class='header-links']//a[@href='/logout']"));

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}