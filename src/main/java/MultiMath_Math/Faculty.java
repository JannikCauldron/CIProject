package MultiMath_Math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Faculty {
    private static final Pattern FAC_PATTERN = Pattern.compile("\\d+\\s*!");

    public int facultyMatch(String operation) {
        Matcher facMatcher = FAC_PATTERN.matcher(operation);
        int output = -1;
        if (facMatcher.find()) {
            String matchedString = facMatcher.group();
            output = Integer.parseInt(matchedString.substring(0,1));
        }
        return output;
    }

    public int faculty(String operation) {
        int end = facultyMatch(operation);
        int result = 1;
        for (int factor = 2; factor <= end; factor++) {
            result *= factor;
        }
        return result;
    }
}
