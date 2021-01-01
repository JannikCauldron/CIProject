package MultiMath_Math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SquareRoot {

    private final String SQRT_PATTERN = "sqrt\\(\\s*[1-9][0-9]+(\\.[0-9]+)?\\s*\\)|sqrt\\(\\s*[0-9](\\.[0-9]+)?\\s*\\)";
    private final String FIRST_PATTERN = "sqrt\\(\\s*[1-9][0-9]+|sqrt\\(\\s*[0-9]";
    private final String LAST_PATTERN = "(\\.[0-9]+)?\\s*\\)";
    public double rooted(String inputString) {
        double inputNumber;
        int indexOfDot;
        String subString1 = "";
        String subString2 = "";
        int inputStringLength = inputString.length();

        if (inputString.matches(SQRT_PATTERN)) {
            if (inputString.contains(".")) {
                indexOfDot = inputString.indexOf('.');

                subString1 = inputString.substring(0, indexOfDot);
                subString2 = inputString.substring(indexOfDot+1, inputStringLength);

                String numberString1 = subString1.replaceAll("[^0-9]", "");
                String numberString2 = subString2.replaceAll("[^0-9]", "");

                String numberString = numberString1 + "." + numberString2;
                inputNumber = Double.parseDouble(numberString);
            } else {
                String numberString = inputString.replaceAll("[^0-9]", "");
                inputNumber = Double.parseDouble(numberString);
            }
        } else {
            throw new IllegalArgumentException("no valid root expression: " + inputString);
        }
        return Math.sqrt(inputNumber);
    }
}
