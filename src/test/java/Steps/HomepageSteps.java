package Steps;

import Pages.BasePage;
import Pages.Homepage;
import Constants.URLs;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Constants.Messages.SUCCESSFUL_ADD_TO_CART_MODAL_MESSAGE;

public class HomepageSteps extends BaseSteps {
    Homepage homepage;

    private final By productIcon = By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']");

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
        int actualCount = getProductsCount();
        Assert.assertEquals(expectedCount, actualCount);
    }

    private int getProductsCount() {
        return homepage.getVisibleElements(productIcon).size();
    }
}