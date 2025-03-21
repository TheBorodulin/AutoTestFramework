package Tests;

import org.junit.Test;

public class ProductReviewTests extends BaseTests {
    @Test
    public void testAddingReviewOnProduct() {
        final String productNumber = "1";
        final String name = "Test";
        final String email = "test@example.com";
        final String reviewText = "Great product, highly recommend!";

        homepageSteps.openHomepage();
        homepageSteps.clickOnProductViewButton(productNumber);

        productPageSteps.writeReview(name, email, reviewText);
        productPageSteps.assertReviewSuccessNotification();
    }
}