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
        if (firstBracketMatcher.find()) {
            bracketAmount++;
            String firstMatch = firstBracketMatcher.group();
            bracketContent = firstMatch.substring(1, firstMatch.length() - 1);
            //if there is a bracket inside a bracket
            Matcher secondBracketMatcher = BRACKET_PATTERN.matcher(bracketContent);
            if (secondBracketMatcher.find()) {
                bracketAmount++;
                String secondMatch = secondBracketMatcher.group();
                operationsStack.push(bracketContent.replace(secondMatch, ""));
                operationsStack.push(secondMatch.substring(1, secondMatch.length() - 1));
            } else {
                operationsStack.push(bracketContent);
            }
        }
        String extractedOperations[] = new String[bracketAmount];
        for (int i = 0; i < bracketAmount; i++) {
            extractedOperations[i] = (String) operationsStack.pop();
        }

        return extractedOperations;
    }
}
