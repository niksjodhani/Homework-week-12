package computer;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class TestSuite extends Utility {
    @Before
    public void startup() {
        String baseUrl = "https://demo.nopcommerce.com/ftrfgtrrgrftfvgvtgtti-";
        openbrowser(baseUrl);

    }

    @Test
    public void Testname() {
        clickFindElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        clickFindElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Price: Low to High");
        asserties(By.xpath("//span[contains(text(),'$500.00')]"), "$500.00", "not found");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        clickFindElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        clickFindElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//div[@class='products-wrapper']//div/div/div[1]//div[@class='buttons']/button[1]")).click();
        clickFindElement(By.xpath("//div[@class='products-wrapper']//div/div/div[1]//div[@class='buttons']/button[1]"));
        asserties(By.xpath("//h1[contains(text(),'Build your own computer')]"), "Build your own computer", "not found");
        selectByIndexFromDropDown(By.id("product_attribute_1"), 1);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        Thread.sleep(2000);
        clickFindElement(By.xpath("//input[@id='product_attribute_3_7']"));
        Thread.sleep(500);
        clickFindElement(By.xpath("//input[@id='product_attribute_4_9']"));
        Thread.sleep(2000);
        //   clickFindElement(By.xpath("//input[@id='product_attribute_5_10']"));
        Thread.sleep(2000);
        clickFindElement(By.xpath("//input[@id='product_attribute_5_12']"));
        Thread.sleep(2000);
        asserties(By.xpath("//span[@id='price-value-1']"), "$1,475.00", "not found");
        clickFindElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        getActulmassageexpectedword(By.xpath("//p[@class='content']"), 0, 35, "The product has been added to your ", "not added");
        clickFindElement(By.xpath("//span[@title='Close']"));
        Thread.sleep(2000);
        clickOnMouseHoverOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        asserties(By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart", "not found");


        //updating the qty to 2

        driver.findElement(By.xpath("//tbody/tr/td[5]/input")).sendKeys(Keys.CONTROL + "a");
        Thread.sleep(2000);
        //updating the qty to 2
        sendTextToElement(By.xpath("//tbody/tr/td[5]/input"), "2");
        clickFindElement(By.xpath("//button[@id='updatecart']"));
        Thread.sleep(2000);
        asserties(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"), "$2,950.00", "not found");
//        2.18 click on checkbox “I agree with the terms of service”
        clickFindElement(By.xpath("//input[@id='termsofservice']"));
//        2.19 Click on “CHECKOUT”
        clickFindElement(By.xpath("//button[@id='checkout']"));
//        2.20 Verify the Text “Welcome, Please Sign In!”
        asserties(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!", "not found");
//        2.21Click on “CHECKOUT AS GUEST” Tab
        clickFindElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
//        2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "ramesh");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "kothari");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "kothari@123.gmail.com");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Company']"), "kothari pvt.ltd.");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "India");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "Other");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "surat");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "Ringroad");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address2']"), "railway station");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "395008");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "9800097000");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FaxNumber']"), "123456789102");


//        2.23 Click on “CONTINUE”
        clickFindElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

//        2.24 Click on Radio Button “Next Day Air($0.00)”
        clickFindElement(By.xpath("//input[@id='shippingoption_1']"));

//        2.25 Click on “CONTINUE”
        Thread.sleep(2000);
        clickFindElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
//        2.26 Select Radio Button “Credit Card”
        clickFindElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickFindElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
//        2.27 Select “Master card” From Select credit card dropdown
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
//        2.28 Fill all the details
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "ramesh kothari");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5404 0000 0000 0068");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "08");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2024");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "566");
//        2.29 Click on “CONTINUE”
        clickFindElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
//        2.30 Verify “Payment Method” is “Credit Card”
        asserties(By.xpath("//span[contains(text(),'Credit Card')]"), "Credit Card", "not valid");
        //        2.32 Verify “Shipping Method” is “Next Day Air”
        asserties(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"), "Next Day Air", "not valid");

//        2.33 Verify Total is “$2,950.00”
        asserties(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"), "$2,950.00", "not found");
//        2.34 Click on “CONFIRM”
        Thread.sleep(2000);
        clickFindElement(By.xpath("//button[contains(text(),'Confirm')]"));
//        2.35 Verify the Text “Thank You”
        asserties(By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you", "error occure");
//        2.36 Verify the message “Your order has been successfully processed!”
        asserties(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!", "not complate");
//        2.37 Click on “CONTINUE”
        clickFindElement(By.xpath("//button[contains(text(),'Continue')]"));
//        2.37 Verify the text “Welcome to our store”
        asserties(By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store", "error occur");
    }

    @After
    public void close() {
        closebrowser();
    }
}