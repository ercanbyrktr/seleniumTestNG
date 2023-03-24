package tests.day17;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C05_AmazonPageClass {

    @Test(groups = "gp1")
    public void test01() {
        AmazonPage amazonPage=new AmazonPage();
        Driver.getDriver().get("https://amazon.com");
        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        String expectedKelime="Nutella";
        String actualKelime=amazonPage.aramaSonucWE.getText();
        Assert.assertTrue(actualKelime.contains(expectedKelime));
        Driver.closeDriver();
    }
}
