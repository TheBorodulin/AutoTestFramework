package cucumberdefinitions;

import static driver.DriverFactory.getDriver;
import io.cucumber.java.en.*;
import steps.HomepageSteps;

public class HomepageStepDefinitions {
    private final HomepageSteps homepageSteps;

    public HomepageStepDefinitions() {
        homepageSteps = new HomepageSteps(getDriver());
    }

    @Given("User opens Homepage")
    public void openHomepage() {
        homepageSteps.openHomepage();
    }

    @When("User add product with number {string} to cart")
    public void addProductToCart(String productNumber) {
        homepageSteps.addProductToCart(productNumber);
    }

    @Then("User sees successful message on confirmation popup")
    public void assertModalTitle() {
        homepageSteps.assertModalTitle();
    }

    @Then("User sees {int} products listed on Homepage")
    public void assertProductCount(int expectedCount) {
        homepageSteps.assertProductCount(expectedCount);
    }
}