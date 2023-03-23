package tests.day21;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FaceBookPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PositiveLoginTestiRaporlu extends TestBaseRapor {

    @Test
    public void test01() throws InterruptedException {
        extentTest=extentReports.createTest("Positive Test","username ve sifre degerleri yazdırıp giris butonuna basmali");

        //https://www.facebook.com/ adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("faceUrl"));
        extentTest.info("facebook anasayfaya gidildi");
        //POM'a uygun olarak email, sifre kutularını ve giris yap
        //butonunu locate edin
        FaceBookPage facebookPage = new FaceBookPage();
        Faker faker = new Faker();
        //Faker class'ını kullanarak email ve sifre degerlerini
        //yazdirip, giris butonuna basın
        facebookPage.email.sendKeys(faker.internet().emailAddress());
        extentTest.info("faker emailaddres girildi");
        facebookPage.sifre.sendKeys(faker.internet().password());
        extentTest.info("faker password girildi");
        facebookPage.login.click();
        extentTest.info("login butonuna tiklandi");
        extentTest.pass("kullanici testi basariyla tamamladi");
        Driver.closeDriver();
    }


}
