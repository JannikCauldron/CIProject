package MultiMath_Math.BasicOperations;

public class Multiplication {

    public static int multiply(int... factors) {
        int product = 1;

        for(int factor : factors){
            product *= factor;
        }
        return product;
    }
}
