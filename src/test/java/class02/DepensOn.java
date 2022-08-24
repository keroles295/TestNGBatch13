package class02;

import org.testng.annotations.Test;

public class DepensOn {
    @Test
    public void login(){
        System.out.println("I have logedin successfully");
        //System.out.println(0/0);
    }
    @Test(dependsOnMethods = "login")
    public void verificationOnDashBoardPage(){
        System.out.println("Iam the verify on dashBoard page");
    }
}
