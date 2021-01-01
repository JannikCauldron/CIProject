package MultiMath_Math;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Power {

    private final Pattern POW_PATTERN = Pattern.compile("[0-9]+\\s*\\^\\s*[0-9]+");

    public double exponentiate(String expo) {
        double result = 0;
        Matcher mat = POW_PATTERN.matcher(expo);
        if (mat.find()) {
            String matchedOp = mat.group();
            int matchedOperationLength = matchedOp.length();
            int powerChar = expo.indexOf("^");
            result = Math.pow(Double.parseDouble(matchedOp.substring(0,powerChar)), Double.parseDouble(matchedOp.substring(matchedOperationLength-powerChar,matchedOperationLength)));
        }
        return result;
    }
}
