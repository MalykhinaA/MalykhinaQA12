import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RootEquationTest {
    @Test
    public void equationRootsTest(){
        Equation e = new Equation(-6,-5,1);
        List<Double> roots = new ArrayList<>();
        roots.add(-36.0);
        roots.add(6.0);
        Assert.assertEquals(e.rootSquareEq(),roots);
    }
}
