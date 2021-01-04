package MultiMath_Math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Subtraction {
    public Pattern subtractionPattern = Pattern.compile("\\d+ - \\d+");
    public Pattern numbPattern = Pattern.compile("\\d+");

    public int operate(String operation) {
        int result = 0;

        Matcher subMatcher = subtractionPattern.matcher(operation);
        if (subMatcher.find()) {
            String match = subMatcher.group();
            Matcher numbMatcher = numbPattern.matcher(match);
            if (numbMatcher.find()) {
                result = Integer.parseInt(numbMatcher.group(0));
            }
            if (numbMatcher.find()) {
                result -=  Integer.parseInt(numbMatcher.group(0));
            }
        }

        return result;
    }
}
