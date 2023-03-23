package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_BeforeClassAfterClass extends TestBaseBeforeClassAfterClass {
    @Test(groups = "gp2")
    public void testAmazon() {
        driver.get("https://amazon.com");
    }

    @Test(groups = "gp2")
    public void testBestBuy() {
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void testHepsiBurada() {
        driver.get("https://www.hepsiburada.com");
    }
}
