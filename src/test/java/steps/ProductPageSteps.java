package steps;

import static constants.Messages.SUCCESSFUL_PRODUCT_REVIEW_MESSAGE;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import constants.URLs;
import pages.ProductPage;

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
        Assert.assertEquals(SUCCESSFUL_PRODUCT_REVIEW_MESSAGE, actualSuccessText);
    }
}