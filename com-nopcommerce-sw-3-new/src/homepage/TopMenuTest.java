package homepage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.Scanner;

public class TopMenuTest extends Utility {
    @Before
    public void startup() {
        String baseUrl = "https://demo.nopcommerce.com/ftrfgtrrgrftfvgvtgtti-";
        openbrowser(baseUrl);

    }

    public void selectMenu(String menu) {
        if (menu == "Computer") {
            clickFindElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/computers']"));
            asserties(By.xpath("//h1[contains(text(),'Computers')]"),"Computers","not found");
        } else if (menu == "Apparel") {
            clickFindElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/apparel']"));
            asserties(By.xpath("//h1[contains(text(),'Apparel')]"),"Apparel","not found");
        } else if (menu == "Electronics") {
            clickFindElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/electronics']"));
            asserties(By.xpath("//h1[contains(text(),'Electronics')]"),"Electronics","not found");
        } else if (menu == "Digitaldownloads") {
            clickFindElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/digital-downloads']"));
           asserties(By.xpath("//h1[contains(text(),'Digital downloads')]"),"Digital downloads","not found");
        } else if (menu == "BooksPage") {
            clickFindElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/books']"));
            asserties(By.xpath("//h1[contains(text(),'Books')]"),"Books","not found");
        } else if (menu == "Jewelry") {
            clickFindElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/jewelry']"));
            asserties(By.xpath("//h1[contains(text(),'Books')]"),"Books","not found");
        } else if (menu == "GiftCards") {
        clickFindElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/gift-cards']"));
        asserties(By.xpath("//h1[contains(text(),'Gift Cards')]"),"Gift Cards","not found");

        }
    }

        @Test
        public void verifyPageNavigation () {
            selectMenu("Computer");
        }
    }
