package MultiMath_Math.Precedence;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BracketDetect {
    private final Pattern BRACKET_PATTERN = Pattern.compile("\\(.+\\)");
    private final Pattern MISSING_OUTER_BRACKET_PATTERN = Pattern.compile(".*" + BRACKET_PATTERN);

    public String[] detect(String operation) {
        String bracketContent = "";

        Matcher outerBracketMatcher = MISSING_OUTER_BRACKET_PATTERN.matcher(operation);
        Stack operationsStack = new Stack();
        Integer bracketAmount = 0;
        while (outerBracketMatcher.find()) {
            bracketAmount++;
            String firstMatch = outerBracketMatcher.group();
            if (firstMatch.charAt(0) == '(' && firstMatch.charAt(firstMatch.length() - 1) == ')') {
                bracketContent = firstMatch.substring(1, firstMatch.length() - 1);
            } else {
                bracketContent = firstMatch;
            }

            //if there is a bracket inside the outer bracket, then cut it.
            Matcher innerBracketMatcher = BRACKET_PATTERN.matcher(bracketContent);
            if (innerBracketMatcher.find()) {
                String innerBracket = innerBracketMatcher.group();
                String stringWithoutInnerBracket = bracketContent.replace(innerBracket, "");
                operationsStack.push(stringWithoutInnerBracket);
            } else {
                operationsStack.push(bracketContent);
            }
            //copy bracketContent to search for an inner bracket again
            outerBracketMatcher = BRACKET_PATTERN.matcher(bracketContent);
        }
        //fill the return String array
        String[] extractedOperations = new String[bracketAmount];
        for (int i = 0; i < bracketAmount; i++) {
            extractedOperations[i] = (String) operationsStack.pop();
        }

        return extractedOperations;
    }
}
