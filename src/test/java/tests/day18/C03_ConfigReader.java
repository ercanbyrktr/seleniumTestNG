package tests.day18;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_ConfigReader {



    @Test
    public void test01() {
        //https://www.hotelmycamp.com/ adresine git login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hmcPage=new HmcPage();
        /*
        Page class'ındaki locate'lerimize ulaşabilmek icin
        Page classımızdan bir obje olusturarak, olusturmus oldugumuz obje ile
        page class ımızdaki locatelerimize ulasabiliriz
         */
        hmcPage.login.click();
        //test data username : manager
        //test data password : Manage1!
        hmcPage.userName.sendKeys(ConfigReader.getProperty("User"));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password"))
                .sendKeys(Keys.ENTER).perform();
        //Degerleri girildiginde sayfaya basarılı sekilde girilebildigini test et
        Assert.assertTrue(hmcPage.girisYapildi.isDisplayed());
        Driver.closeDriver();

    }
}
