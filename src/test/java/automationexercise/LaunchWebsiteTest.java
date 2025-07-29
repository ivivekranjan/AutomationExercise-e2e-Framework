package automationexercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchWebsiteTest {

    @Test
    public void openHomePage() {
        // Step 1: Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Step 2: Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Step 3: Maximize browser window
        driver.manage().window().maximize();

        // Step 4: Navigate to the website
        driver.get("https://automationexercise.com/");

        // Step 5: Validate page title
        String actualTitle = driver.getTitle();
        System.out.println("Page Title: " + actualTitle);
        Assert.assertTrue(actualTitle.contains("Automation Exercise"), "Title not matched");

        // Step 6: Close the browser
        driver.quit();
    }
}
