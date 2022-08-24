package class02;

import org.testng.annotations.Test;

public class EnableDisablee {
    @Test(enabled = false)
    public void firstTest(){
        System.out.println("1ST test");
    }
    @Test
    public void secondTest(){
        System.out.println("2ST test");
    }
    @Test(groups = "smoke")
    public void thirdTest(){
        System.out.println("3ST test");
    }
}
