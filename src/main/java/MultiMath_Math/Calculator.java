package MultiMath_Math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern ADD_PATTERN = Pattern.compile("\\s*\\+\\s*\\d");
    private static final Pattern NUMB_PATTERN = Pattern.compile("\\d+");

    public int operate(String operation) {
        int operationResult = 0;
        Matcher numbMatcher = NUMB_PATTERN.matcher(operation);
        if (numbMatcher.find()) {
            operationResult = Integer.parseInt(numbMatcher.group());
            Matcher addMatcher = ADD_PATTERN.matcher(operation);
            while (addMatcher.find()) {
                String matchedOperation = addMatcher.group();
                numbMatcher = NUMB_PATTERN.matcher(matchedOperation);
                if (numbMatcher.find()) {
                    operationResult += Integer.parseInt(numbMatcher.group());
                }
            }
        }

        return operationResult;
    }
}
