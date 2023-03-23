package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C02_HardAssert extends TestBaseBeforeMethodAfterMethod {
    @Test
    public void test01() {
        //amazon anasayfasına gidin
        driver.get("https://www.amazon.com");
        //title in amazon içerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        //arama kutusunun erişilebilir oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());
        // arama kuutusuna nutella yazıp aratın
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        //arama yapıldıgını test edin
        WebElement sonuc=driver.findElement((By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")));
        Assert.assertTrue(sonuc.isDisplayed());
        //arama sonucunun nutella içerdigini test edin
        Assert.assertTrue(sonuc.getText().contains("Nutella"));
    }
}
