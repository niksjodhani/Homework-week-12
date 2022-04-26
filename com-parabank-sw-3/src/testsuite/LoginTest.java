package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    @Before
    public void startup() {
        String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
        openbrowser(baseUrl);

    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        sendTextToElement(By.xpath("//div[@class='login']//input[@name='username']"), "Ramesh123");
        sendTextToElement(By.xpath("//div[@class='login']//input[@name='password']"), "123456");
        clickFindElement(By.xpath("//input[@class='button']"));
        // Verify the ‘Accounts Overview’ text is display
        asserties(By.xpath("//a[contains(text(),'Accounts Overview')]"), "Accounts Overview", "not found it means you are not log in");

    }

    @Test
    public void verifyTheErrorMessage() {
        sendTextToElement(By.xpath("//div[@class='login']//input[@name='username']"), "Ramesh12345");
        sendTextToElement(By.xpath("//div[@class='login']//input[@name='password']"), "");
        clickFindElement(By.xpath("//input[@class='button']"));
        // Verify the ‘Accounts Overview’ text is display
        asserties(By.xpath("//p[contains(text(),'Please enter a username and password.')]"), "Please enter a username and password.", "not found it means you are not ragister");


    }

    @Test
    public void userShouldLogOutSuccessfully() {
        sendTextToElement(By.xpath("//div[@class='login']//input[@name='username']"), "Ramesh12345");
        sendTextToElement(By.xpath("//div[@class='login']//input[@name='password']"), "");
        clickFindElement(By.xpath("//input[@class='button']"));
        //logout click
        clickFindElement(By.xpath("//a[@href=\"/parabank/logout.htm\"]"));
        asserties(By.xpath("//h2[contains(text(),'Customer Login')]"), "Customer Login", "you are not logout");

    }

}
