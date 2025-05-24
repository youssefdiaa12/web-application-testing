package LetCode;

import LetCodePage.LetCodePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import LetCodeActions.LetCodeActions;
import org.testng.annotations.Test;

public class Letcode extends Driver {
    @Test
    public void testLetCodeEditPage() throws InterruptedException {
        LetCodePage letCodePage = new LetCodePage(driver1);
        LetCodeActions letCodeActions = new LetCodeActions();
        WebDriver driver = driver1;
        driver.get("https://letcode.in/edit");
        driver.manage().window().maximize();
        letCodeActions.actionSendKeys(letCodePage.getFullName(), "ortonikc");
        Thread.sleep(1000);
        letCodeActions.actionSendKeys(letCodePage.getJoin(), Keys.TAB);
        letCodeActions.actionSendKeys(letCodePage.getJoin(), "TEST");
        Assert.assertTrue(letCodeActions.getAttribute(letCodePage.getJoin(), "value").contains("TEST"), "The value should be Test");
        letCodeActions.actionClick(letCodePage.getGetMe());

        Assert.assertTrue(letCodePage.getNoEdit().getAttribute("value").isEmpty(), "The value should be empty");
        boolean enabled = letCodePage.getNoEdit().isEnabled();
        System.out.println(enabled);
        Assert.assertFalse(enabled, "The button should not be enabled");
        letCodeActions.actionClick(letCodePage.getWorkSpace());
    }
}
