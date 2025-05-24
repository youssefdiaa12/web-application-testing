package LetCode;

import LetCodeActions.LetCodeActions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LetCodeHome {

    @Test
    public void testLetCodePage()  {
     LetCodePage.LetCodeHome letCodePageMain = new LetCodePage.LetCodeHome();
     LetCodeActions letCodeActions = new LetCodeActions();
        WebElement webElement = letCodePageMain.returnPageObject();
        letCodeActions.actionClick(webElement);
    }

}
