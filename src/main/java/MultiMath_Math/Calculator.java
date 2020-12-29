package MultiMath_Math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern ADD_PATTERN = Pattern.compile("\\d\\s*\\+\\s*\\d");

    public int operate(String operation) {
        int operationResult = 0;
        Matcher addMatcher = ADD_PATTERN.matcher(operation);
        if (addMatcher.find()) {
            String matchedOperation = addMatcher.group();
            int matchedOperationStringLength = matchedOperation.length();
            operationResult = Integer.parseInt(matchedOperation.substring(0,1)) + Integer.parseInt(matchedOperation.substring(matchedOperationStringLength-1,matchedOperationStringLength));
        }

        return operationResult;
    }
}
