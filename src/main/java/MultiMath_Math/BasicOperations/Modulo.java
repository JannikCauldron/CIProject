package MultiMath_Math.BasicOperations;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Modulo {

    private Pattern MOD_PATTERN = Pattern.compile("[0-9]\\s%\\s[0-9]");

    public double moduloOp(String operation) {
        double result = 0;
        Matcher mat = MOD_PATTERN.matcher(operation);
        if (mat.find()) {
            String matchedOp = mat.group();
            result = Double.parseDouble(matchedOp.substring(0,1)) % Double.parseDouble(matchedOp.substring(4,5));
        }
        return result;
    }
}
