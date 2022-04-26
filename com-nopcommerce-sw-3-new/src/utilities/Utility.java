package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {

    //click on any button
    public void clickFindElement(By by) {
        driver.findElement(by).click();

    }

    //Get send text to element
    public void sendTextToElement(By by, String sendtext) {
        driver.findElement(by).sendKeys(sendtext);
    } //Get send text to element



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


    //Get assert string method
    public void asserties(By by, String expectedText, String usermassege) {
        WebElement actualText1 = driver.findElement(by);
        String actualText = actualText1.getText();
        String expectedText1 = expectedText;

        String massage = usermassege;
        //validate actual and expected text
        Assert.assertEquals(usermassege, expectedText1, actualText);


    }

    //Get assert int method
    public void assertiesInt(By by, int expectedText, String usermassege) {
        int expectedResult = expectedText;
        List<WebElement> item = driver.findElements(by);
        int list = item.size();
        Assert.assertEquals("error occured", expectedResult, list);

    }

    /****Select class ******/
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByValueFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    public void selectByIndexFromDropDown(By by, int a) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(a);
    }
    public void selectByGetAllOptionFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement element : allOptions
        ) {
            //System.out.println(element.getText());//to print all countries
            if (element.getText().equals(text)) {
                element.click();
            }
        }
    }



    // ************ Mouse Hover ***************//
    public void mouseHoverOnElement (By by){
        Actions actions = new Actions(driver);
        WebElement expected  =driver.findElement(by);
        actions.moveToElement( expected ).build().perform();
    }
    public void clickOnMouseHoverOnElement (By by){
        Actions actions = new Actions(driver);
        WebElement expected  =driver.findElement(by);
        actions.moveToElement( expected ).click().build().perform();
    }


}


