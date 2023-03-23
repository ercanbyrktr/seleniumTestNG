package tests.day18;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FaceBookPage;
import utilities.Driver;

public class C01_PageClassFacebookTest {
    @Test
    public void test01() throws InterruptedException {
        //https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");
        //POM'a uygun olarak email, sifre kutularını ve giris yap
        //butonunu locate edin
        FaceBookPage facebookPage=new FaceBookPage();
        Faker faker=new Faker();
        //Faker class'ını kullanarak email ve sifre degerlerini
        //yazdirip, giris butonuna basın
        facebookPage.email.sendKeys(faker.internet().emailAddress());
        facebookPage.sifre.sendKeys(faker.internet().password());
        facebookPage.login.click();
        //basarılı giris yapılamadıgını test edin
        Thread.sleep(5000);
        Assert.assertTrue(facebookPage.girisYapilmadi.isDisplayed());
        Driver.closeDriver();
    }
}
