package automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignupTest {

    @Test
    public void launchSignupPage() throws InterruptedException {
    	// Step 1: Setup and Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2: Open Home Page
        driver.get("https://automationexercise.com/");

        // Step 3: Click on 'Signup / Login' button
        WebElement signupLoginBtn = driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]"));
        signupLoginBtn.click();

        // Step 4: Enter name and email address
        WebElement nameField = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        WebElement emailField = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        nameField.sendKeys("Vivek Automation");
        
        // Making the email unique using timestamp
        //String uniqueEmail = "vivek" + System.currentTimeMillis() + "@testmail.com";
        emailField.sendKeys("vivekranjan622@gmail.com");

        // Step 5: Click 'Signup' button
        WebElement signupBtn = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signupBtn.click();

        // Step 6: Validate 'ENTER ACCOUNT INFORMATION' is visible
        WebElement accountInfoHeader = driver.findElement(By.xpath("//b[normalize-space()='Enter Account Information']"));
        Assert.assertTrue(accountInfoHeader.isDisplayed(), "Account info header not displayed");

     // Wait for page to load
        Thread.sleep(2000);

        // Select title
        driver.findElement(By.id("id_gender1")).click(); // Mr.

        // Password
        driver.findElement(By.id("password")).sendKeys("Vivek@123");

        // DOB
        driver.findElement(By.id("days")).sendKeys("14");
        driver.findElement(By.id("months")).sendKeys("June");
        driver.findElement(By.id("years")).sendKeys("1996");

        // Checkboxes
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        // Address info
        driver.findElement(By.id("first_name")).sendKeys("Vivek");
        driver.findElement(By.id("last_name")).sendKeys("Ranjan");
        driver.findElement(By.id("company")).sendKeys("MyCompany");
        driver.findElement(By.id("address1")).sendKeys("My Street 123");
        driver.findElement(By.id("address2")).sendKeys("Landmark");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("state")).sendKeys("Bihar");
        driver.findElement(By.id("city")).sendKeys("Motihari");
        driver.findElement(By.id("zipcode")).sendKeys("845401");
        driver.findElement(By.id("mobile_number")).sendKeys("9876543210");

        // Create account
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        Thread.sleep(3000);
        
     // ✅ Step 1: Verify "Account Created!"
        WebElement successMsg = driver.findElement(By.xpath("//h2[@data-qa='account-created']"));
        if (successMsg.isDisplayed()) {
            System.out.println("✅ Account Created Successfully");
        } else {
            System.out.println("❌ Account creation failed!");
        }

        // ✅ Step 2: Click "Continue"
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        Thread.sleep(2000); // Sometimes popup appears — can be handled later

        // ✅ Step 3: Verify "Logged in as <username>"
        WebElement loggedInText = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
        if (loggedInText.isDisplayed()) {
            System.out.println("✅ User is successfully logged in: " + loggedInText.getText());
        } else {
            System.out.println("❌ Login verification failed.");
        }
        
        
        driver.quit();
        
    }
}
