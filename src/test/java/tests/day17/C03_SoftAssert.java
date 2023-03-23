package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeClassAfterClass;

public class C03_SoftAssert extends TestBaseBeforeClassAfterClass {
    @Test
    public void test01() {
        /*
        SoftAssert baslangıc ve bitiş satırları arasındaki tum assertion'ları yapıp
        bitis olarak belirtmemiz gereken assertAll() metoduyla test metodumuzdaki butun assertion'ları
        kontrol eder. Failed olan olursa assertion yaptıgımız metodun sonuna yazdıgımız mesajı bize konsolda verir
         */
        SoftAssert softAssert=new SoftAssert();
        //amazon anasayfasına gidin
        driver.get("https://www.amazon.com");
        //title in amazon içerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("Amazon"),"Girdiginiz kelimeyi icermiyor");
        //arama kutusunun erişilebilir oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"WE erişilemedi");
        // arama kuutusuna nutella yazıp aratın
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        //arama yapıldıgını test edin
        WebElement sonuc=driver.findElement((By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")));
        softAssert.assertTrue(sonuc.isDisplayed(),"SonucWE goruntulenemedi");
        //arama sonucunun nutella içerdigini test edin
        softAssert.assertTrue(sonuc.getText().contains("Nutella"),"Nutella icermiyor");
        softAssert.assertAll();
    }
}
