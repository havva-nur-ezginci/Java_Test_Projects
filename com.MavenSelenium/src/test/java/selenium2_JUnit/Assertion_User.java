package selenium2_JUnit;
//2. study ; pom.xml e junit dependency eklemeyi unutma.
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
//https://automationexercise.com/test_cases
public class Assertion_User {
    @Test
    public void test1(){
        //1. Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        Assert.assertEquals("https://automationexercise.com/",driver.getCurrentUrl());
        WebElement logo = driver.findElement(By.cssSelector("img[src='/static/images/home/logo.png\']"));
        Assert.assertTrue(logo.isDisplayed());//eğer logo görünür ise True döner.

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='signup-form']")).isDisplayed());

        //6. Enter name and already registered email address
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("nurezginci@gmail.com");
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys("deneme123456789");

        //7. Click 'login' button
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

        //8. Verify tahat 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),' Logged in as ')]")).isDisplayed());

        //9. Click 'Logout' button
        driver.findElement(By.cssSelector("a[href='/logout']")).click();

        //10. Verify tahat user is navigated to login page
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login");

        //11. Click on 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products']")).click();

        //12. Verify user is navigated to all products page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='All Products']")).getText().equals("ALL PRODUCTS"));

        //13. Enter product name in search input and click search button
        driver.findElement(By.cssSelector("input[id='search_product']")).sendKeys("dress");
        driver.findElement(By.cssSelector("button[id='submit_search']")).click();

        //14. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Searched Products']")).isDisplayed());

        //15. Close driver
        driver.quit();
    }
}
