package MultiMath_Math.NumeralSystems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecimalToBinary {
    public final Pattern NUMB_PATTERN = Pattern.compile("\\d+");
    public final Pattern DECIMAL_TO_BINARY_PATTERN = Pattern.compile("(bin)\\(" + NUMB_PATTERN + "\\)");
    public final Pattern NEGATIVE_DECIMAL_TO_BINARY_PATTERN = Pattern.compile("(bin)\\(-" + NUMB_PATTERN + "\\)");
    public final Pattern BINARY_TO_DECIMAL_PATTERN = Pattern.compile("(dec)\\([01]+\\)");
    public final Pattern INVALID_INPUT_PATTERN = Pattern.compile("(bin)\\((\\d*[a-z]+)+\\)");

    public String operate(String operation) {
        String result = "";

        if (INVALID_INPUT_PATTERN.matcher(operation).find()) {
            throw new IllegalArgumentException("Invalid input for conversion");
        }

        Matcher decToBinMatcher = DECIMAL_TO_BINARY_PATTERN.matcher(operation);
        result = matchPattern(result, decToBinMatcher);

        Matcher negDecToBinMatcher = NEGATIVE_DECIMAL_TO_BINARY_PATTERN.matcher(operation);
        result = matchPattern(result, negDecToBinMatcher);

        Matcher binToDecMatcher = BINARY_TO_DECIMAL_PATTERN.matcher(operation);
        result = matchPattern(result, binToDecMatcher);

        return result;
    }

    private String matchPattern(String result, Matcher decToBinMatcher) {
        if (decToBinMatcher.find()) {
            Matcher numbMatcher = NUMB_PATTERN.matcher(decToBinMatcher.group());
            if (numbMatcher.find()) {
                int decimalNumber = Integer.parseInt(numbMatcher.group());
                //check necessary amount of bits
                int bitAmountCounter = getBitAmount(decimalNumber);
                //build the binary number
                if (decToBinMatcher.pattern() == DECIMAL_TO_BINARY_PATTERN) {
                    result = buildBinaryNumber(result, decimalNumber, bitAmountCounter, true);
                } else if (decToBinMatcher.pattern() == NEGATIVE_DECIMAL_TO_BINARY_PATTERN) {
                    result = buildBinaryNumber(result, decimalNumber, bitAmountCounter, false);
                } else if (decToBinMatcher.pattern() == BINARY_TO_DECIMAL_PATTERN) {
                    result = buildDecimalNumber(result, decimalNumber);
                }
            }
        }
        return result;
    }

    private String buildDecimalNumber(String result, int decimalNumber) {
        String binaryNumber = String.valueOf(decimalNumber);
        int res = 0;
        int cnt = 0;
        for (int i = binaryNumber.length() - 1; i >= 0; i--) {
            if (binaryNumber.charAt(i) == '1') {
                res += (int)Math.pow(2.0, cnt);
            }
            cnt++;
        }
        return String.valueOf(res);
    }

    //negative numbers with 1's complement method
    private String buildBinaryNumber(String result, int decimalNumber, int bitAmountCounter, boolean isPositive) {
        StringBuilder resultStr = new StringBuilder(result);
        if (isPositive) {
            resultStr.append("0");
        } else {
            resultStr.append("1");
        }
        for (int i = bitAmountCounter; i > 0; i--) {
            if (i == 1) {
                if (decimalNumber == 1) {
                    if (isPositive) resultStr.append("1");
                    else resultStr.append("0");
                } else {
                    if (isPositive) resultStr.append("0");
                    else resultStr.append("1");
                }
            } else {
                if ((decimalNumber / (int)Math.pow(2.0, i - 1)) == 1) {
                    if (isPositive) resultStr.append("1");
                    else resultStr.append("0");
                    decimalNumber -= (int)Math.pow(2.0, i - 1);
                } else {
                    if (isPositive) resultStr.append("0");
                    else resultStr.append("1");
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
