package MultiMath_Math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern NUMB_PATTERN = Pattern.compile("\\d+(\\.\\d+)*");
    private static final Pattern ADD_PATTERN = Pattern.compile("\\s*\\+\\s*" + NUMB_PATTERN);

    public double operate(String operation) {
        double operationResult = 0.0;
        //match first integer
        Matcher numbMatcher = NUMB_PATTERN.matcher(operation);
        operationResult = addNumb(operationResult, numbMatcher);
        //match additions
        Matcher addMatcher = ADD_PATTERN.matcher(operation);
        while (addMatcher.find()) {
            String matchedOperation = addMatcher.group();
            numbMatcher = NUMB_PATTERN.matcher(matchedOperation);
            operationResult = addNumb(operationResult, numbMatcher);
        }

        return operationResult;
    }

    private double addNumb(double result, Matcher numbMatcher) {
        if (numbMatcher.find()) {
            result += Double.parseDouble(numbMatcher.group());
        }
        return result;
    }
}
