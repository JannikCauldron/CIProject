package MultiMath_Math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Subtraction {
    public final Pattern NUMB_PATTERN = Pattern.compile("\\d+(\\.\\d+)*");
    public final Pattern SUBTRACTION_PATTERN = Pattern.compile("\\s*-\\s*" + NUMB_PATTERN);
    public final Pattern INVALID_CHAR_PATTERN = Pattern.compile("[a-zA-ZäöüÄÖÜ§$%&/{}?~#'_:;|><\\$]");

    public double operate(String operation) {
        if (INVALID_CHAR_PATTERN.matcher(operation).find()) {
            throw new IllegalArgumentException("Invalid Operands for subtraction");
        }
        double operationResult = 0;
        //first number to result
        Matcher numbMatcher = NUMB_PATTERN.matcher(operation);
        if (numbMatcher.find()) {
            operationResult = Double.parseDouble(numbMatcher.group());
        }
        //subtract every following number
        Matcher subMatcher = SUBTRACTION_PATTERN.matcher(operation);
        while (subMatcher.find()) {
            String nextSubMatch = subMatcher.group();
            numbMatcher = NUMB_PATTERN.matcher(nextSubMatch);
            operationResult = subNumb(operationResult, numbMatcher);
        }

        return operationResult;
    }

    private double subNumb(double result, Matcher numbMatcher) {
        if (numbMatcher.find()) {
            result -= Double.parseDouble(numbMatcher.group());
        }
        return result;
    }
}
