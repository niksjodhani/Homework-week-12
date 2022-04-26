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
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup() {
        openbrowser(baseUrl);
    }

    @Test
    public void login() {
        //find username filed and send values
        sendTextToElement(By.id("txtUsername"), "Admin");
        sendTextToElement(By.id("txtPassword"), "admin123");
        clickFindElement(By.xpath("//input[@class='button']"));
        getActulmassageexpectedword(By.id("welcome"), 0, 7, "Welcome", "welcome twxt not found");
    }
}

