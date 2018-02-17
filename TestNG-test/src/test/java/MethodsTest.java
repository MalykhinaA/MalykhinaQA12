import org.testng.annotations.Test;

public class MethodsTest {

    @Test(priority = 0)
    public void test2(){
        System.out.println("Test 2");
    }

    @Test(priority = 1)
    public  void test1(){
        System.out.println("Test 1");
    }


    public void notATest(){
        System.out.println("Not a test!");
    }

}
