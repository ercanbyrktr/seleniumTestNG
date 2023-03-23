package tests.day17;

import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverIlkTest {
    @Test(groups = "gp2")
    public void test01() {
        /*
        TestBase class'ına extend ederek kullandıgımız driver yerine artık Driver class'ından kullanacagımız
        getDriver() static method'unu kullanırız
         */
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get("https://bestbuy.com");
        Driver.closeDriver();
        Driver.getDriver().get("https://hepsiburada.com");
        Driver.closeDriver();
    }
}
