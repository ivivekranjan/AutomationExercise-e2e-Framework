package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private By firstProduct = By.xpath("(//a[@href='/product_details/1'])[1]");
    private By addToCartButton = By.xpath("//button[contains(text(),'Add to cart')]");
    private By continueShoppingButton = By.xpath("//button[contains(text(),'Continue Shopping')]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void openFirstProduct() {
        driver.findElement(firstProduct).click();
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
        wait.until(driver -> driver.findElement(continueShoppingButton).isDisplayed());
        driver.findElement(continueShoppingButton).click();
    }
}
