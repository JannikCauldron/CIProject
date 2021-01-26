package MultiMath_Math.Precedence;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BracketDetect {
    private Pattern bracketPattern = Pattern.compile("\\(.+\\)");

    public String detect(String operation) {
        String result = "";

        Matcher bracketMatcher = bracketPattern.matcher(operation);
        if (bracketMatcher.find()) {
            String match = bracketMatcher.group();
            result = match.substring(1, match.length() - 1);
        }

        return result;
    }
}
