package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";


    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find login link and click on login link
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')][1]")).click();

        //Enter email address
        driver.findElement(By.id("email")).sendKeys("mmaariiasmith34@gmail.com");

        //Enter Password
        driver.findElement(By.name("login[password]")).sendKeys("Prime123");

        //click on signin
        driver.findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();

        // String expectedMessage = "Welcome, Mariam Smithies!";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='logged-in'][normalize-space()='Welcome, Mariam Smithies!']"));
    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {


        driver.findElement(By.xpath("//a[contains(text(),'Sign In')][1]")).click();
        driver.findElement(By.id("email")).sendKeys("1mmassmith@gmail.com");
        driver.findElement(By.name("login[password]")).sendKeys("Prime23");
        driver.findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
        driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));


        String expectedMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        // String actualMessage = actualTextElement.getText();
        // Assert.assertEquals(expectedMessage, actualTextElement);
    }


    @Test
    public void userShouldLogOutSuccessfully() {
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')][1]")).click();
        driver.findElement(By.id("email")).sendKeys("mmaariiasmitth38@gmail.com");
        driver.findElement(By.name("login[password]")).sendKeys("Prime123");
        driver.findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='logged-in'][normalize-space()='Welcome, Mariam Smithies!']"));
        driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();
        driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")).click();


    }
    @After

    public void closeBrowser() {
        driver.quit();


    }
}