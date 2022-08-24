package class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HardAssertions {
    //navigate to syntaxhrms
    //we need to write to case to verfiy the wrong credentials give error message
    //quit the browser

    //nagigate to the website(HRMS)
    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test(groups = "regression")
    public void verifyInvalidCredentialsError() {
        //finding the username text box
        WebElement username=driver.findElement(By.xpath("//input[@id='txtUsername']"));
        //send keys
        username.sendKeys("sdfgh");

        WebElement password= driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("234567lkjhgfd");

        WebElement loginButton= driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginButton.click();

        WebElement errorrMessage= driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String errorText= errorrMessage.getText();

        System.out.println("errorText = " + errorText);
        //declaring the exprection message
        String expectedMesg="Invalid credentials";
        //making assertion to make sure that correct
        Assert.assertEquals(errorText, expectedMesg);
        //the text box username is displayed
        username=driver.findElement(By.xpath("//input[@id='txtUsername']"));//because  after we click on login page

        //the page going to be refreshed, so we need to just re-assgin  it again
        boolean displayed =username.isDisplayed();
        //System.out.println("displayed = " + displayed);
        Assert.assertTrue(displayed);



    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }

}
