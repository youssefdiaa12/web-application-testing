package Register;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TCR001 {

    @Test
    public void registerAccountWithMendatoryFields() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://parabank.parasoft.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")));
        WebElement RegisterHyberLink = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a"));
        Assert.assertTrue(RegisterHyberLink.isDisplayed(), "Register hyperlink should be displayed");
        RegisterHyberLink.click();
        driver.findElement(By.id("customer.firstName")).sendKeys("Test");
        driver.findElement(By.id("customer.lastName")).sendKeys("Test");
        driver.findElement(By.id("customer.address.street")).sendKeys("Test");
        driver.findElement(By.id("customer.address.city")).sendKeys("Test");
        driver.findElement(By.id("customer.address.state")).sendKeys("Test");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("12345");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("1234567890");
        driver.findElement(By.id("customer.ssn")).sendKeys("123-45-6789");
        driver.findElement(By.id("customer.username")).sendKeys("Test1");
        driver.findElement(By.id("customer.password")).sendKeys("Test");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Test");
        WebElement Register_button = driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td/input"));


        Register_button.click();
        // check if warning message is displayed after clicking continue email
        WebElement warningMessage = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p"));
    }
}
