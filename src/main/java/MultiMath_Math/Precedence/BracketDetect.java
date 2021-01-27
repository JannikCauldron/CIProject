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
        
        bracketAmount = fillOperationStack(outerBracketMatcher, operationsStack, bracketAmount);
        
        String[] extractedOperations = new String[bracketAmount];
        fillOperationsArray(operationsStack, bracketAmount, extractedOperations);

        return extractedOperations;
    }

    //also returns bracketAmount but most importantly fills the Stack
    private Integer fillOperationStack(Matcher outerBracketMatcher, Stack operationsStack, Integer bracketAmount) {
        String bracketContent;
        while (outerBracketMatcher.find()) {
            bracketAmount++;
            String firstMatch = outerBracketMatcher.group();
            bracketContent = extractBracketContent(firstMatch);

            //if there is a bracket inside the outer bracket, then cut it.
            Matcher innerBracketMatcher = BRACKET_PATTERN.matcher(bracketContent);
            pushOntoOperationStack(operationsStack, bracketContent, innerBracketMatcher);
            //copy bracketContent to search for an inner bracket again
            outerBracketMatcher = BRACKET_PATTERN.matcher(bracketContent);
        }
        return bracketAmount;
    }

    private String extractBracketContent(String firstMatch) {
        String bracketContent;
        if (firstMatch.charAt(0) == '(' && firstMatch.charAt(firstMatch.length() - 1) == ')') {
            bracketContent = firstMatch.substring(1, firstMatch.length() - 1);
        } else {
            bracketContent = firstMatch;
        }
        return bracketContent;
    }

    //actually pushes the content of a bracket onto the Stack
    private void pushOntoOperationStack(Stack operationsStack, String bracketContent, Matcher innerBracketMatcher) {
        if (innerBracketMatcher.find()) {
            String innerBracket = innerBracketMatcher.group();
            String stringWithoutInnerBracket = bracketContent.replace(innerBracket, "");
            operationsStack.push(stringWithoutInnerBracket);
        } else {
            operationsStack.push(bracketContent);
        }
    }

    //fill the return String array
    private void fillOperationsArray(Stack operationsStack, Integer bracketAmount, String[] extractedOperations) {
        for (int i = 0; i < bracketAmount; i++) {
            extractedOperations[i] = (String) operationsStack.pop();
        }
    }
}
