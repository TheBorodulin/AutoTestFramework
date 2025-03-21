package Tests;

import org.junit.Test;

public class CartTests extends BaseTests {

    @Test
    public void testAddingProductToCart() {
        final String productNumber = "1";

        homepageSteps.openHomepage();
        homepageSteps.addProductToCart(productNumber);
        homepageSteps.assertModalTitle();
    }
}