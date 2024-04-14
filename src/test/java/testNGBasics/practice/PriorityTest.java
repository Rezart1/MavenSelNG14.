package testNGBasics.practice;

import org.testng.annotations.Test;

public class PriorityTest {

    @Test
    public void d_method(){
        System.out.println("Method d got executed");
    }

    @Test
    public void a_method(){
        System.out.println("Method a got executed");
    }

    @Test
    public void c_method(){
        System.out.println("Method c got executed");
    }

}
