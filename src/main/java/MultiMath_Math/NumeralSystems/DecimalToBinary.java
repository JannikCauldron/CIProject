package MultiMath_Math.NumeralSystems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecimalToBinary {
    public Pattern decimalToBinaryPattern = Pattern.compile("(bin)\\(\\d\\)");

    public String operate(String operation) {
        String result = "";

        Matcher decToBinMatcher = decimalToBinaryPattern.matcher(operation);
        if (decToBinMatcher.find()) {
            String match = decToBinMatcher.group();
            int decimalNumber = Integer.parseInt(match.substring(4, 5));
            int bitValue = 1;
            int bitAmountCounter = 0;
            while (decimalNumber >= bitValue) {
                bitAmountCounter++;
                bitValue *= 2;
            }
            if (decimalNumber == 0) bitAmountCounter = 1;

            for (int i = bitAmountCounter; i > 0; i--) {
                if (i == 1) {
                    if (decimalNumber == 1) {
                        result += "1";
                    } else {
                        result += "0";
                    }
                } else {
                    if (decimalNumber / ((i - 1) * 2) == 1) {
                        result += "1";
                        decimalNumber -= (i - 1) * 2;
                    } else {
                        result += "0";
                    }
                }
            }
        }

        return result;
    }
}
