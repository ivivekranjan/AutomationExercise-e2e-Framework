package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignupLogin();
        loginPage.login("vivekranjan622@gmail.com", "Vivek@123");
        Assert.assertTrue(loginPage.isLoggedIn(), "User should be logged in successfully.");
    }
}
