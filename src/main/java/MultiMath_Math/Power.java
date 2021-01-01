package MultiMath_Math;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Power {

    private final Pattern POW_PATTERN = Pattern.compile("[0-9]+\\s*\\^\\s*[0-9]+");

    public double exponentiate(String operation) {
        double result = 0;
        Matcher patternMatcher = POW_PATTERN.matcher(operation);
        if (patternMatcher.find()) {
            String matchedOperation = patternMatcher.group();
            int matchedOperationStringLength = matchedOperation.length();
            int powerCharIndex = operation.indexOf("^");
            result = Math.pow(Double.parseDouble(matchedOperation.substring(0,powerCharIndex)), Double.parseDouble(matchedOperation.substring(matchedOperationStringLength-powerCharIndex,matchedOperationStringLength)));
        }
        return result;
    }
}
