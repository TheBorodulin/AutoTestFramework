package steps;

import org.openqa.selenium.*;


public class BaseSteps {
    protected WebDriver driver;

    public BaseSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageByURL(String url) {
        driver.get(url);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

}