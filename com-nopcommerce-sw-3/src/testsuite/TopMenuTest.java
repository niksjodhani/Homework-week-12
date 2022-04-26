package testsuite;

import utilities.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setup() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {

        clickFindElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/computers']"));
        asserties(By.xpath("//div[@class='page-title']"),"Computers","Not found");
        }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {

        clickFindElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/electronics']"));
        asserties(By.xpath("//div[@class='page-title']"),"Electronics","Not found");

    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        clickFindElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/apparel']"));
        asserties(By.xpath("//div[@class='page-title']"),"Apparel","Not found");
    }

    @Test
    public void userShouldNavigateToDigitaldownloadsPageSuccessfully() {

        clickFindElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/digital-downloads']"));
        asserties(By.xpath("//div[@class='page-title']"),"Digital downloads","Not found");
    }


    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {

        clickFindElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/books']"));
        asserties(By.xpath("//div[@class='page-title']"),"Books","Not found");


    } @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        clickFindElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/jewelry']"));
        asserties(By.xpath("//div[@class='page-title']"),"Jewelry","Not found");


    } @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        clickFindElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/gift-cards']"));
        asserties(By.xpath("//div[@class='page-title']"),"Gift Cards","Not found");


    }
    @After
    public void setupclose(){
        closeBrowser();
    }

}
