package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void register() {
        clickFindElement(By.linkText("Register"));
        clickFindElement(By.xpath("//label[@for='gender-male']"));
        //    driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        WebElement Male = driver.findElement(By.xpath("//label[@for='gender-male']"));
        WebElement Female = driver.findElement(By.xpath("//label[@for='gender-female']"));
        if (!Male.isSelected()) {
            Male.click();
        } else {

            Female.click();
        }
        //first name

        sendTextToElement(By.id("FirstName"),"prime");
        sendTextToElement(By.id("LastName"),"Testing");
        sendTextToElement(By.xpath("//select[@name='DateOfBirthDay']"),"28");
        sendTextToElement(By.xpath("//select[@name='DateOfBirthMonth']"),"08");
        sendTextToElement(By.xpath("//select[@name='DateOfBirthYear']"),"1990");
        sendTextToElement(By.id("Email"),"prime1234561@gmail.com");
        sendTextToElement(By.id("Company"),"primetesting");
        sendTextToElement(By.id("Password"),"123456@");
        sendTextToElement(By.id("ConfirmPassword"),"123456@");
       clickFindElement(By.xpath("//button[@id='register-button']"));


    }
    @After
    public void tearDown() {
       closeBrowser();
    }
}
