package selenium2_JUnit;
//3. study
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Actions_RegisterUser {
    @Test
    public void test(){

        //1. Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertEquals("https://automationexercise.com/",driver.getCurrentUrl());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='signup-form']")).isDisplayed());
        //6. Enter name and email address
        driver.findElement(By.cssSelector("input[data-qa='signup-name']")).sendKeys("deneme8");
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("deneme8hatali@gmail.com");
        //7. Click 'Signup' button
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-form']>h2")).getText(),"ENTER ACCOUNT INFORMATION");

        //9. Fill details: Title, Name, Email, Password,First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        Actions actions = new Actions(driver);
        WebElement title = driver.findElement(By.cssSelector("div[id='uniform-id_gender2']"));
        // action kullanarak doldurulacak tüm webelementleri locate etmemize gerek kalmadı
        actions.click(title)
                .sendKeys(Keys.TAB)
                .sendKeys("isim")
                .sendKeys(Keys.TAB)
                .sendKeys("Password")
                .perform();
        // address
        WebElement firtname = driver.findElement(By.cssSelector("input[data-qa='first_name']"));
        actions.click(firtname)
                .sendKeys("firstname")
                .sendKeys(Keys.TAB)
                .sendKeys("Last name")
                .sendKeys(Keys.TAB)
                .sendKeys("Company")
                .sendKeys(Keys.TAB)
                .sendKeys("Address ")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Florida")
                .sendKeys(Keys.TAB)
                .sendKeys("-")
                .sendKeys(Keys.TAB)
                .sendKeys("-")
                .sendKeys(Keys.TAB)
                .sendKeys("8999")
                .sendKeys(Keys.ENTER)//10. Click 'Create Account button'
                .perform();

        //11. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(driver.findElement(By.cssSelector("h2[data-qa='account-created']")).isDisplayed());
        //12. Click 'Continue' button
        WebElement continue_button = driver.findElement(By.cssSelector("a[data-qa='continue-button']"));
        actions.click(continue_button).perform();
        // 13. Close driver
        driver.quit();

    }

}
