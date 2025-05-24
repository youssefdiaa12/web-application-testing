package LetCodePage;

import LetCode.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LetCodeHome extends Driver {
  public   WebElement returnPageObject() {
        return driver1.findElement(By.linkText("Page Object Model"));
    }
}