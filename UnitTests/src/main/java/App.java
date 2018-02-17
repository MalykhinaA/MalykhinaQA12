import java.util.List;

public class App {

    public static void main(String[] args){
        Equation eq = new Equation(1,4,1);
        List<Double> roots = eq.rootSquareEq();
        System.out.println("Discriminant = " + roots);

    }


}
