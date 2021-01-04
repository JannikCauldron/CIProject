package MultiMath_Math.BasicOperations;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Modulo {

    private final Pattern MOD_PATTERN = Pattern.compile("[0-9]+\\s*%\\s*[0-9]+");

    public double moduloOp(String operation) {
        double result = 0;
        Matcher patternMatcher = MOD_PATTERN.matcher(operation);
        if (patternMatcher.find()) {
            String matchedOperation = patternMatcher.group();
            int matchedOperationLength = matchedOperation.length();
            int moduloCharIndex = operation.indexOf("%");
            int stringAfterModuloChar = matchedOperationLength - moduloCharIndex;
            result = Double.parseDouble(matchedOperation.substring(0,moduloCharIndex)) % Double.parseDouble(matchedOperation.substring(matchedOperationLength - stringAfterModuloChar + 1,matchedOperationLength));
        }
        return result;
    }
}
