package UserStory4;

import UserStory3.TCR001;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC_USAT_001 {


    @Test
    public void register() throws InterruptedException {
        TCR001 tcr001 = new TCR001();
        tcr001.registerAccountWithMendatoryFields();
       WebDriver driver = tcr001.driver;
       WebElement open_new_account=driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a"));
        Assert.assertTrue(open_new_account.isDisplayed(), "Open new account should be displayed");
        open_new_account.click();
        WebElement account_type=driver.findElement(By.id("type"));
        Assert.assertTrue(account_type.isDisplayed(), "Account type should be displayed");
        Select account_type_dropdown=new Select(driver.findElement(By.id("type")));
        List<WebElement> options=account_type_dropdown.getOptions();
        String first_option=options.get(0).getText();
        //check that the first option is "CHECKING" , If not we should you assert false
        Assert.assertEquals(first_option,"CHECKING","The first option should be CHECKING");
       String second_option=options.get(1).getText();
        //check that the second option is "SAVINGS" , If not we should you assert false
        Assert.assertEquals(second_option,"SAVINGS","The second option should be SAVINGS");
        Thread.sleep(3000);

    }

}
