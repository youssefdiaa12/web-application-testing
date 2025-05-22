package LetCodePage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LetCodePage {
    private static WebElement webElement;
    private static WebDriver driver;
   public LetCodePage(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
         driver = new ChromeDriver(options);
         webElement=null;
    }
    public WebDriver returnDriver() {
        return driver;
    }

    public  WebElement getFullName() {
         webElement=driver.findElement(By.id("fullName"));
        return webElement;
    }
    public  WebElement getJoin() {
        webElement=driver.findElement(By.id("join"));
        return webElement;
    }
    public  WebElement getGetMe() {
        webElement=driver.findElement(By.id("getMe"));
        return webElement;
    }
    public  WebElement getClearMe() {
        webElement=driver.findElement(By.id("clearMe"));
        return webElement;
    }
    public  WebElement getNoEdit() {
        webElement=driver.findElement(By.id("noEdit"));
        return webElement;
    }
}
