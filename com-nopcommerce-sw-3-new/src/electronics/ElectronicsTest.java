package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.List;

public class ElectronicsTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void open() {
        openbrowser(baseUrl);
    }

    @Test
    public void textVerified()
    {
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));
        asserties(By.xpath("//h1[contains(text(),'Cell phones')]"),"Cell phones","not found");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));
        clickOnMouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));
        asserties(By.xpath("//h1[contains(text(),'Cell phones')]"),"Cell phones","not found");
        clickFindElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(2000);
        clickFindElement(By.xpath("//div[@class='details']//a[contains(text(),'Nokia Lumia 1020')]"));
        Thread.sleep(2000);
        asserties(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"),"Nokia Lumia 1020","not found");
        // t0 verify the price
        asserties(By.xpath("//span[@id='price-value-20']"),"$349.00","not found");

        Actions action = new Actions(driver);
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys(Keys.CONTROL + "a");
        Thread.sleep(2000);
        //updating the qty to 2
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        clickFindElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        asserties(By.xpath("//div[@id='bar-notification']/div/p"), "The product has been added to your shopping cart","not found");
        Thread.sleep(1000);
        clickFindElement(By.cssSelector("span.close"));

        mouseHoverOnElement(By.xpath("//li[@id='topcartlink']/a/span[1]"));
        Thread.sleep(2000);
        clickOnMouseHoverOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        asserties(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart","not found");
        //assertVerifyText(By.xpath("//input[@value='2']"),"2");
        asserties(By.xpath("//td[@class='subtotal']/span"),"$698.00","not found");

        clickFindElement(By.id("termsofservice"));
        clickFindElement(By.id("checkout"));
        asserties(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!","not found");
        clickFindElement(By.xpath("//a[@class ='ico-register']"));
        clickFindElement(By.xpath("//span[@class='male']"));
        sendTextToElement(By.id("FirstName"),"Ramesh");
        sendTextToElement(By.id("LastName"),"Kothari");

        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthDay']"),"10");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"),"September");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"),"1980");

        sendTextToElement(By.id("Email"),"rameshkothari@gmail.com");
        sendTextToElement(By.id("Password"),"123456");
        sendTextToElement(By.id("ConfirmPassword"),"123456");

        clickFindElement(By.id("register-button"));

        asserties(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]"),"Your registration completed","not found");
        clickFindElement(By.xpath("//a[contains(text(),'Continue')]"));

        asserties(By.xpath("//h1[contains(text(),'Shopping cart')]"),"Shopping cart","not found");

        clickFindElement(By.id("termsofservice"));
        clickFindElement(By.id("checkout"));

        // sendTextToElement(By.id("BillingNewAddress_FirstName"),"abc");
        //sendTextToElement(By.id("BillingNewAddress_LastName"),"xyz");
        //sendTextToElement(By.id("BillingNewAddress_Email"),"abc@gmail.com");

        WebElement cnt = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select country = new Select(cnt);
        List<WebElement> allOptions =  country.getOptions();

        for(WebElement element : allOptions)
        {

            if(element.getText().equalsIgnoreCase("Romania"))
            {
                element.click();
            }
        }

        sendTextToElement(By.id("BillingNewAddress_City"),"london");
        sendTextToElement(By.id("BillingNewAddress_Address1"),"54 street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"ha096bh");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"7800096000");
        clickFindElement(By.xpath("//button[text() = 'Continue']"));

        clickFindElement(By.id("shippingoption_2"));
        Thread.sleep(2000);
        clickFindElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));

        clickFindElement(By.xpath("//input[@id='paymentmethod_1']")); //credit card
        clickFindElement(By.xpath("//div[@id='checkout-step-payment-method']/div/button"));//continue

        selectByVisibleTextFromDropDown(By.id("CreditCardType"),"Visa");
        sendTextToElement(By.id("CardholderName"),"Ramesh");
        sendTextToElement(By.id("CardNumber"),"5232 1478 4876 3353");

        selectByVisibleTextFromDropDown(By.id("ExpireMonth"),"05");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"),"2028");

        sendTextToElement(By.id("CardCode"),"552");
        clickFindElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));

        asserties(By.xpath("//li[@class='payment-method']/span[2]"),"Credit Card","not found");
        asserties(By.xpath("//li[@class='shipping-method']/span[2]"),"2nd Day Air","not found");
        asserties(By.xpath("//td[@class='subtotal']/span"),"$698.00","not found");
        clickFindElement(By.xpath("//button[text()='Confirm']"));

        asserties(By.xpath("//h1[contains(text(),'Thank you')]"),"Thank you","not found");
        asserties(By.xpath("//div[@class='section order-completed']//strong"),"Your order has been successfully processed!","not found");


        clickFindElement(By.xpath("//button[contains(text(),'Continue')]"));
        asserties(By.xpath("//h2[contains(text(),'Welcome to our store')]"),"Welcome to our store","not found");

        clickFindElement(By.xpath("//a[contains(text(),'Log out')]"));
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://demo.nopcommerce.com/",url);

    }

    @After
    public void close(){
        closebrowser();
    }
}
