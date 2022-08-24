package class03;

import class02.SoftAssertion;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class dataProviders {
    //navigate to syntax HRMS
    //login to the website and using the following credentials
    //a.username=Admim", password="12345"--->Error Message ="Invalid credentials"
    //b.username="ABCD", password="HUM@hrmn123"--->Error Message="Invalid credentials"
    //c.username="", password="HUM@hrmn123"--->Error Message="Username can not to be empty"
    //d.username="Admin", password=""--->Error Message="Password can not to be empty"
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }
    //define the data provider
    @DataProvider(name="Credentials")
    public Object[][] data() {
        Object [][] login={
                { "Admin","12345","Invalid credentials"},
                {"ABCD","Hum@nhrm123","Invalid credentials"},
                {"Admin","","Password cannot be empty"},
                {"","Hum@nhrm123","Username cannot be empty"}};
        return login;
    }

    @Test(dataProvider = "Credentials")
    public void loginWithVariousCredentials(String usrname , String password ,String expectedError){
//finding the username text box
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        //send username
        username.sendKeys(usrname);
        //        finding the password field
        WebElement pswrd = driver.findElement(By.xpath("//input[@id='txtPassword']"));
//        send password
        pswrd.sendKeys(password);
//        finding the element login btn
        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
//        click the login
        loginBtn.click();

//        get the element message invalid crdentials
        WebElement errorMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
//        extract the error message
        String actualError = errorMsg.getText();
//decalre the soft Assertion
        SoftAssert soft =new SoftAssert();
//    asseert that the error is correct
        soft.assertEquals(actualError,expectedError);
//    assert all
        soft.assertAll();


    }

    @AfterMethod
    public void closeBrowser(){
     driver.quit();
    }

}
