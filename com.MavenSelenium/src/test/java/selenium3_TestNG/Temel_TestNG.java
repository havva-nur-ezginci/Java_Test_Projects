package selenium3_TestNG;
//1. study
import org.testng.annotations.*;
// öncelik sırası => Suite,Test,Class,Groups,method
public class Temel_TestNG {
    @BeforeSuite
    public void bs(){System.out.println("Before suit");}
    @BeforeTest
    public void bt(){System.out.println("Before test");}
    @BeforeGroups("testOne")
    public void bg(){System.out.println("Before groups");}
    @BeforeClass
    public void bc(){System.out.println("Before class");}
    @BeforeMethod
    public void bm(){System.out.println("Before method");}

    @Test(groups={"testOne"})
    public void test1(){System.out.println("Test1");}
    @Test
    public void test2(){System.out.println("Test2");}

    /*küçük olan priority önce çalışır.
- Eğer eşit priority varsa isim sırasına göre çalışır.
- Bir test methoduna priority yazılmazsa testNG priority=0 olarak kabul eder ve bu değere göre sıralamaya koyar.
     */
    @Test(priority = 2)//priority ler kendi aralarında sıralanır.
    public void test3(){System.out.println("Test3");}
    @Test(priority = 1)
    public void test4(){System.out.println("Test4");}
    @Test(priority = -1)
    public void test5(){System.out.println("Test5");}

    @AfterMethod
    public void am(){System.out.println("after method");}
    @AfterClass
    public void ac(){System.out.println("after class");}
    @AfterGroups("testOne")
    public void ag(){System.out.println("after groups");}

    @AfterTest
    public void at(){System.out.println("after test");}
    @AfterSuite
    public void as(){System.out.println("after suit");}

}
/* Output:
Before suit
Before test
Before class
Before method
Test5
after method
Before groups
Before method
Test1
after method
after groups
Before method
Test2
after method
Before method
Test4
after method
Before method
Test3
after method
after class
after test
after suit
 */
