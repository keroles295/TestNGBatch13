package class03;

import org.testng.annotations.*;

public class Annotations {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Iam before Suiteeee");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("Iam before Suiteee");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Iam before Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Iam the Before Class");
    }
    @Test
    public void at1Test(){
        System.out.println("Iam At 1 Test");
    }
    @Test
    public void at2Test(){
        System.out.println("Iam At 2 Test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("Iam After Test");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am After Class");
    }
}
