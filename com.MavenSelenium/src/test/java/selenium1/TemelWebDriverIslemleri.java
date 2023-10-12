package selenium1;
// 1. study
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TemelWebDriverIslemleri {
    public static void main(String[] args) {

        /*Selenium Manager, Rust kullanılarak oluşturulan ve Google Chrome, Mozilla Firefox ve Microsoft Edge
        için driver management sağlayan bir araçtır. Selenium Manager, otomatik driver yönetimi için
        kullanılır. Browser Selenium WebDriver kullanarak çalıştırmak için aşağıdaki kod ifadesi
        yürütüldüğünde, Selenium Manager çağrılır ve makinenizde yüklü olan ilgili tarayıcının
        tarayıcı sürümünü kontrol eder. Tarayıcı sürücüsünü indirdikten sonra yerel klasörde
        önbelleğe alır (C:\Users\havvanur\.cache\selenium\chromedriver). Bu, aynı browser/sürücü sürümü
        için ileride otomatik testlerin sorunsuz bir şekilde yürütülmesini sağlar.
        Böylece  webdriver ı kullanmak için indirmeye veya projeye dependency lerine eklemeye gerek yoktur.
        https://www.lambdatest.com/blog/selenium-manager-in-selenium-4-11-0/
         */

        WebDriver driver = new ChromeDriver();// selenium dan webdriver ı getirdik.

        //--------- Driver Methodları ---------

        driver.get("https://www.turktelekom.com.tr");

        String title = driver.getTitle(); //sayfanın başlığını döndürür.
        System.out.println("title: "+title); //title: Türk Telekom – Değerli Hissettirir

        String url = driver.getCurrentUrl();
        System.out.println("Url: "+url); // Url: https://www.turktelekom.com.tr/

        String source_code = driver.getPageSource();//içinde bulunduğu sayfanın kaynak kodlarını döndürür.
        System.out.println("source_code: "+source_code); // source_code: <html dir="ltr" lang="tr-TR"....

        String unique_hash = driver.getWindowHandle(); //bulunulan sayfanın UNIQUE hash kodunu döndürür. herseferinde farklı değer alırız.
        System.out.println("unique_hash code: "+unique_hash); //unique_hash code: A5BD331AD5EC2877B73727C9F2BBDC00

        // driver.getWindowHandles(); //bulunulan sayfaların UNIQUE hash kodlarını döndürür.

        //------------------- Driver Navigate methodları -------------------

        // tekrar geri donmek istiyorsak get yerine navigate().to kullanmalıyız.
        driver.navigate().to("https://www.sokmarket.com.tr");

        driver.navigate().back(); // bir önceki sayfaya doner

        driver.navigate().forward();//navigate ile geri döndüğümüz sayfadan tekrar bir sonraki sayfaya geçmek için kullanılır.

        driver.navigate().refresh(); // sayfayı yeniler.

        //---------------- Manage Methodları ---------------------

        // sayfanın büyüklüğünü piksel ölçülerini döndürür.
        Dimension wsize = driver.manage().window().getSize();
        System.out.println(wsize); // (1050, 708)

        Point point = driver.manage().window().getPosition();
        System.out.println(point); // (10, 10) sol alt köşeye göre

        driver.manage().window().setPosition(new Point(45,25));// pencerenin sol alt köşesinin konumunu değişitirebiliriz.

        // fullscreen - maximize
        driver.manage().window().maximize();

        System.out.println(driver.manage().window().getPosition()); //(-8, -8)
        System.out.println(driver.manage().window().getSize()); // (1382, 744)

        driver.manage().window().fullscreen();

        System.out.println(driver.manage().window().getPosition()); // (0, 0)
        System.out.println(driver.manage().window().getSize()); //(1366, 768)

        driver.manage().window().setSize(new Dimension(800,500));


        driver.manage().window().minimize();

//selenium un çalışmasını belirli bir süre bekletiyoruz.
// sayfanın yuklenmesi ve webelement bulunması için süre verir.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // driver.close(); // bulunulan browser ı kapatır.

       // driver.quit(); // tüm sekmekeler kapatılır.



    }
}
