package LetCode;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Driver {
    protected static WebDriver driver1;

    @BeforeClass
    public void setUp() {
        // Initialize only once
        if (driver1 == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver1 = new ChromeDriver(options);
        }
    }
    public WebDriver returnDriver() {
        return driver1;
    }

//    @AfterClass
//    public void tearDown() {
//        if (driver1 != null) {
//            driver1.quit();
//        }
//    }
}


