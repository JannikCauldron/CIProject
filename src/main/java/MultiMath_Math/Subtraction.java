package MultiMath_Math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Subtraction {
    public final Pattern SUBTRACTION_PATTERN = Pattern.compile("\\s*-\\s*\\d+(\\.\\d+)*");
    public final Pattern NUMB_PATTERN = Pattern.compile("\\d+(\\.\\d+)*");

    public double operate(String operation) {
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
