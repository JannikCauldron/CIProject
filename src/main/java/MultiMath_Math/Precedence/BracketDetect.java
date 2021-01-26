package MultiMath_Math.Precedence;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BracketDetect {
    private final Pattern BRACKET_PATTERN = Pattern.compile("\\(.+\\)");

    public String[] detect(String operation) {
        String bracketContent = "";

        Matcher firstBracketMatcher = BRACKET_PATTERN.matcher(operation);
        Stack operationsStack = new Stack();
        int bracketAmount = 0;
        while (firstBracketMatcher.find()) {
            bracketAmount++;
            String firstMatch = firstBracketMatcher.group();
            bracketContent = firstMatch.substring(1, firstMatch.length() - 1);

            Matcher tmp = BRACKET_PATTERN.matcher(bracketContent);
            if (tmp.find()) {
                String ersatz = tmp.group();
                String newString = bracketContent.replace(ersatz, "");
                operationsStack.push(newString);
            } else {
                operationsStack.push(bracketContent);
            }

            firstBracketMatcher = BRACKET_PATTERN.matcher(bracketContent);
        }
        String extractedOperations[] = new String[bracketAmount];
        for (int i = 0; i < bracketAmount; i++) {
            extractedOperations[i] = (String) operationsStack.pop();
        }

        return extractedOperations;
    }
}
