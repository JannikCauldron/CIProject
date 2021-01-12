package MultiMath_Math.BasicOperations;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class IntegerDivision {

    private final Pattern INTDIV_PATTERN = Pattern.compile("div\\s*\\(\\s*[0-9]\\s*,\\s*[0-9]\\s*\\)");

    public int div(String operation) {
        int result = 0;
        Matcher divMatcher = INTDIV_PATTERN.matcher(operation);
        if (divMatcher.find()) {
            String matchedOperation = divMatcher.group();
            result = Integer.parseInt(matchedOperation.substring(4,5)) / Integer.parseInt(matchedOperation.substring(6,7));
        }
        return result;
    }
}
