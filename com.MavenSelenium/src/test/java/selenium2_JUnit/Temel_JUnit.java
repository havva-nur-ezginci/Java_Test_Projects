package selenium2_JUnit;
//1. study
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class Temel_JUnit {
    static WebDriver driver;
    @BeforeClass // class için ilk ve bir kez çalışır
    public static void ilkIslem(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // sayfanın yuklenmesi ve webelement bulunması için süre verir.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Before //her test den önce çalışır
    public void ilkTekrar(){
        System.out.println("test öncesi çalıştı");
    }
    @Test
    public void test1(){
        driver.get("https://www.dr.com.tr");
    }
    @Test
    public void test2(){
        // if-else yerine assert fonksiyonları kullanılabilir.
        Assert.assertTrue("D&R - Kültür, Sanat ve Eğlence Dünyası".equals(driver.getTitle()));
    }
    @Test
    public void test3(){
        // if-else yerine assert fonksiyonları kullanılabilir.
        Assert.assertEquals("https://www.dr.com.tr/",driver.getCurrentUrl());
    }
    @After //her test den sonra çalışır
    public void sonTekrar(){
        System.out.println("test sonrası çalıştı");
    }
    @AfterClass // class için son ve bir kez çalışır
    public static void sonIslem(){
        driver.quit();
    }

}
