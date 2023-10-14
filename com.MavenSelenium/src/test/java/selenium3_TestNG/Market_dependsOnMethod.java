package selenium3_TestNG;
//2. study
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Market_dependsOnMethod {
    WebDriver driver = new ChromeDriver();
    @Test
    public void test1(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 1- web sayfasına git ve popup ı kapat
        driver.get("https://www.trendyol.com");
        driver.findElement(By.cssSelector("div[class='modal-close']")).click();
    }
    // priority , dependsOnMethods dan daha önceliklidir. isimlendirme yaparket dikkat et. yoksa ilgili method çalışmaz.
    // dependesOnMethod sıralamaya etki etmez. sıra kendine geldiğinde bağlı olduğu method passed olup olmadığına bakar.
    // olmamışsa ignore olur.
    @Test(dependsOnMethods = "test1")
    public void test2(){
        // 2- arama kutusunu bul ve değer gir
        WebElement aramakutusu = driver.findElement(By.cssSelector("input[data-testid='suggestion']"));
        aramakutusu.sendKeys("Sağlıklı Atıştırmalıklar");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 3- ENTER a basarak veya arama simgesine tıklayarak sonucu arat
        driver.findElement(By.cssSelector("i[data-testid='search-icon']")).click();
    }
    @Test(dependsOnMethods = "test2")
    public void test3(){
        // 4- Kaç sonuç çıktığını yazdır.
        String sonuc_size = driver.findElement(By.cssSelector("div[class='dscrptn dscrptn-V2']")).getText();
        System.out.println(sonuc_size.replace("\"","").replace("\n",""));
    }
    @Test(dependsOnMethods = "test3")
    public void test4(){
       driver.quit();
    }
}
