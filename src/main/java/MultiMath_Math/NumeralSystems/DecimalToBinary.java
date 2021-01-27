package MultiMath_Math.NumeralSystems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecimalToBinary {
    public final Pattern NUMB_PATTERN = Pattern.compile("\\d+");
    public final Pattern DECIMAL_TO_BINARY_PATTERN = Pattern.compile("(bin)\\(" + NUMB_PATTERN + "\\)");
    public final Pattern NEGATIVE_DECIMAL_TO_BINARY_PATTERN = Pattern.compile("(bin)\\(-" + NUMB_PATTERN + "\\)");
    public final Pattern BINARY_TO_DECIMAL_PATTERN = Pattern.compile("(dec)\\([01]+\\)");
    public final Pattern NEGATIVE_BINARY_TO_DECIMAL_PATTERN = Pattern.compile("(dec)\\(1[01]+\\)");
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

        Matcher negBinToDecMatcher = NEGATIVE_BINARY_TO_DECIMAL_PATTERN.matcher(operation);
        result = matchPattern(result, negBinToDecMatcher);

        return result;
    }

    private String matchPattern(String result, Matcher decimalBinaryConversionMatcher) {
        if (decimalBinaryConversionMatcher.find()) {
            Matcher numbMatcher = NUMB_PATTERN.matcher(decimalBinaryConversionMatcher.group());
            if (numbMatcher.find()) {
                //int decimalOrBinaryNumber = Integer.parseInt(numbMatcher.group());
                String decimalOrBinaryNumber = numbMatcher.group();
                //check necessary amount of bits
                int bitAmountCounter = getBitAmount(Integer.parseInt(decimalOrBinaryNumber));
                //build the binary number
                if (decimalBinaryConversionMatcher.pattern() == DECIMAL_TO_BINARY_PATTERN) {
                    result = buildBinaryNumber(decimalOrBinaryNumber, bitAmountCounter, true);
                } else if (decimalBinaryConversionMatcher.pattern() == NEGATIVE_DECIMAL_TO_BINARY_PATTERN) {
                    result = buildBinaryNumber(decimalOrBinaryNumber, bitAmountCounter, false);
                } else if (decimalBinaryConversionMatcher.pattern() == BINARY_TO_DECIMAL_PATTERN) {
                    result = buildDecimalNumber(decimalOrBinaryNumber);
                } else if (decimalBinaryConversionMatcher.pattern() == NEGATIVE_BINARY_TO_DECIMAL_PATTERN) {
                    result = buildDecimalNumber(decimalOrBinaryNumber);
                }
            }
        }
        return result;
    }

    private String buildDecimalNumber(String number) {
        String binaryNumber = number;
        int decimalNumber = 0;
        int bitIndex = 0;
        if (binaryNumber.charAt(0) == '0') {
            for (int i = binaryNumber.length() - 1; i >= 0; i--) {
                if (binaryNumber.charAt(i) == '1') {
                    decimalNumber += (int)Math.pow(2.0, bitIndex);
                }
                bitIndex++;
            }
            return String.valueOf(decimalNumber);
        } else {
            for (int i = binaryNumber.length() - 1; i >= 0; i--) {
                if (binaryNumber.charAt(i) == '0') {
                    decimalNumber += (int)Math.pow(2.0, bitIndex);
                }
                bitIndex++;
            }
            return "-" + decimalNumber;
        }
    }

    //negative numbers with 1's complement method
    private String buildBinaryNumber(String decimalNumber, int bitAmountCounter, boolean isPositive) {
        StringBuilder resultStr = new StringBuilder("");
        int number = Integer.parseInt(decimalNumber);
        if (isPositive) {
            resultStr.append("0");
        } else {
            resultStr.append("1");
        }
        for (int i = bitAmountCounter; i > 0; i--) {
            if (i == 1) {
                if (number == 1) {
                    if (isPositive) resultStr.append("1");
                    else resultStr.append("0");
                } else {
                    if (isPositive) resultStr.append("0");
                    else resultStr.append("1");
                }
            } else {
                if ((number / (int)Math.pow(2.0, i - 1)) == 1) {
                    if (isPositive) resultStr.append("1");
                    else resultStr.append("0");
                    number -= (int)Math.pow(2.0, i - 1);
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
