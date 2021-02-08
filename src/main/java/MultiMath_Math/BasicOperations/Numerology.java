package MultiMath_Math.BasicOperations;

import MultiMath_Math.BasicExceptions.ProcessDecimalPlacesException;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numerology {

    public static final String DECIMAL_PLACES_EXCEPTION_TEXT = "You can't operate this function with decimal places! Number: ";
    public static final String DECIMAL_PLACES_EXCEPTION_MULTIPLE_VALUES_TEXT = "You can't operate this function with decimal places! Values: ";
    public static final String INVALID_DECIMAL_PLACES_EXCEPTION_TEXT = "You can't operate this function with invalid decimal places! Number: ";
    private final String PATTERN_INT = "\\s*[-0-9]+\\s*";
    private final String PATTERN_DOUBLE = "\\s*[-0-9]{1,13}.{1}[0-9]{1,13}\\s*";
    private final Pattern NUM_LCM_PATTERN_INT = Pattern.compile("lcm\\(" + PATTERN_INT + "\\s*,\\s*" + PATTERN_INT + "\\)\\s*");
    private final Pattern NUM_GCD_PATTERN_INT = Pattern.compile("gcd\\(" + PATTERN_INT + "\\s*,\\s*" + PATTERN_INT + "\\)\\s*");
    private final Pattern NUM_PRIMFACTORIZATION_PATTERN_INT = Pattern.compile("primefactorization\\(" + PATTERN_INT + "\\)\\s*");
    private final Pattern NUM_NEGATE_PATTERN_INT = Pattern.compile("negate\\(" + PATTERN_INT + "\\)\\s*");
    private final Pattern NUM_NEGATE_PATTERN_DOUBLE = Pattern.compile("negate\\(" + PATTERN_DOUBLE + "\\)\\s*");
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

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        while (b != 0) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }

    public static int lcm(int number1, int number2) {
        return (number1 * number2) / gcd(number1, number2);
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

    public double negateParser(String operation) throws ProcessDecimalPlacesException {
        Matcher patternMatcher;
        patternMatcher = NUM_NEGATE_PATTERN_DOUBLE.matcher(operation);
        if (patternMatcher.find()) {
            String matchedOperation = patternMatcher.group();

            matchedOperation = Format.getValueBetweenBrackets(matchedOperation);

            double doubleValue = Format.getDoubleValue(matchedOperation);
            return negate(doubleValue);
        }

        patternMatcher = NUM_NEGATE_PATTERN_INT.matcher(operation);
        if (patternMatcher.find()) {
            String matchedOperation = patternMatcher.group();

            matchedOperation = Format.getValueBetweenBrackets(matchedOperation);

            int intValue = Format.getIntValue(matchedOperation);
            return negate(intValue);
        } else {
            String valueInOperation = Format.getValueBetweenBrackets(operation);
            throw new ProcessDecimalPlacesException(INVALID_DECIMAL_PLACES_EXCEPTION_TEXT + valueInOperation);
        }
    }

    private double negate(double doubleValue) {
        return -1.0 * doubleValue;
    }

    public int[] primefactorizationParser(String operation) throws ProcessDecimalPlacesException {
        int[] result;
        Matcher patternMatcher;
        patternMatcher = NUM_PRIMFACTORIZATION_PATTERN_INT.matcher(operation);
        if (patternMatcher.find()) {
            String matchedOperation = patternMatcher.group();

            matchedOperation = Format.getValueBetweenBrackets(matchedOperation);

            int intValue = Format.getIntValue(matchedOperation);
            result = primefactorization(intValue);
            return result;
        } else {
            String valueInOperation = Format.getValueBetweenBrackets(operation);
            throw new ProcessDecimalPlacesException(DECIMAL_PLACES_EXCEPTION_TEXT + valueInOperation);
        }
    }

    private int[] primefactorization(int number) {
        List<Integer> factors = new ArrayList<>();
        while (number % 2 == 0) {
            factors.add(2);
            number /= 2;
        }
        for (int mod = 3; mod * mod <= number; mod += 2) {
            while (number % mod == 0) {
                factors.add(mod);
                number /= mod;
            }
        }
        if (number > 1) factors.add(number);

        return Format.convertToIntArray(factors);
    }

    public int gcdParser(String operation) throws ProcessDecimalPlacesException {
        Matcher patternMatcher = NUM_GCD_PATTERN_INT.matcher(operation);
        if (patternMatcher.find()) {
            String matchedOperation = patternMatcher.group();

            matchedOperation = Format.getValueBetweenBrackets(matchedOperation);
            String[] splitOperationString = Format.splitOperationByDelimiter(matchedOperation, ",");
            int[] intValues = Format.format2Integer(splitOperationString);

            return gcd(intValues[0], intValues[1]);
        } else {
            String valueInOperation = Format.getValueBetweenBrackets(operation);
            throw new ProcessDecimalPlacesException(DECIMAL_PLACES_EXCEPTION_MULTIPLE_VALUES_TEXT + valueInOperation);
        }
    }

    public int lcmParser(String operation) throws ProcessDecimalPlacesException {
        Matcher patternMatcher = NUM_LCM_PATTERN_INT.matcher(operation);
        if (patternMatcher.find()) {
            String matchedOperation = patternMatcher.group();

            matchedOperation = Format.getValueBetweenBrackets(matchedOperation);
            String[] splitOperationString = Format.splitOperationByDelimiter(matchedOperation, ",");
            int[] intValues = Format.format2Integer(splitOperationString);

            return lcm(intValues[0], intValues[1]);
        } else {
            String valueInOperation = Format.getValueBetweenBrackets(operation);
            throw new ProcessDecimalPlacesException(DECIMAL_PLACES_EXCEPTION_MULTIPLE_VALUES_TEXT + valueInOperation);
        }
    }
}
