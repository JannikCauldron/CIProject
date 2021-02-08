package MultiMath_Math.BasicOperations;

import MultiMath_Math.BasicExceptions.ProcessDecimalPlacesException;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numerology {

    public static final String DECIMAL_PLACES_EXCEPTION_TEXT = "You can't operate this function with decimal places! Number: ";
    private final String PATTERN_INT = "\\s*[-0-9]+\\s*";
    private final String PATTERN_DOUBLE = "\\s*[-0-9]{1,13}.{1}[0-9]+\\s*";
    private final Pattern NUM_NEGATE_PATTERN_INT = Pattern.compile("negate\\(" + PATTERN_INT + "\\)\\s*");
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

    public boolean isPrimeParser(String operation) throws ProcessDecimalPlacesException {

        Matcher patternMatcher = NUM_PRIME_PATTERN_DOUBLE.matcher(operation);
        if (patternMatcher.find()) {
            String matchedOperation = patternMatcher.group();

            matchedOperation = Format.getValueBetweenBrackets(matchedOperation);

            double doubleValue = Format.getDoubleValue(matchedOperation);
            decimalProcessing(doubleValue);

            return isPrime((int) doubleValue);
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
            decimalProcessing(doubleValue);

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

    private void decimalProcessing(double doubleValue) throws ProcessDecimalPlacesException {
        if (0.0 != (doubleValue % 1.0)) {
            throw new ProcessDecimalPlacesException(DECIMAL_PLACES_EXCEPTION_TEXT + doubleValue);
        }
    }

    public int negateIntegerParser(String operation) throws ProcessDecimalPlacesException {
        Matcher patternMatcher;
        patternMatcher = NUM_NEGATE_PATTERN_INT.matcher(operation);
        if (patternMatcher.find()) {
            String matchedOperation = patternMatcher.group();

            matchedOperation = Format.getValueBetweenBrackets(matchedOperation);

            int intValue = Format.getIntValue(matchedOperation);
            return (-1) * intValue;
        } else {
            String valueInOperation = Format.getValueBetweenBrackets(operation);
            throw new ProcessDecimalPlacesException(DECIMAL_PLACES_EXCEPTION_TEXT + valueInOperation);
        }
    }
}
