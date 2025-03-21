package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    private final By writeReviewButton = By.xpath("//a[contains(text(), 'Write Your Review')]");
    private final By nameField = By.id("name");
    private final By emailField = By.id("email");
    private final By reviewField = By.id("review");
    private final By submitButton = By.xpath("//button[@type='submit']");
    private final By successMessage = By.cssSelector("div.alert-success.alert");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getWriteReviewButton() {
        return getClickableElement(writeReviewButton);
    }

    public WebElement getNameField() {
        return getVisibleElement(nameField);
    }

    public WebElement getEmailField() {
        return getVisibleElement(emailField);
    }

    public WebElement getReviewField() {
        return getVisibleElement(reviewField);
    }

    public WebElement getSubmitButton() {
        return getClickableElement(submitButton);
    }

    public WebElement getSuccessMessageElement() {
        return getVisibleElement(successMessage);
    }
}