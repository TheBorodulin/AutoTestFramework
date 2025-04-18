package cucumberhooks;

import static driver.DriverFactory.getDriver;
import static driver.DriverFactory.quitDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
    @Before
    public void setUp() {
        getDriver();
    }

    @After
    public void tearDown() {
        quitDriver();
    }
}