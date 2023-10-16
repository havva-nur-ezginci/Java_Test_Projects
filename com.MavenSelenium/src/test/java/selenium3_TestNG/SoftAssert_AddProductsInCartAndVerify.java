package selenium3_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

/* TestNg de JUnit de olduğu gibi Assertion kullanılabilir. Assertion kullanımı
testi tekrar tekrar kodun hataları düzeltilerek çalıştırmamızı gerektirebilir.
Bu sorunun JUnit de bir çözümü yoktur.

Bu sebeple TestNG framworkunde SoftAssertion oluşturulmuştur. SoftAssert class ı ile
assertion yaptığımızda FAILED durumu ile karşılaşılsa bile, assertAll() ile karşılaşıncaya
kadar çalışmaya devam eder.

 */
public class SoftAssert_AddProductsInCartAndVerify {
    WebDriver driver = new ChromeDriver();
    @Test
    public void testSoftAssert(){
        SoftAssert softAssert = new SoftAssert();

        //1. Launch browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2. Navigate to url 'https://www.amazon.com.tr/'
        driver.get("https://www.amazon.com.tr");
        driver.findElement(By.cssSelector("span[class='a-button a-button-primary']")).click();
        //3. Verify that home page is visible successfully
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com.tr/");
        //4. Find the search box and enter value and search for the product by clicking on the search icon
        WebElement aramakutusu = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        String searched_key ="çikolata";
        aramakutusu.sendKeys(searched_key);
        driver.findElement(By.cssSelector("span[id='nav-search-submit-text']")).click();

        //5. Verify that the searched value is successfully visible
        WebElement srch_element = driver.findElement(By.cssSelector("div[class='a-section a-spacing-small a-spacing-top-small']>span[class='a-color-state a-text-bold']"));
        softAssert.assertTrue(srch_element.isDisplayed());
        softAssert.assertEquals(srch_element.getText().replace("\"",""),searched_key);

        //6. Add the first product to cart
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(202,50)"); // scroll down the page

        driver.findElement(By.cssSelector("div[data-component-id='2']")).click();
        driver.findElement(By.cssSelector("input[id='add-to-cart-button']")).click();

        //7. Click on the 'Sepete Git' button
        driver.findElement(By.cssSelector("a[href='/cart?ref_=sw_gtc']")).click();

        //8. Verify that 'Alışveriş Sepeti' is visible
        softAssert.assertEquals(driver.findElement(By.cssSelector("div[class='a-row sc-cart-header']>div[class='a-row']")).getText(),"Alışveriş Sepeti");
        softAssert.assertAll();
        //9. Driver quit
        driver.quit();
    }

}
