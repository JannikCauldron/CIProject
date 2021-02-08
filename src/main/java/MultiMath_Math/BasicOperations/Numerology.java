package MultiMath_Math.BasicOperations;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numerology {

    private final String PATTERN_INT = "\\s*[-0-9]+\\s*";
    private final String PATTERN_DOUBLE = "\\s*[-0-9]{1,13}.{1}[0-9]+\\s*";
    private final Pattern NUM_PRIME_PATTERN_INT = Pattern.compile("isPrime\\(" + PATTERN_INT + "\\)\\s*");
    private final Pattern NUM_PRIME_PATTERN_DOUBLE = Pattern.compile("isPrime\\(" + PATTERN_DOUBLE + "\\)\\s*");

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isPrime(int number) {
        BigInteger bigInt = BigInteger.valueOf(number);
        return bigInt.isProbablePrime(100);
    }

    public boolean isPrimeParser(String operation) {

        Matcher patternMatcher = NUM_PRIME_PATTERN_DOUBLE.matcher(operation);
        if (patternMatcher.find()) {
            String matchedOperation = patternMatcher.group();

            matchedOperation = matchedOperation.replaceAll("\\s+", "");

            int posBrackedOpen = matchedOperation.indexOf("(");
            int posBrackedClosed = matchedOperation.indexOf(")");
            matchedOperation = matchedOperation.substring(posBrackedOpen + 1, posBrackedClosed);

            double doubleValue = Double.valueOf(matchedOperation);
            if (0.0 == (doubleValue % 1.0) ) {
                return isPrime((int) doubleValue);
            }


        }
        patternMatcher = NUM_PRIME_PATTERN_INT.matcher(operation);
        if (patternMatcher.find()) {
            String matchedOperation = patternMatcher.group();

            matchedOperation = matchedOperation.replaceAll("\\s+", "");

            int posBrackedOpen = matchedOperation.indexOf("(");
            int posBrackedClosed = matchedOperation.indexOf(")");
            matchedOperation = matchedOperation.substring(posBrackedOpen + 1, posBrackedClosed);

            int intValue = Integer.valueOf(matchedOperation);
            return isPrime(intValue);
        }
        return false;
    }
}
