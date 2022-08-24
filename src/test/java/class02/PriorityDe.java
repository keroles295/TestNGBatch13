package class02;

import org.testng.annotations.Test;

public class PriorityDe {
    @Test(priority = 2)
    public void firstTest(){
        System.out.println("1ST test");
    }
    @Test(priority = 1)
    public void secondTest(){
        System.out.println("2ST test");
    }
    @Test(priority = 4)
    public void thirdTest(){
        System.out.println("3ST test");
    }
    @Test(priority = 3)
    public void fourthTest(){
        System.out.println("4ST test");
    }

}
