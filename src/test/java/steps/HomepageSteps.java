package steps;

import pages.Homepage;
import constants.URLs;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static constants.Messages.SUCCESSFUL_ADD_TO_CART_MODAL_MESSAGE;

public class HomepageSteps extends BaseSteps {
    private final Homepage homepage;

    public HomepageSteps(WebDriver driver) {
        super(driver);
        homepage = new Homepage(driver);
    }

    public void openHomepage() {
        openPageByURL(URLs.HOMEPAGE_URL);
    }

    public void addProductToCart(String productNumber) {
        WebElement addButton = homepage.getAddProductToCartButton(productNumber);
        scrollToElement(addButton);
        addButton.click();
    }

    public void assertModalTitle() {
        Assert.assertEquals(SUCCESSFUL_ADD_TO_CART_MODAL_MESSAGE, homepage.getModalTitle().getText().trim());
    }

    public void clickOnProductViewButton(String productNumber) {
        WebElement viewButton = homepage.getProductViewButton(productNumber);
        scrollToElement(viewButton);
        viewButton.click();
    }

    public void assertProductCount(int expectedCount) {
        int actualCount = homepage.getProductsCount(); // Directly calling the method from Homepage
        Assert.assertEquals(expectedCount, actualCount);
    }
}