package LetCode;

import LetCodePage.LetCodePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import LetCodePage.LetCodeActions;
import static io.ous.jtoml.impl.Token.TokenType.Key;

public class Letcode {
    public static void main(String[] args) {
        LetCodePage letCodePage = new LetCodePage();
        LetCodeActions letCodeActions = new LetCodeActions();
        WebDriver driver = letCodePage.returnDriver();
        driver.manage().window().maximize();

       letCodeActions.actionSendKeys(letCodePage.getFullName(), "ortonikc");
       letCodeActions.actionSendKeys(letCodePage.getJoin(), Keys.TAB);
        letCodeActions.actionSendKeys(letCodePage.getJoin(), "TEST");
        Assert.assertTrue(letCodeActions.getAttribute(letCodePage.getGetMe(), "value").contains("TEST"), "The value should be Test");
       letCodeActions.actionClick(letCodePage.getGetMe());

        Assert.assertTrue(letCodePage.getNoEdit().getAttribute("value").isEmpty(), "The value should be empty");
        boolean enabled = letCodePage.getNoEdit().isEnabled();
        String readonly = letCodePage.getNoEdit().getAttribute("readonly");
        System.out.println(readonly);
        System.out.println(enabled);
        Assert.assertTrue(enabled, "The button should not be enabled");
    }
}
