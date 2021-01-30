package MultiMath_Math.Precedence;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BracketDetect {
    private final Pattern BRACKET_PATTERN = Pattern.compile("\\(.+\\)");
    private final Pattern MISSING_OUTER_BRACKET_PATTERN = Pattern.compile(".*" + BRACKET_PATTERN + ".*");
    private final Pattern TWO_BRACKETS_ON_SAME_LEVEL_PATTERN = Pattern.compile(BRACKET_PATTERN + "\\s*\\*\\s*" + BRACKET_PATTERN);
    private final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]");
    private final Pattern OPERATOR_PATTERN = Pattern.compile("[-+/*]");

    public String[] detect(String operation) {
        Stack operationsStack = new Stack();
        Integer bracketAmount = 0;
        Matcher bracketMatcher = TWO_BRACKETS_ON_SAME_LEVEL_PATTERN.matcher(operation);
        bracketAmount = twoBracketFillOperationStack(bracketMatcher, operationsStack, bracketAmount);
        if (bracketAmount == 0) {
            bracketMatcher = MISSING_OUTER_BRACKET_PATTERN.matcher(operation);
            bracketAmount = fillOperationStack(bracketMatcher, operationsStack, bracketAmount);
        }

        String[] extractedOperations = new String[bracketAmount];
        fillOperationsArray(operationsStack, bracketAmount, extractedOperations);

        return extractedOperations;
    }

    private Integer twoBracketFillOperationStack(Matcher bracketMatcher, Stack operationsStack, Integer bracketAmount) {
        Stack reverseOrder = new Stack();
        if (bracketMatcher.find()) {
            String matchedString = bracketMatcher.group();

            matchedString = formatString(matchedString);

            //Until matchedString isn't empty, continue to cut content from it.
            while (matchedString.length() > 0) {
                String bracketContent;
                if (matchedString.contains("(") && matchedString.contains(")")) {
                    bracketContent = matchedString.substring(matchedString.indexOf('('), matchedString.indexOf(')') + 1);
                } else {
                    bracketContent = matchedString;
                }
                //Cut bracket out of matchedString
                matchedString = matchedString.replace(bracketContent, "");
                //get content of bracket
                bracketContent = extractBracketContent(bracketContent);
                reverseOrder.push(bracketContent);
                bracketAmount++;
            }
            //Get stack items in the right order
            while (!reverseOrder.empty()) {
                operationsStack.push(reverseOrder.pop());
            }
        }
        return bracketAmount;
    }

    private String formatString(String matchedString) {
        //cut all whitespaces
        matchedString = matchedString.replaceAll("\\s", "");
        //add whitespaces to format string
        StringBuilder formatString = new StringBuilder("");
        for (int i = 0; i < matchedString.length(); i++) {
            formatString.append(matchedString.charAt(i));
            //insert whitespaces between numbers and operators or operators and brackets
            if (i != matchedString.length() - 1 && (Pattern.matches(NUMBER_PATTERN.toString(), "" + matchedString.charAt(i)) && Pattern.matches(OPERATOR_PATTERN.toString(), "" + matchedString.charAt(i + 1))
            || Pattern.matches(OPERATOR_PATTERN.toString(), "" + matchedString.charAt(i)) && Pattern.matches(NUMBER_PATTERN.toString(), "" + matchedString.charAt(i + 1))
            || Pattern.matches("\\)", "" + matchedString.charAt(i)) && Pattern.matches(OPERATOR_PATTERN.toString(), "" + matchedString.charAt(i + 1))
            || Pattern.matches(OPERATOR_PATTERN.toString(), "" + matchedString.charAt(i)) && Pattern.matches("\\(", "" + matchedString.charAt(i + 1)))) {
                formatString.append(" ");
            }
        }
        return formatString.substring(0);
    }

    //also returns bracketAmount but most importantly fills the Stack
    private Integer fillOperationStack(Matcher outerBracketMatcher, Stack operationsStack, Integer bracketAmount) {
        String bracketContent;
        while (outerBracketMatcher.find()) {
            bracketAmount++;
            String firstMatch = outerBracketMatcher.group();
            firstMatch = formatString(firstMatch);
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
