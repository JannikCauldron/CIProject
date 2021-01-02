package MultiMath_Math.BasicOperations;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Power {

    private final Pattern POW_PATTERN = Pattern.compile("[-$0-9]+\\s*\\^\\s*[0-9]+");

    public double exponentiate(String operation) {
        double result = 0;
        Matcher patternMatcher = POW_PATTERN.matcher(operation);
        if (patternMatcher.find()) {
            String matchedOperation = patternMatcher.group();
            int matchedOperationStringLength = matchedOperation.length();
            int indexOfPowerChar = operation.indexOf("^");
            int stringAfterPowerChar = matchedOperationStringLength - indexOfPowerChar;
            result = Math.pow(Double.parseDouble(matchedOperation.substring(0,indexOfPowerChar)), Double.parseDouble(matchedOperation.substring(matchedOperationStringLength-stringAfterPowerChar+1,matchedOperationStringLength)));
        }
        return result;
    }
}
