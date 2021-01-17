package MultiMath_Math.BasicOperations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Faculty {
    private static final Pattern FAC_PATTERN = Pattern.compile("\\d+\\s*!");
    public static final int FAC_BASE_RESULT = 1;
    public static final int FIRST_ACTIVE_FACTOR = 2;
    public static final int INVALID_VALUE_FOR_TESTS = -1;

    public int facultyMatch(String operation) {
        Matcher facMatcher = FAC_PATTERN.matcher(operation);
        int output = INVALID_VALUE_FOR_TESTS;
        if (facMatcher.find()) {
            String matchedString = facMatcher.group();
            output = Integer.parseInt(matchedString.substring(0,matchedString.length() - 1));
        }
        return output;
    }

    public int faculty(String operation) {
        int input = facultyMatch(operation);
        int result = FAC_BASE_RESULT;
        for (int factor = FIRST_ACTIVE_FACTOR; factor <= input; factor++) result *= factor;
        return result;
    }
}
