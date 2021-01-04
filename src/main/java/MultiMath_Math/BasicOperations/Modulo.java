package MultiMath_Math.BasicOperations;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Modulo {

    private final Pattern MOD_PATTERN = Pattern.compile("[0-9]\\s*%\\s*[0-9]");

    public double moduloOp(String operation) {
        double result = 0;
        Matcher modMatcher = MOD_PATTERN.matcher(operation);
        if (modMatcher.find()) {
            String matchedOperation = modMatcher.group();
            int matchedOperationLength = matchedOperation.length();
            result = Double.parseDouble(matchedOperation.substring(0,1)) % Double.parseDouble(matchedOperation.substring(matchedOperationLength-1,matchedOperationLength));
        }
        return result;
    }
}
