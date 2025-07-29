package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.CartPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void testAddToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignupLogin();
        loginPage.login("vivekranjan622@gmail.com", "Vivek@123");

        ProductPage productPage = new ProductPage(driver);
        productPage.openFirstProduct();
        productPage.addToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.goToCart();
        Assert.assertTrue(cartPage.isProductInCart(), "Product should be in the cart.");
    }
}
