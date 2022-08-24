package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {
    //writting down my first case
    @Test//Test annotation is used to indicate that this is a test case
    public void firstTestCase(){
        System.out.println("Hey I am a first test case");
    }
    @Test(groups = "smoke")
    public void secondTestCase (){
        System.out.println("Hey I am a second test case");
    }
    @Test
    public void thirdTestCase(){
        System.out.println("Hey I am a Third test case");
    }
@BeforeMethod
    public void beforeMthod(){
    System.out.println("Hey! I am A BEFORE METHOD");
}
@AfterMethod
    public void afterMethod(){
    System.out.println("Hey Iam Afteeeeer MeTHODD ");
}


}
