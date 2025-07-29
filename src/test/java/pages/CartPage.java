package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    // Locators
    private By cartBtn = By.xpath("//a[@href='/view_cart']");
    private By productInCart = By.xpath("//td[@class='cart_description']//a[contains(text(),'Blue Top')]");

    private By proceedToCheckoutBtn = By.xpath("//a[text()='Proceed To Checkout']");
    private By placeOrderBtn = By.xpath("//a[text()='Place Order']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // 👉 Navigate to cart page
    public void goToCart() {
        driver.findElement(cartBtn).click();
    }

    // 👉 Check if product is visible in cart
    public boolean isProductInCart() {
        return driver.findElements(productInCart).size() > 0;
    }

    // 👉 Proceed to checkout
    public void clickProceedToCheckout() {
        driver.findElement(proceedToCheckoutBtn).click();
    }

    // 👉 Click place order
    public void clickPlaceOrder() {
        driver.findElement(placeOrderBtn).click();
    }
}
