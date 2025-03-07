package Steps;

import Pages.ProductPage;
import Constants.URLs;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Constants.Messages.EXPECTED_SUCCESSFUL_PRODUCT_REVIEW_MESSAGE;

public class ProductPageSteps extends BaseSteps {
    private final ProductPage productPage;

    public ProductPageSteps(WebDriver driver) {
        super(driver);
        productPage = new ProductPage(driver);
    }

    public void openProductPageByNumber(String productNumber) {
        openPageByURL(URLs.PRODUCT_DETAILS_URL.concat(productNumber));
    }

    public void clickWriteReviewButton() {
        productPage.getWriteReviewButton().click();
    }

    public void fillNameField(String name) {
        productPage.getNameField().sendKeys(name);
    }

    public void fillEmailField(String email) {
        productPage.getEmailField().sendKeys(email);
    }

    public void fillReviewField(String review) {
        productPage.getReviewField().sendKeys(review);
    }

    public void clickSubmitButton() {
        productPage.getSubmitButton().click();
    }

    public void writeReview(String name, String email, String review) {
        clickWriteReviewButton();
        fillNameField(name);
        fillEmailField(email);
        fillReviewField(review);
        clickSubmitButton();
    }

    public void assertReviewSuccessNotification() {
        String actualSuccessText = productPage.getSuccessMessageElement().getText();
        Assert.assertEquals(EXPECTED_SUCCESSFUL_PRODUCT_REVIEW_MESSAGE, actualSuccessText);
    }
}