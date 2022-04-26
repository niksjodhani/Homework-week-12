package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Utility extends BaseTest {

    //click on any button
    public void clickFindElement(By by) {
        driver.findElement(by).click();

    }

    //Get send text to element
    public void sendTextToElement(By by, String sendtext) {
        driver.findElement(by).sendKeys(sendtext);
    }

    //Get TEXT Method
    public String getTextToElment(By by) {
        return driver.findElement(by).getText();
    }

    //Get actual massge only expectedword
    public void getActulmassageexpectedword(By by, int start, int end, String expectedText, String usermassege) {
        WebElement actualText1 = driver.findElement(by);
        String actualText = actualText1.getText();
        String actualTextFinal = actualText.substring(start, end);
        String expectedText1 = expectedText;
        String massage = usermassege;
        //validate actual and expected text
        Assert.assertEquals(usermassege, expectedText1, actualTextFinal);

    }


    //Get assert method
    public void asserties(By by, String expectedText, String usermassege) {
        WebElement actualText1 = driver.findElement(by);
        String actualText = actualText1.getText();
        String expectedText1 = expectedText;

        String massage = usermassege;
        //validate actual and expected text
        Assert.assertEquals(usermassege, expectedText1, actualText);


    }

    //Get assert method
    public void assertiesInt(By by, int expectedText, String usermassege) {
        int expectedResult = expectedText;
        List<WebElement> item = driver.findElements(by);
        int list = item.size();
        Assert.assertEquals("error occured", expectedResult, list);

    }
}

