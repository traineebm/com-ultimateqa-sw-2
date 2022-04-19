package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //Finding sign in link element and click on sign in link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        // Verify text from the given requirements
        String expectedMessage = "Welcome Back!";
        // Find the welcome text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String actualMessage = actualMessageElement.getText();

        //Validate expected and actual message
        Assert.assertEquals("Welcome Back message not displayed", expectedMessage,actualMessage);
    }
    @Test
    public void verifyTheErrorMessage(){
        //Finding sign in link element and click on sign in link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        //Finding the email field element
        WebElement userName = driver.findElement(By.id("user[email]"));
        userName.sendKeys("Asdfg@gmail.com");
        // Finding the password field element
        WebElement password = driver.findElement(By.id("user[password]"));
        password.sendKeys("abc123");
        // Finding the Sign in button and clicking on it
        WebElement signInButton = driver.findElement(By.xpath("//div/input[@value='Sign in']"));
        signInButton.click();

        // Verify text from the given requirements
        String expectedMessage = "Invalid email or password.";
        // Find the given text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessage = actualMessageElement.getText();

        //Validate expected and actual message
        Assert.assertEquals("Login unsuccessful", expectedMessage,actualMessage);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
