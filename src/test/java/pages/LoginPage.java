package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Locators
    private By signupLoginBtn = By.xpath("//a[@href='/login']");
    private By emailInput = By.xpath("//input[@data-qa='login-email']");
    private By passwordInput = By.xpath("//input[@data-qa='login-password']");
    private By loginBtn = By.xpath("//button[@data-qa='login-button']");
    private By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");  // Example: "Logged in as Vivek"

    private By logoutBtn = By.xpath("//a[@href='/logout']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 👉 Click "Signup / Login" link from homepage
    public void clickSignupLogin() {
        driver.findElement(signupLoginBtn).click();
    }

    // 👉 Login method
    public void login(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    // 👉 Logout method
    public void logout() {
        driver.findElement(logoutBtn).click();
    }

    // 👉 To verify login success
    public boolean isLoggedIn() {
        return driver.findElements(loggedInText).size() > 0;
    }

    // 👉 To verify logout success (you are redirected to login page again)
    public boolean isAtLoginPage() {
        return driver.getCurrentUrl().contains("/login");
    }
}
