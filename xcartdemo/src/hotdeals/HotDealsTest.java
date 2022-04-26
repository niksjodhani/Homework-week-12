package hotdeals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotDealsTest extends Utility {
    @Before
    public void setupbrowser() {
        openbrowser("https://mobile.x-cart.com/");
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() {
        mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse']/ul/li[2]/span"));
        clickOnMouseHoverOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a"));

        asserties(By.id("page-title"), "Sale", "not found");
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        clickOnMouseHoverOnElement(By.linkText("Name A - Z"));

    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() {
        mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse']/ul/li[2]/span"));
        clickOnMouseHoverOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a"));

        asserties(By.id("page-title"), "Sale", "not found");
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        clickOnMouseHoverOnElement(By.linkText("Price Low - High"));

    }

    @Test
    public void verifySaleProductsArrangeByRates() {
        mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse']/ul/li[2]/span"));
        clickOnMouseHoverOnElement(By.xpath("//*[@id='header-area']/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a"));

        asserties(By.id("page-title"), "Sale", "not found");
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        clickOnMouseHoverOnElement(By.linkText("Rates"));
    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() {
        mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse']/ul/li[2]/span"));
        clickOnMouseHoverOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span"));

        asserties(By.id("page-title"), "Bestsellers", "not found");
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        clickOnMouseHoverOnElement(By.linkText("Name Z - A"));
    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        //mouse hover on Hot deals
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
        //mouse hover and click on BestSeller
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/ul[1]/li[2]/child::a"));
        //Verify the text
        asserties(By.tagName("h1"),"Bestsellers","not found");
        //sort by Z to A
        mouseHoverOnElement(By.className("sort-by-label"));
        //actual product list
        List<WebElement> originalProductList = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/descendant::span[@class='price product-price']"));
        //create the list object
        List<Double> sortPriceList = new ArrayList();
        /*remove $ sign and add the sortPriceList
        //add all web element value to list object*/
        for (WebElement element : originalProductList) {
            sortPriceList.add(Double.valueOf(element.getText().replace("$", "")));
        }
        Collections.sort(sortPriceList, Collections.reverseOrder());
        //Mouse hover on “Sort By”
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        //select “Price: Low to High”
        clickFindElement(By.partialLinkText("Price High - L"));
        Thread.sleep(1000);
        List<WebElement> actualProductListElements = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']/child::li/child::div/descendant::span[@class='price product-price']"));
        //create the list object
        List<Double> actualPriceList = new ArrayList();
        /*remove $ sign and add the sortPriceList
        add all web element value to list object*/
        for (WebElement element : actualProductListElements) {
            actualPriceList.add(Double.valueOf(element.getText().replace("$", "")));
        }
        Assert.assertEquals(sortPriceList, actualPriceList);
    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() {
        //mouse hover on Hot deals
        mouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/child::span"));
        //mouse hover and click on BestSeller
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/li[2]/ul[1]/li[2]/child::a"));
        //Verify the text
        asserties(By.tagName("h1"), "Bestsellers", "not found");

    }

    @After
    public void close() {
        closebrowser();
    }

}


