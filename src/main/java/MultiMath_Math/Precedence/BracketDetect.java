package MultiMath_Math.Precedence;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BracketDetect {
    private Pattern bracketPattern = Pattern.compile("\\(.+\\)");

    public String[] detect(String operation) {
        String result = "";

        Matcher bracketMatcher = bracketPattern.matcher(operation);
        Stack opStack = new Stack();
        int cnt = 0;
        while (bracketMatcher.find()) {
            cnt++;
            String match = bracketMatcher.group();
            result = match.substring(1, match.length() - 1);

            Matcher secondBracketMatcher = bracketPattern.matcher(result);
            if (secondBracketMatcher.find()) {
                cnt++;
                String secondMatch = secondBracketMatcher.group();
                opStack.push(result.replace(secondMatch, ""));
                opStack.push(secondMatch.substring(1, secondMatch.length() - 1));
            } else {
                opStack.push(result);
            }
        }
        String resultOperation[] = new String[cnt];
        for (int i = 0; i < cnt; i++) {
            resultOperation[i] = (String) opStack.pop();
        }

        return resultOperation;
    }
}
