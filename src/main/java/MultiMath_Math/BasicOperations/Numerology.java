package MultiMath_Math.BasicOperations;
import MultiMath_Math.BasicExceptions.ProcessDecimalPlacesException;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numerology {

    private final String PATTERN_INT = "\\s*[-0-9]+\\s*";
    private final String PATTERN_DOUBLE = "\\s*[-0-9]{1,13}.{1}[0-9]+\\s*";
    private final Pattern NUM_EVEN_PATTERN_INT = Pattern.compile("even\\(" + PATTERN_INT + "\\)\\s*");
    private final Pattern NUM_EVEN_PATTERN_DOUBLE = Pattern.compile("even\\(" + PATTERN_DOUBLE + "\\)\\s*");
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

            matchedOperation = Format.getValueBetweenBrackets(matchedOperation);

            double doubleValue = Format.getDoubleValue(matchedOperation);
            if (0.0 == (doubleValue % 1.0) ) {
                return isPrime((int) doubleValue);
            }
        }
        patternMatcher = NUM_PRIME_PATTERN_INT.matcher(operation);
        if (patternMatcher.find()) {
            String matchedOperation = patternMatcher.group();

            matchedOperation = Format.getValueBetweenBrackets(matchedOperation);

            int intValue = Format.getIntValue(matchedOperation);
            return isPrime(intValue);
        }
        return false;
    }

    public boolean isEvenParser(String operation) throws ProcessDecimalPlacesException {


        Matcher patternMatcher = NUM_EVEN_PATTERN_DOUBLE.matcher(operation);
        if (patternMatcher.find()) {
            String matchedOperation = patternMatcher.group();

            matchedOperation = Format.getValueBetweenBrackets(matchedOperation);

            double doubleValue = Format.getDoubleValue(matchedOperation);
            if (0.0 != (doubleValue % 1.0)) {
                throw new ProcessDecimalPlacesException("You can't operate this function with decimal places! Number: " + doubleValue);
            }
            return isEven((int) doubleValue);
        }
        patternMatcher = NUM_EVEN_PATTERN_INT.matcher(operation);
        if (patternMatcher.find()) {
            String matchedOperation = patternMatcher.group();

            matchedOperation = Format.getValueBetweenBrackets(matchedOperation);

            int intValue = Format.getIntValue(matchedOperation);
            return isEven(intValue);
        }
        return false;
    }
}
