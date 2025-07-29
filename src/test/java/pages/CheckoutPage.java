package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private By commentBox = By.name("message");
    private By placeOrderButton = By.xpath("//a[contains(text(),'Place Order')]");

    private By nameOnCard = By.name("name_on_card");
    private By cardNumber = By.name("card_number");
    private By cvc = By.name("cvc");
    private By expiryMonth = By.name("expiry_month");
    private By expiryYear = By.name("expiry_year");
    private By payAndConfirmButton = By.id("submit");

    private By confirmationMessage = By.xpath("//p[contains(text(),'Your order has been placed successfully!')]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void addComment(String comment) {
        driver.findElement(commentBox).sendKeys(comment);
    }

    public void placeOrder() {
        driver.findElement(placeOrderButton).click();
    }

    public void fillPaymentDetails(String name, String card, String cvcCode, String month, String year) {
        driver.findElement(nameOnCard).sendKeys(name);
        driver.findElement(cardNumber).sendKeys(card);
        driver.findElement(cvc).sendKeys(cvcCode);
        driver.findElement(expiryMonth).sendKeys(month);
        driver.findElement(expiryYear).sendKeys(year);
    }

    public void submitOrder() {
        driver.findElement(payAndConfirmButton).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }
}
