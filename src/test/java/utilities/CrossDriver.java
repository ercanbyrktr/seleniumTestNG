package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class CrossDriver {
    private CrossDriver(){

    }

    static WebDriver driver;
    /*
    Testlerimizi calistirdigimizda herseferinde yeni driver olusturdugu icin her test methodu
    icin yeni bir pencere (driver) acıyor. Eger driver'a bir deger atanmamıssa yani driver==null ise
    bir kere driver'i calistir diyerek bir kere if icini calistiracak ve driver artık bir kere calistigi icin
    ve deger atandıgı icin null olmayacak ve direk return edecek ve diger testlerimiz aynı pencere (driver)
    uzerinde calısacak
     */

    public static WebDriver getDriver(String browser){
        browser=browser==null?ConfigReader.getProperty("browser"):browser;

        if(driver==null) {
            switch (browser) {
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


            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            DesiredCapabilities cp = new DesiredCapabilities();
            cp.setCapability(ChromeOptions.CAPABILITY, options);
            options.merge(cp);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
