package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {
        driver.findElement(By.xpath("//span[text()='Sale']")).click();
        driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
        String expectedMessage = "Jackets";
        WebElement actualElement = driver.findElement(By.xpath("//span[@class='base']"));
        String actualMessage = actualElement.getText();
        Assert.assertEquals("Not found", expectedMessage, actualMessage);
        List<WebElement> multiElement = driver.findElements(By.xpath("//strong[@class='product name product-item-name']"));
        System.out.println("Total Items are: " + multiElement.size());
        for (WebElement list : multiElement) {
            String name1 = list.getText();
            System.out.println(name1);
        }
        int expectedItems = 12;
        Assert.assertEquals("Not found", expectedItems, multiElement.size());
    }
    @After
    public void tearDown() {
       // driver.quit();

    }
}