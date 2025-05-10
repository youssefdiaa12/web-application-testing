package UserStory3;

import WebDriverSetUp.WebDriverSetUp1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class TCR001 {
    public static WebDriver driver;
    @Test
    public WebDriver registerAccountWithMendatoryFields() throws InterruptedException {
        WebDriverSetUp1 webDriverSetUp1 = new WebDriverSetUp1();
        driver= webDriverSetUp1.setupWebDriver();
        driver.get("https://parabank.parasoft.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")));
        WebElement RegisterHyberLink = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a"));
//        Assert.assertTrue(RegisterHyberLink.isDisplayed(), "Register hyperlink should be displayed");
        RegisterHyberLink.click();
        driver.findElement(By.id("customer.firstName")).sendKeys("Test");
        driver.findElement(By.id("customer.lastName")).sendKeys("Test");
        driver.findElement(By.id("customer.address.street")).sendKeys("Test");
        driver.findElement(By.id("customer.address.city")).sendKeys("Test");
        driver.findElement(By.id("customer.address.state")).sendKeys("Test");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("12345");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("1234567890");
        driver.findElement(By.id("customer.ssn")).sendKeys("123-45-6789");
      Date date = new Date();
      String username = "Test" + date.getTime();
        driver.findElement(By.id("customer.username")).sendKeys(username);
        driver.findElement(By.id("customer.password")).sendKeys("Test");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Test");
        WebElement Register_button = driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td/input"));
        Assert.assertTrue(Register_button.isDisplayed(), "Register button should be displayed");

        Register_button.click();
        // check if warning message is displayed after clicking continue email
        WebElement warningMessage = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p"));
    return driver;
    }

}
