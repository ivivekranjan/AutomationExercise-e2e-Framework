
package automationexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.Keys;

public class CheckoutFlowTest {

    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void completeCheckoutFlow() {
        setup();

        try {
            login("vivekranjan622@gmail.com", "Vivek@123");
            navigateToProductAndAddToCart();
            proceedToCheckout();
            fillPaymentAndPlaceOrder();
            verifyOrderSuccess();

        } catch (Exception e) {
            System.out.println("❌ Test failed due to: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    // -------------------- HELPER METHODS --------------------

    private void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
    }

    private void login(String email, String password) {
        click(By.xpath("//a[contains(text(),'Signup / Login')]"));
        sendKeys(By.name("email"), email);
        sendKeys(By.name("password"), password);
        click(By.xpath("//button[@data-qa='login-button']"));
    }

    private void navigateToProductAndAddToCart() {
        click(By.xpath("(//a[text()='View Product'])[1]"));
        click(By.xpath("//button[@class='btn btn-default cart']"));
        click(By.xpath("//u[text()='View Cart']"));
    }

    private void proceedToCheckout() {
        click(By.xpath("//a[text()='Proceed To Checkout']"));
        click(By.xpath("//a[text()='Place Order']"));
    }

    private void fillPaymentAndPlaceOrder() {
        sendKeys(By.cssSelector(".form-control"), "Vivek Ranjan");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys("112233445566")  // Card number
               .sendKeys(Keys.TAB).sendKeys("112")           // CVC
               .sendKeys(Keys.TAB).sendKeys("11")            // Exp month
               .sendKeys(Keys.TAB).sendKeys("2022")          // Exp year
               .build().perform();

        click(By.id("submit"));
    }

    private void verifyOrderSuccess() {
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(text(), 'Congratulations! Your order has been confirmed!')]")));
        Assert.assertTrue(successMsg.isDisplayed(), "✅ Order confirmation not found.");
        System.out.println("✅ Order placed successfully!");
    }

    // -------------------- REUSABLE UTILITY METHODS --------------------

    private void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void sendKeys(By locator, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(value);
    }

}



/*



package automationexercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckoutFlowTest {

    @Test
    public void completeCheckoutFlow() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com");
        

        // ✅ Login
        driver.findElement(By.xpath("//a[contains(text(),'Signup / Login')]")).click();
        driver.findElement(By.name("email")).sendKeys("vivekranjan622@gmail.com"); // Use existing login
        driver.findElement(By.name("password")).sendKeys("Vivek@123");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        Thread.sleep(2000);

     // Navigate to product detail
        driver.findElement(By.xpath("(//a[text()='View Product'])[1]")).click();
        Thread.sleep(2000);

        // Safe click for Add to Cart
        WebElement addBtn = driver.findElement(By.xpath("//button[@class='btn btn-default cart']"));
       // if (addBtn.isDisplayed()) {
            addBtn.click();
        //} else {
           // System.out.println("❌ Add to Cart button not visible");

        
        // Go to view cart
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//u[text()='View Cart']")));
        viewCart.click();
            
        Thread.sleep(3000);
        
        // Procced to checkout
        driver.findElement(By.xpath("//a[text()= 'Proceed To Checkout']")).click();
            
        Thread.sleep(2000);   
        driver.findElement(By.xpath("//a[text()= 'Place Order']")).click();    
        
        //Payment page
        Thread.sleep(3000); 
        driver.findElement(By.cssSelector(".form-control")).sendKeys("Vivek Ranjan");
        
        Actions action = new Actions(driver);
        
        action.sendKeys(Keys.TAB);
        action.sendKeys("112233445566");
        action.sendKeys(Keys.TAB);
        action.sendKeys("112");
        action.sendKeys(Keys.TAB);
        action.sendKeys("11");
        action.sendKeys(Keys.TAB);
        action.sendKeys("2022");
        action.sendKeys(Keys.TAB);
        action.build().perform();
        
        driver.findElement(By.id("submit")).click();
        
        Thread.sleep(2000);
        WebElement confirmText = driver.findElement(By.xpath("//p[contains(text(), 'Congratulations! Your order has been confirmed!')]"));
        
        Assert.assertTrue(confirmText.getText().contains("Congratulations"));
        
        System.out.println("Order Placed successfuly ");
        
        
        
            
            
        
        driver.quit();
    }
   
    
   }
    
*/
