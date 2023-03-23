package tests.day20;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_E2ETest {
    @Test
    public void E2ETest() throws InterruptedException {
        //https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hmcPage=new HmcPage();
        //login butonuna bas
        hmcPage.login.click();
        //test data username : manager
        //test data password : manage1!
        hmcPage.userName.sendKeys(ConfigReader.getProperty("user"));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password"))
                .sendKeys(Keys.ENTER).perform();
        //Hotel Management/Room reservation menusunden ADD ROOM RESERVATION butonuna tıklayın
        hmcPage.hotelManagement.click();
        Thread.sleep(2000);
        hmcPage.roomReservation.click();
        Thread.sleep(2000);
        hmcPage.addRoom.click();
        //Acılan sayfadaki tum metin kutularına istediginiz verileri girin
        //Save butonuna tıklayın
        Faker faker=new Faker();
        hmcPage.idUser.sendKeys("manager");
        actions.sendKeys(Keys.TAB).sendKeys("Happy Hotel").
                sendKeys(Keys.TAB).sendKeys("1500").sendKeys(Keys.TAB).sendKeys("10/02/2022")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("10/13/2022").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("2").sendKeys(Keys.TAB).sendKeys("2")
                .sendKeys(Keys.TAB).sendKeys(faker.name().fullName()).sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB).sendKeys("asdfghgf").sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //"RoomReservation was inserted succesfully" textinin gorundugunu test edin
        Thread.sleep(3000);
        Assert.assertTrue(hmcPage.roomReservationText.isDisplayed());
        //OK butonuna tıklayın
        hmcPage.okButton.click();



    }
}
