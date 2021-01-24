package MultiMath_Math.NumeralSystems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecimalToBinary {
    public final Pattern NUMB_PATTERN = Pattern.compile("\\d+");
    public final Pattern DECIMAL_TO_BINARY_PATTERN = Pattern.compile("(bin)\\(" + NUMB_PATTERN + "\\)");
    public final Pattern INVALID_INPUT_PATTERN = Pattern.compile("(bin)\\((\\d*[a-z]+)+\\)");

    public String operate(String operation) {
        String result = "";

        if (INVALID_INPUT_PATTERN.matcher(operation).find()) {
            throw new IllegalArgumentException("Invalid input for conversion");
        }

        Matcher decToBinMatcher = DECIMAL_TO_BINARY_PATTERN.matcher(operation);
        if (decToBinMatcher.find()) {
            Matcher numbMatcher = NUMB_PATTERN.matcher(decToBinMatcher.group());
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
        StringBuilder resultStr = new StringBuilder(result);
        for (int i = bitAmountCounter; i > 0; i--) {
            if (i == 1) {
                if (decimalNumber == 1) {
                    resultStr.append("1");
                } else {
                    resultStr.append("0");
                }
            } else {
                if ((decimalNumber / (int)Math.pow(2.0, i - 1)) == 1) {
                    resultStr.append("1");
                    decimalNumber -= (int)Math.pow(2.0, i - 1);
                } else {
                    resultStr.append("0");
                }
            }
        }
        return resultStr.toString();
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
