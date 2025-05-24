package LetCodePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LetCodePage {
    private static WebElement webElement;
    private static WebDriver driver;

   public LetCodePage(WebDriver driver1){
         webElement=null;
            driver=driver1;
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
    public  WebElement getWorkSpace() {
        webElement=driver.findElement(By.id("testing"));
        return webElement;
    }
}
