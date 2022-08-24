package class03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class ParallelTesting {
    //navigate to syntaxhrms
    //we need to write to case to verfiy the wrong credentials give error message
    //2.assert that the username is display
    //quit the browser
    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(groups = "regression")
    public void verifyInvalidCredentialsError() throws InterruptedException {
        //finding the username text box
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        //send keys
        username.sendKeys("sdfgh");

        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("234567lkjhgfd");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginButton.click();

        //        get the element message invalid crdentials
        WebElement errorrMessage= driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String errorText= errorrMessage.getText();
        //expected text
        String expectedText="Invalid credentials";
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(errorText, expectedText);
        //get the Webelement username
        username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        boolean display= username.isDisplayed();
        System.out.println("Hello I am going to test the second assertion");
        //make sure the username is displayed
        soft.assertTrue(display);
        Thread.sleep(5000);

        soft.assertAll();
    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser () {
        driver.quit();
    }
}
