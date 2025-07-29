package automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	@Test
	public void testLogin() {
		
		WebDriverManager.chromedriver().setup();  // Manages driver binary
        WebDriver driver = new ChromeDriver();    // Launches browser
        driver.manage().window().maximize();      // Maximize the browser
        driver.get("https://automationexercise.com");  // Navigate to site
		
     // Click on 'Signup / Login' button
		driver.findElement(By.xpath("//a[contains(text(), ' Signup / Login')]")).click();
		
		//System.out.println("Successfully clicked  Signup / Login");
     // Enter email and password
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).
			sendKeys("connectmail.vivek@gmail.com");
		driver.findElement(By.xpath("//input[@data-qa='login-password']")).
		sendKeys("Vivek@123");
		// Click 'Login' button
		driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
		
		
		System.out.println("Successfully clicked  Login");
        
     // Verify login success
        WebElement loggedIn = driver.findElement(By.xpath("//a[contains(text(), ' Logged in as ')]"));
        Assert.assertTrue(loggedIn.isDisplayed());
        
        driver.quit();
		
	}

}
