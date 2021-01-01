package MultiMath_Math;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Power {

    private Pattern POW_PATTERN = Pattern.compile("[0-9]\\s*\\^\\s*[0-9]");

    public int exponentiate(String expo) {
        double result = 0;
        Matcher mat = POW_PATTERN.matcher(expo);
        if (mat.find()) {
            String matchedOp = mat.group();
            int matchedOperationLength = matchedOp.length();
            result = Math.pow(Double.parseDouble(matchedOp.substring(0,1)), Double.parseDouble(matchedOp.substring(matchedOperationLength-1,matchedOperationLength)));
        }
        return (int)result;
    }
}
