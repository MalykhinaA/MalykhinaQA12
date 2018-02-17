import org.testng.annotations.Test;

public class TaggedMethodsTest {

    @Test(groups = "positive")
    public void positiveTest(){
        System.out.println("positiveTest");
    }

    @Test(groups = "negative")
    public  void negativeTest(){
        System.out.println("negativeTest");
    }

    @Test(groups = {"positive","broken"})
    public void brokenTest(){
        System.out.println("brokenTest");
    }
}
