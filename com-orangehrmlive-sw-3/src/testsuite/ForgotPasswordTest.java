package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ForgotPasswordTest extends Utility {
    @Before
    public void setup() {
        openbrowser("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {


        clickFindElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
        asserties(By.tagName("h1"), "Forgot Your Password?", "Forgot Your Password?' text not found");

    }


}
