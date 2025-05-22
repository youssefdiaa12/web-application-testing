package UserStory3;

import WebDriverSetUp.WebDriverSetUp1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TCR001 {
    public static WebDriver driver;

    public TCR001() {
        WebDriverSetUp1 webDriverSetUp1 = new WebDriverSetUp1();
        driver = webDriverSetUp1.setupWebDriver();
        driver.get("https://parabank.parasoft.com/");
        driver.manage().window().maximize();
    }
    @Test(dataProvider = "registerData")
    public void registerAccountWithMendatoryFields(String firstName, String lastName, String street,
                                                        String city, String state, String zip, String phone,
                                                        String ssn, String password) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")));
        WebElement RegisterHyberLink = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a"));
        RegisterHyberLink.click();
        driver.findElement(By.id("customer.firstName")).sendKeys(firstName);
        driver.findElement(By.id("customer.lastName")).sendKeys(lastName);
        driver.findElement(By.id("customer.address.street")).sendKeys(street);
        driver.findElement(By.id("customer.address.city")).sendKeys(city);
        driver.findElement(By.id("customer.address.state")).sendKeys(state);
        driver.findElement(By.id("customer.address.zipCode")).sendKeys(zip);
        driver.findElement(By.id("customer.phoneNumber")).sendKeys(phone);
        driver.findElement(By.id("customer.ssn")).sendKeys(ssn);

        Date date = new Date();
        String username = firstName + date.getTime();  // Unique username
        driver.findElement(By.id("customer.username")).sendKeys(username);
        driver.findElement(By.id("customer.password")).sendKeys(password);
        driver.findElement(By.id("repeatedPassword")).sendKeys(password);

        WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td/input"));
        Assert.assertTrue(registerButton.isDisplayed(), "Register button should be displayed");

        registerButton.click();
        // Optional: Verify success or error message
        WebElement responsePanel = driver.findElement(By.id("rightPanel"));
        System.out.println("Response: " + responsePanel.getText());
    }

    @DataProvider(name = "registerData")
    public Object[][] registerData() {
        List<Object[]> dataList = new ArrayList<>();
        File file = new File("src/test/resources/registerData.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split CSV line by commas
                String[] values = line.split(",");
                if (values.length == 9) { // Ensure correct number of fields
                    dataList.add(values);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Object[][] dataArray = new Object[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            dataArray[i] = dataList.get(i);
        }

        return dataArray;
    }
}
