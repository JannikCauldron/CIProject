package MultiMath_Math.NumeralSystems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecimalToBinary {
    public Pattern numbPattern = Pattern.compile("\\d+");
    public Pattern decimalToBinaryPattern = Pattern.compile("(bin)\\(" + numbPattern + "\\)");

    public String operate(String operation) {
        String result = "";

        Matcher decToBinMatcher = decimalToBinaryPattern.matcher(operation);
        if (decToBinMatcher.find()) {
            String match = decToBinMatcher.group();
            Matcher numbMatcher = numbPattern.matcher(match);
            if (numbMatcher.find()) {
                int decimalNumber = Integer.parseInt(numbMatcher.group());
                //check necessary amount of bits
                int bitAmountCounter = getBitAmount(decimalNumber);
                //build the binary number
                result = buildBinaryNumber(result, decimalNumber, bitAmountCounter);
            }
        }
        return result;
    }

    private String buildBinaryNumber(String result, int decimalNumber, int bitAmountCounter) {
        for (int i = bitAmountCounter; i > 0; i--) {
            if (i == 1) {
                if (decimalNumber == 1) {
                    result += "1";
                } else {
                    result += "0";
                }
            } else {
                if ((decimalNumber / (int)Math.pow(2.0, i - 1)) == 1) {
                    result += "1";
                    decimalNumber -= (int)Math.pow(2.0, i - 1);
                } else {
                    result += "0";
                }
            }
        }
        return result;
    }

    private int getBitAmount(int decimalNumber) {
        int bitValue = 1;
        int bitAmountCounter = 0;
        while (decimalNumber >= bitValue) {
            bitAmountCounter++;
            bitValue *= 2;
        }
        if (decimalNumber == 0) {
            bitAmountCounter = 1;
        }
        return bitAmountCounter;
    }
}
