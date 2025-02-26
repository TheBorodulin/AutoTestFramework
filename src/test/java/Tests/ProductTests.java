package Tests;

import org.junit.Test;

public class ProductTests extends BaseTests {

    @Test
    public void testProductCount() {
        final int expectedProductCount = 34;

        homepageSteps.openHomepage();
        homepageSteps.verifyProductCount(expectedProductCount);
    }
}