package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";


    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplay() {
        // click on the ‘Create an Account’link
        driver.findElement(By.xpath("(//a[text()='Create an Account'])[1]")).click();
        String expectedMessage = "Create New Customer Account";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[text()='Create New Customer Account']"));
        String actualMessage = actualTextElement.getText();
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        driver.findElement(By.xpath("//a[text()='Create an Account']")).click();

        //enter firstname
        driver.findElement(By.id("firstname")).sendKeys("Marrim");

        //enter last name
        driver.findElement(By.id("lastname")).sendKeys("Smithiiees");

        //Enter email address
        driver.findElement(By.name("email")).sendKeys("miiasmith34@gmail.com");


        //Click on checkbox Sign Up for Newsletter
        driver.findElement(By.xpath("//span[text()='Sign Up for Newsletter']")).click();


        //Enter Password
        driver.findElement(By.name("password")).sendKeys("Prime123");

        //confirm password
        driver.findElement(By.name("password_confirmation")).sendKeys("Prime123");

        //Click on Create an Account button
        driver.findElement(By.xpath("//span[text()='Create an Account']")).click();


        // WebElement actualTextElement = driver.findElement(By.xpath("//div[text()='Thank you for registering with Main Website Store.’]"));
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));

        // Verify the text 'Thank you for registering with Main Website Store.
        String expectedMessage = "'Thank you for registering with Main Website Store.’";

        // Assert.assertEquals(expectedMessage,actualMessage);
        driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();

        //driver.findElement(By.xpath("//button[@type='button'][1]"));
        driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")).click();

    }

    @After

    public void closeBrowser() {
       driver.quit();


    }
}