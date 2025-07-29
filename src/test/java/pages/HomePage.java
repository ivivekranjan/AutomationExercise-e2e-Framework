package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By loginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By homeLogo = By.xpath("//img[@alt='Website for automation practice']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageVisible() {
        return driver.findElement(homeLogo).isDisplayed();
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}
