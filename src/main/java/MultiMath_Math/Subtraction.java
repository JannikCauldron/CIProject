package MultiMath_Math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Subtraction {
    public Pattern subtractionPattern = Pattern.compile(" - \\d+");
    public Pattern numbPattern = Pattern.compile("\\d+");

    public int operate(String operation) {
        int operationResult = 0;
        //first number to result
        Matcher numbMatcher = numbPattern.matcher(operation);
        if (numbMatcher.find()) {
            operationResult = Integer.parseInt(numbMatcher.group());
        }
        //subtract every following number
        Matcher subMatcher = subtractionPattern.matcher(operation);
        while (subMatcher.find()) {
            String nextSubMatch = subMatcher.group();
            numbMatcher = numbPattern.matcher(nextSubMatch);
            operationResult = subNumb(operationResult, numbMatcher);
        }

        return operationResult;
    }

    private int subNumb(int result, Matcher numbMatcher) {
        if (numbMatcher.find()) {
            result -= Integer.parseInt(numbMatcher.group());
        }
        return result;
    }
}
