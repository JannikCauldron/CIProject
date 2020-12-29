package MultiMath_Math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private Pattern addPattern = Pattern.compile("[0-9]\\s\\+\\s[0-9]");

    public int operate(String operation) {
        int result = 0;
        Matcher addMatcher = addPattern.matcher(operation);
        if (addMatcher.find()) {
            String matchedOperation = addMatcher.group();
            result = Integer.parseInt(matchedOperation.substring(0,1)) + Integer.parseInt(matchedOperation.substring(4,5));
        }

        return result;
    }
}
