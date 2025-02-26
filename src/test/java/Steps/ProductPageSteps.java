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

    public void writeReview(String name, String email, String review) {
        productPage.getWriteReviewButton().click();
        productPage.getNameField().sendKeys(name);
        productPage.getEmailField().sendKeys(email);
        productPage.getReviewField().sendKeys(review);
        productPage.getSubmitButton().click();
    }

    public void assertSuccessMessageVisible() {
        WebElement successMessageElement = productPage.getSuccessMessageElement();
        String actualSuccessText = successMessageElement.getText();
        Assert.assertEquals(EXPECTED_SUCCESSFUL_PRODUCT_REVIEW_MESSAGE, actualSuccessText);
    }
}