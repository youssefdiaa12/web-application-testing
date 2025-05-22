package LetCodePage;

import org.openqa.selenium.WebElement;

public class LetCodeActions {

    public void actionSendKeys(WebElement element, Object text) {
        element.sendKeys(text.toString());
    }


    public void actionClick(WebElement element) {
        element.click();
    }

    public void actionClear(WebElement element) {
        element.clear();
    }

    public String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }
}
