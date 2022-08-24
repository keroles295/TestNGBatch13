package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAnnotationExamples {
    //open the https://www.facebook.com/
    // enter username invalid
    //enter password
    //login click
    //make sure the error is there
    public static WebDriver driver;
    @Test
    public void testForInvalidCredentials() {

        //driver.findElement(By.id("email")).sendKeys("syntax@adfasdfasf.com");
        //driver.findElement(By.id("pass")).sendKeys("whatever");
        //driver.findElement(By.name("login")).click();
        String text = driver.findElement(By.xpath("//h2[contains(text(),'Connect with friends and the world ')]")).getText();
        if (text.equalsIgnoreCase("Connect with friends and the world around you on Facebook.")) {
            System.out.println("Successful");
        } else {
            System.out.println("Unsuccessful/Failed");
        }
        //driver.quit();


    }

    //open the https://www.facebook.com/
//make a new a count
    @Test
    public void testCreatNewAcount() {

        String textOfNewAc=driver.findElement(By.xpath("//a[text()='Create new account']")).getText();
        if (textOfNewAc.equalsIgnoreCase("Create new account")){
            System.out.println("Successful");
        }else {
            System.out.println("Failed");
        }
       // driver.quit();

    }
    @BeforeMethod
    public void settingupBrowser(){
        //seting up the Webdriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        getting the particular url
        driver.get("https://fb.com");

    }
    @AfterMethod
    public void quitingTheBrowser()  {

        driver.quit();
    }
}