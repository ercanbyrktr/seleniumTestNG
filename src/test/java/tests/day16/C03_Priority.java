package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_Priority extends TestBaseBeforeMethodAfterMethod {
    /*
    Testlerimizi çalıştırırken istedigimiz sıraya göre çalışmasını istersek
    priority methodunu kullanırız
    Priority kullanmazsak default olarak 0 dır
     */
    @Test (priority = 1,groups = "gp1")
    public void youtubeTest() {
        driver.get("https://www.youtube.com");
    }

    @Test // Burayı 0 kabul eder bu yüzden ilk bu method çalışır
    public void bestBuyTest() {
        driver.get("https://www.bestbuy.com");
    }

    @Test (priority = 2,groups = "gp1")
    public void amazonTest() {
        driver.get("https://www.amazon.com");
    }
}
