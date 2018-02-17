import java.util.ArrayList;
import java.util.List;

public class Equation {
    double a;
    double b;
    double c;

    public Equation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public List rootSquareEq() {
        double d = b*b - 4*a*c;
        List<Double> arr = new ArrayList<>();
        if(d>0){
            arr.add((-b+ Math.sqrt(d))/2*a);
            arr.add((-b- Math.sqrt(d))/2*a);

        }else if(d == 0){
            arr.add((double) (-b/2*a));
        }
        return arr;
    }
}
