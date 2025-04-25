package cucumberdefinitions;

import static driver.DriverFactory.getDriver;
import io.cucumber.java.en.*;
import steps.ProductPageSteps;

public class ProductPageStepDefinitions {
    private final ProductPageSteps productPageSteps;

    public ProductPageStepDefinitions() {
        productPageSteps = new ProductPageSteps(getDriver());
    }

    @Given("User opens Product Page for product {string}")
    public void openProductPage(String productNumber) {
        productPageSteps.openProductPageByNumber(productNumber);
    }

    @When("User writes a review with name {string}, email {string}, and text {string}")
    public void writeReview(String name, String email, String reviewText) {
        productPageSteps.writeReview(name, email, reviewText);
    }

    @Then("User sees the message {string}")
    public void assertReviewSuccessNotification(String expectedMessage) {
        productPageSteps.assertReviewSuccessNotification();
    }
}