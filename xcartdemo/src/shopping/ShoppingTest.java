package shopping;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ShoppingTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void open() {
        openbrowser(baseUrl);
    }


    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForVinylIdolzGhostbusters() throws InterruptedException {
        mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse']/ul/li[2]/span"));
        clickOnMouseHoverOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span"));

        asserties(By.id("page-title"), "Bestsellers", "not found");
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        clickOnMouseHoverOnElement(By.linkText("Name A - Z"));

        mouseHoverOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[8]"));
        Thread.sleep(2000);
        clickFindElement(By.xpath("//ul[@class = 'products-grid grid-list']/li[8]/div/div[2]/div[4]/div/button"));

        asserties(By.xpath("//li[contains(text(),'Product has been added to your cart')]"), "Product has been added to your cart", "not found");
        clickFindElement(By.xpath("//div[@id='status-messages']/a"));

        clickFindElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(2000);
        clickFindElement(By.linkText("View cart"));

        asserties(By.id("page-title"), "Your shopping cart - 1 item", "not found");

        clickFindElement(By.xpath("//span[text()='Go to checkout']"));
        asserties(By.xpath("//h3[contains(text(),'Log in to your account')]"), "Log in to your account", "not found");
        sendTextToElement(By.id("email"), "abc@gmail.com");
        clickFindElement(By.xpath("//span[contains(text(),'Continue')]"));
        asserties(By.xpath("//*[@id=\"content\"]/div/div/div/div/div/h1"), "Secure Checkout", "not found");
        sendTextToElement(By.id("shippingaddress-firstname"), "abc");
        sendTextToElement(By.id("shippingaddress-lastname"), "xyz");
        sendTextToElement(By.id("shippingaddress-street"), "abc street");
        sendTextToElement(By.id("shippingaddress-custom-state"), "xyz");
        Thread.sleep(2000);
        clickFindElement(By.id("method128"));
        clickFindElement(By.id("pmethod6"));

        Thread.sleep(2000);
        clickFindElement(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[4]/button[1]"));

        asserties(By.xpath("//h1[@id='page-title']"), "Thank you for your order", "not found");
    }


    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
        mouseHoverOnElement(By.xpath("//div[@class='collapse navbar-collapse']/ul/li[2]/span"));
        clickOnMouseHoverOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span"));

        asserties(By.id("page-title"), "Bestsellers", "not found");
        mouseHoverOnElement(By.xpath("//div[@class='sort-box']"));
        clickOnMouseHoverOnElement(By.linkText("Name A - Z"));

        mouseHoverOnElement(By.xpath("//body/div[@id='mm-0']/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[8]"));
        Thread.sleep(2000);
        clickFindElement(By.xpath("//ul[@class = 'products-grid grid-list']/li[8]/div/div[2]/div[4]/div/button"));

        asserties(By.xpath("//li[contains(text(),'Product has been added to your cart')]"), "Product has been added to your cart", "not found");
        clickFindElement(By.xpath("//div[@id='status-messages']/a"));

        clickFindElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(2000);
        clickFindElement(By.linkText("View cart"));

        asserties(By.id("page-title"), "Your shopping cart - 1 item", "not found");

        clickFindElement(By.xpath("//a[contains(text(),'Empty your cart')]"));

        acceptAlert();

        asserties(By.xpath("//li[contains(text(),'Item(s) deleted from your cart')]"), "Item(s) deleted from your cart", "not found");
        asserties(By.xpath("//h1[contains(text(),'Your cart is empty')]"), "Your cart is empty", "not found");


    }


    @After
    public void close() {
        closebrowser();
    }

}
