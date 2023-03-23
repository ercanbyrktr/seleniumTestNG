package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class Driver {

    private Driver(){

    }

    static WebDriver driver;
    /*
    Testlerimizi calistirdigimizda herseferinde yeni driver olusturdugu icin her test methodu
    icin yeni bir pencere (driver) acıyor. Eger driver'a bir deger atanmamıssa yani driver==null ise
    bir kere driver'i calistir diyerek bir kere if icini calistiracak ve driver artık bir kere calistigi icin
    ve deger atandıgı icin null olmayacak ve direk return edecek ve diger testlerimiz aynı pencere (driver)
    uzerinde calısacak
     */

    public static WebDriver getDriver(){
        if(driver==null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    DesiredCapabilities cp = new DesiredCapabilities();
                    cp.setCapability(ChromeOptions.CAPABILITY, options);
                    options.merge(cp);
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    break;

                case "edge":

                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            DesiredCapabilities cp = new DesiredCapabilities();
            cp.setCapability(ChromeOptions.CAPABILITY, options);
            options.merge(cp);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null) { //driver'a deger atanmışsa
            driver.close();
            driver = null;//Kapandıktan sonra sonraki acmaları garanti altına almak icin driver'ı tekrar null yaptık
        }
    }
    public static void quitDriver(){
        if (driver!=null)
        driver.quit();
        driver=null;
    }
}
