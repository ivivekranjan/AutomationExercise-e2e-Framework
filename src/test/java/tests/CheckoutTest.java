package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCompleteCheckoutFlow() throws InterruptedException {
        // 1. Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignupLogin();
        loginPage.login("vivekranjan622@gmail.com", "Vivek@123");

        // 2. Add to cart
        ProductPage productPage = new ProductPage(driver);
        productPage.openFirstProduct();
        productPage.addToCart();

        // 3. View cart
        CartPage cartPage = new CartPage(driver);
        cartPage.goToCart();
        cartPage.clickProceedToCheckout();

        // 4. Checkout
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillPaymentDetails("Vivek Ranjan", "112233445566", "112", "11", "2022");
        checkoutPage.submitOrder();

        // 5. Verify confirmation
        String confirmation = checkoutPage.getConfirmationMessage();
        Assert.assertTrue(confirmation.contains("Your order has been placed successfully!"), "Order confirmation failed.");
    }
}
