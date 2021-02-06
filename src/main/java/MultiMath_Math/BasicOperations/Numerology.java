package MultiMath_Math.BasicOperations;
import java.math.BigInteger;

public class Numerology {

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isPrime(int number) {
        BigInteger bigInt = BigInteger.valueOf(number);
        return bigInt.isProbablePrime(100);
    }

}
