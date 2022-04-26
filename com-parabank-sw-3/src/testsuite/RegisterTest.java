package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void startup() {

        openbrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        // this is move into Registerpage via xpath
        clickFindElement(By.xpath("//a[contains(text(),'Register')]"));
        asserties(By.xpath("//h1[@class='title']"), "Signing up is easy!", "user is not in signing page");

    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        // this is move into Registerpage via xpath
        //click on the ‘Register’ link
        clickFindElement(By.xpath("//a[contains(text(),'Register')]"));
        // Enter First name

        sendTextToElement(By.id("customer.firstName"), "Ramesh");
        //Enter Last name

        sendTextToElement(By.id("customer.lastName"), "kothari");
        //Enter Address

        sendTextToElement(By.id("customer.address.street"), "wembley");
        //  Enter City

        sendTextToElement(By.id("customer.lastName"), "london");
        //	* Enter State

        sendTextToElement(By.id("customer.address.state"), "United kingdom");
        //	* Enter Zip Code

        sendTextToElement(By.id("customer.address.zipCode"), "HA96KC");
        //  * Enter Phone

        sendTextToElement(By.id("customer.phoneNumber"), "07777788888");
        //  * Enter SSN

        sendTextToElement(By.id("customer.ssn"), "123456789");
        //  * Enter Username

        sendTextToElement(By.id("customer.username"), "Ramesh123");
        // * Enter Password

        sendTextToElement(By.id("customer.password"), "123456");
        //  * Enter Confirm

        sendTextToElement(By.id("repeatedPassword"), "123456");


        //  * Click on REGISTER button
        clickFindElement(By.xpath("//table[@class='form2']//input[@type='submit']"));

        //  * Verify the text 'Your account was created successfully. You are now logged in.’
        asserties(By.xpath("//div[@id='rightPanel']/p"), "Your account was created successfully. You are now logged in.", "User is not register complate");

    }


}