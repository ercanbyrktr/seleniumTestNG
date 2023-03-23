package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBaseBeforeMethodAfterMethod {
    protected WebDriver driver;
    protected String tarih;
    //TestNG framework'unden @Before ve After notasyonları yerine @BeforeMethod ve @AfterMethod kullanılır
    //Calısma prensibi JUnit deki Before,After ile aynıdır
    @BeforeMethod(groups = "gp1")
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cp=new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(cp);
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter formater=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        tarih=date.format(formater);
    }
    @AfterMethod(groups = "gp1")
    public void tearDown(){
        //driver.quit();
    }
}
