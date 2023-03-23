package tests.day20;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_SmokeNegatifTest {
    @Test
    public void yanlisKullanıcı() {//1. senaryo: yanlis kullanıcı dogru sifre
        //https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hmcPage=new HmcPage();

        //login butonuna bas
        hmcPage.login.click();
        //test data username : manager
        //test data password : manage1!
        hmcPage.userName.sendKeys(ConfigReader.getProperty("hmcWrongUser"));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("pass"))
                .sendKeys(Keys.ENTER).perform();
        //Degerlerin girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hmcPage.girisYapilamadi.isDisplayed());
        //Sayfayı kapatın
        Driver.closeDriver();

    }

    @Test
    public void yanlisSifre() {//2. senaryo: dogru kullanıcı yanlis sifre
        //https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hmcPage=new HmcPage();

        //login butonuna bas
        hmcPage.login.click();
        //test data username : manager
        //test data password : manage1!
        hmcPage.userName.sendKeys(ConfigReader.getProperty("user"));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcWrongPass"))
                .sendKeys(Keys.ENTER).perform();
        //Degerlerin girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hmcPage.girisYapilamadi.isDisplayed());
        //Sayfayı kapatın
        Driver.closeDriver();
    }

    @Test
    public void yanlisKullaniciSifre() {//3. senaryo: yanlis kullanıcı yanlıs sifre
        //https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hmcPage=new HmcPage();

        //login butonuna bas
        hmcPage.login.click();
        //test data username : manager
        //test data password : manage1!
        hmcPage.userName.sendKeys(ConfigReader.getProperty("hmcWrongUser"));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcWrongPass"))
                .sendKeys(Keys.ENTER).perform();
        //Degerlerin girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hmcPage.girisYapilamadi.isDisplayed());
        //Sayfayı kapatın
        Driver.closeDriver();
    }
}
