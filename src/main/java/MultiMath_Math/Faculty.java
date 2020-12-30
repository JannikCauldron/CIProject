package MultiMath_Math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Faculty {
    private static final Pattern FAC_PATTERN = Pattern.compile("\\d+\\s*!");

    public int facultyMatch(String operation) {
        Matcher m = FAC_PATTERN.matcher(operation);
        int result = -1;
        if (m.find()) {
            String matchedString = m.group();
            int matchedOperationStringLength = matchedString.length();
            result = faculty(Integer.parseInt(matchedString.substring(0,1)));
        }
        return result;
    }

    public int faculty(int in) {
        int result = 1;
        for (int factor = 2; factor <= in; factor++) {
            result *= factor;
        }
        return result;
    }
}
