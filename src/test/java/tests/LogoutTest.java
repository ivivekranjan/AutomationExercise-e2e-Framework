package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignupLogin();
        loginPage.login("vivekranjan622@gmail.com", "Vivek@123");
        loginPage.logout();

        Assert.assertTrue(loginPage.isAtLoginPage(), "Logout failed. User is not redirected to login page.");
    }
}
