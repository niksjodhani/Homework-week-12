package homepage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    @Before
    public void setupbrowser()  {
        openbrowser(" https://mobile.x-cart.com/");

    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() {

        clickOnMouseHoverOnElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[3]/a[1]/span[1]"));

        asserties(By.xpath("//h1[@id='page-title']"), "Shipping", "not found");
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() {
        clickFindElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[4]/a[1]/span[1]"));
        asserties(By.xpath("//h1[@id='page-title']"), "New arrivals", "not found");
    }
    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() {
        clickFindElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[5]/a[1]/span[1]"));
        asserties(By.xpath("//h1[@id='page-title']"), "Coming soon", "not found");
    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
       clickFindElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[6]/a[1]/span[1]"));
  asserties(By.xpath("//h1[@id='page-title']"),"Contact us","not found");
    }

public void setdown(){
        closebrowser();
}
}
