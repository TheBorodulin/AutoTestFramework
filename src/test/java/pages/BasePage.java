package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    protected WebElement getClickableElement(By element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement getVisibleElement(By element) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public List<WebElement> getVisibleElements(By elements) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elements));
    }
}