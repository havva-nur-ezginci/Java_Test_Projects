package selenium1;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class MarketTestOtamasyon {
    static WebDriver driver = new ChromeDriver();

    public static void main(String[] args){

        driver.manage().window().maximize();
        // sayfanın yuklenmesi ve webelement bulunması için süre verir.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- web sayfasına git ve popup ı kapat
        driver.get("https://www.trendyol.com");
        driver.findElement(By.cssSelector("div[class='modal-close']")).click();

        // 2- arama kutusunu bul ve değer gir
        WebElement aramakutusu = driver.findElement(By.cssSelector("input[data-testid='suggestion']"));
        aramakutusu.sendKeys("çikolata");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 3- ENTER a basarak veya arama simgesine tıklayarak sonucu arat
        //aramakutusu.submit();
        driver.findElement(By.cssSelector("i[data-testid='search-icon']")).click();

        // 4- Kaç sonuç çıktığını yazdır.
        String sonuc_size = driver.findElement(By.cssSelector("div[class='dscrptn dscrptn-V2']")).getText();
        System.out.println(sonuc_size.replace("\"","").replace("\n",""));

        // 5- Giriş Yap simgesine tıkla
        driver.findElement(By.xpath("//p[text()='Giriş Yap']")).click();

        // 6- Girip yap sayfası açıldı mı kontrol et
        if(driver.getCurrentUrl().startsWith("https://www.trendyol.com/giris"))
            System.out.println("OK. Login sayfasına başarıyla girildi");
        else System.out.println("HATA. Login sayfasına girilemedi.");

        // 7- e-posta kutusuna rastgele bir mail girin
        driver.findElement(By.cssSelector("input[class='q-input'][name='login email']")).sendKeys("hatali@gmail.com");

        // 8- şifre kısmına rastgele bir şifre girin
        driver.findElement(By.cssSelector("input[class='q-input'][name='login-password']")).sendKeys("hatalişifre");

        // 9- Giriş yap butonuna tıklayın
        driver.findElement(By.cssSelector("button[class='q-primary q-fluid q-button-medium q-button submit']")).click();

        // 10- uyarı olarak "E-posta adresiniz ve/veya şifreniz hatalı." mesajının çıktığnı test edin.
        if(driver.findElement(By.cssSelector("div[id='error-box-wrapper']>span[class='message']")).getText().equals("E-posta adresiniz ve/veya şifreniz hatalı."))
            System.out.println("Hata mesajı doğrulandı");
        else System.out.println("WARNING! Hata mesajına ulaşılamadı");

        // 11- Ana sayfaya geri dön
        driver.navigate().back();
        driver.navigate().back();
        // 12- açılan popup ı kapat
        driver.findElement(By.cssSelector("div[class='modal-close']")).click();
        // 13- ana sayfada olunup olunmadığını kontrol et
        if(driver.getCurrentUrl().equals("https://www.trendyol.com/"))
            System.out.println("OK.Ana sayfaya başarıyla dönüldü.");
        else System.out.println("HATA. Ana Sayfaya dönülemededi url hatalı");

        // 14- Ana sayfadaki kategorileri al ve yazdır
        List<WebElement> navbar_anakategoriler = driver.findElements(By.cssSelector("ul[class='main-nav']>li>a"));
        System.out.println("Kategori sayısı: "+navbar_anakategoriler.size());
        for (WebElement kategori: navbar_anakategoriler) {
            System.out.println(kategori.getText());
        }

        // 15- sayfayı kapatın
        driver.quit();



    }
}
