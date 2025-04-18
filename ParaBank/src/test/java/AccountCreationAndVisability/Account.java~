package AccountCreationAndVisability;

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
import java.util.Set;

public class Account {


    @Test
    public void register() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a/span[1]")));

        WebElement login = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a/span[1]"));
        Assert.assertTrue(login.isDisplayed(), "Login element should be displayed");
        login.click();

        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();

        driver.findElement(By.id("input-firstname")).sendKeys("Test");
        driver.findElement(By.id("input-lastname")).sendKeys("Test");
        driver.findElement(By.id("input-email")).sendKeys("jH4l15@example.com");
        driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
        driver.findElement(By.id("input-password")).sendKeys("123456");
        driver.findElement(By.id("input-confirm")).sendKeys("123456");

        WebElement privacyPolicy = driver.findElement(By.xpath("//input[@name='agree']"));
        privacyPolicy.click();

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();
// check if warning message is displayed after clicking continue email
        WebElement warningMessage = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]"));
        Assert.assertTrue(warningMessage.isDisplayed(), "Warning message should be displayed");
        Assert.assertEquals(warningMessage.getText(), "Warning: E-Mail Address is already registered!");
// if email is already registered end the test
        if (warningMessage.isDisplayed()) {
            System.out.println("Email is already registered. Test ended.");
            driver.quit();
            return;
        }
        WebElement successMessage = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
        Assert.assertEquals(successMessage.getText(), "Your Account Has Been Created!");

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://tutorialsninja.com/demo/index.php?route=account/success");

        WebElement header = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
        login = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]"));
        login.click();

        WebElement logout = driver.findElement(By.linkText("Logout"));
        WebElement congrats = driver.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String congratsStr = congrats.getText();

        Assert.assertTrue(logout.isDisplayed(), "Logout link should be displayed");
        Assert.assertTrue(header.isDisplayed(), "Header should be displayed");
        Assert.assertEquals(congratsStr, "Congratulations! Your new account has been successfully created!");

        WebElement p1 = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]"));
        WebElement p2 = driver.findElement(By.xpath("//*[@id=\"content\"]/p[3]"));
        WebElement p3 = driver.findElement(By.xpath("//*[@id=\"content\"]/p[4]"));

        Assert.assertTrue(p1.isDisplayed(), "Paragraph 1 should be displayed");
        Assert.assertTrue(p2.isDisplayed(), "Paragraph 2 should be displayed");
        Assert.assertTrue(p3.isDisplayed(), "Paragraph 3 should be displayed");

        WebElement link_contact_us = driver.findElement(By.linkText("Contact Us"));
        Assert.assertTrue(link_contact_us.isDisplayed(), "Contact Us link should be displayed");
        link_contact_us.click();

        WebElement continue_ = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a"));
        Assert.assertTrue(continue_.isDisplayed(), "Continue link should be displayed");
        continue_.click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }

        driver.close();
        driver.quit();
        System.out.println("Test Passed");
    }

}
