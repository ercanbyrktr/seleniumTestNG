package tests.day19;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_NegativeTest {
    @Test
    public void negativeTest() {
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
