package UserStory4;

import UserStory3.TCR001;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC_USAT_003 {


    @Test
    public void User_selects_account_type() throws InterruptedException {
        TCR001 tcr001 = new TCR001();
        WebDriver driver = tcr001.driver;

        WebElement open_new_account = driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a"));
        Assert.assertTrue(open_new_account.isDisplayed(), "Open new account should be displayed");
        open_new_account.click();
        Thread.sleep(1000);
        WebElement account_type = driver.findElement(By.id("type"));
        Assert.assertTrue(account_type.isDisplayed(), "Account type should be displayed");
        List<WebElement> options = new Select(driver.findElement(By.id("type"))).getOptions();
        String first_option = options.get(0).getText();
        //check that the first option is "CHECKING" , If not we should you assert false
        Assert.assertEquals(first_option, "CHECKING", "The first option should be CHECKING");
        String second_option = options.get(1).getText();
        //check that the second option is "SAVINGS" , If not we should you assert false
        Assert.assertEquals(second_option, "SAVINGS", "The second option should be SAVINGS");
        WebElement open_new_account_button = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/form/div/input"));
        Assert.assertTrue(open_new_account_button.isDisplayed(), "Open new account button should be displayed");
        open_new_account_button.click();
        Thread.sleep(2000);
        WebElement account_opened_message = driver.findElement(By.xpath("//*[@id=\"openAccountResult\"]/h1"));
        Assert.assertTrue(account_opened_message.isDisplayed(), "Account opened message should be displayed");
        String account_opened_message_text = account_opened_message.getText();
        Assert.assertTrue(account_opened_message_text.contains("Account Opened!"), "Account opened message should be displayed");
        // since by default the account has 515$ so we need to create a new account six times since in each time it takes 100$  so that we expect in the 6th time to have 515-600= -85$ so we need to check if the error message is displayed
    }

}
