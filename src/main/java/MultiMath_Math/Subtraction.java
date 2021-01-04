package MultiMath_Math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Subtraction {
    public Pattern subtractionPattern = Pattern.compile(" - \\d+");
    public Pattern numbPattern = Pattern.compile("\\d+");

    public int operate(String operation) {
        int result = 0;

        Matcher numbMatcher = numbPattern.matcher(operation);
        if (numbMatcher.find()) {
            result = Integer.parseInt(numbMatcher.group());
        }

        Matcher subMatcher = subtractionPattern.matcher(operation);
        while (subMatcher.find()) {
            String match = subMatcher.group();
            numbMatcher = numbPattern.matcher(match);
            if (numbMatcher.find()) {
                result -= Integer.parseInt(numbMatcher.group(0));
            }
        }

        return result;
    }
}
