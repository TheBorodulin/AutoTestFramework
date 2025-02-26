package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage extends BasePage {

    private final By modalTitle = By.xpath("//h4[@class='modal-title w-100']");
    private final By productIcon = By.xpath("//div[@class='features_items']//div[@class='product-image-wrapper']");

    public Homepage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddProductToCartButton(String productNumber) {
        String addProductToCartButton = "//div[@class='product-image-wrapper']//a[contains(text(),'Add to cart')][%s]";
        return getClickableElement(By.xpath(String.format(addProductToCartButton, productNumber)));
    }

    public WebElement getModalTitle() {
        return getVisibleElement(modalTitle);
    }

    public int getProductsCount() {
        return getVisibleElements(productIcon).size();
    }

    public WebElement getProductViewButton(String productNumber) {
        String productViewButton;
        productViewButton = "(//a[contains(text(),'View Product')])[1]";
        return getClickableElement(By.xpath(String.format(productViewButton, productNumber)));
    }
}