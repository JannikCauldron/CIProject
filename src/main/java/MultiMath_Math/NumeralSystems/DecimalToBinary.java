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

        Matcher conversionMatcher = DECIMAL_TO_BINARY_PATTERN.matcher(operation);
        result = matchPattern(result, conversionMatcher);
        conversionMatcher = NEGATIVE_DECIMAL_TO_BINARY_PATTERN.matcher(operation);
        result = matchPattern(result, conversionMatcher);
        conversionMatcher = BINARY_TO_DECIMAL_PATTERN.matcher(operation);
        result = matchPattern(result, conversionMatcher);
        conversionMatcher = NEGATIVE_BINARY_TO_DECIMAL_PATTERN.matcher(operation);
        result = matchPattern(result, conversionMatcher);

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

    //negative numbers with 1's complement method
    private String buildDecimalNumber(String binaryNumber) {
        int decimalNumber = 0;
        int bitIndex = 0;
        if (binaryNumber.charAt(0) == '0') {
            decimalNumber = addToDecimalNumber(binaryNumber, decimalNumber, bitIndex, '1');
            return String.valueOf(decimalNumber);
        } else {
            decimalNumber = addToDecimalNumber(binaryNumber, decimalNumber, bitIndex, '0');
            return "-" + decimalNumber;
        }
    }

    private int addToDecimalNumber(String binaryNumber, int decimalNumber, int bitIndex, char c) {
        for (int i = binaryNumber.length() - 1; i >= 0; i--) {
            if (binaryNumber.charAt(i) == c) {
                decimalNumber += (int) Math.pow(2.0, bitIndex);
            }
            bitIndex++;
        }
        return decimalNumber;
    }

    //negative numbers with 1's complement method
    private String buildBinaryNumber(String number, int bitAmountCounter, boolean isPositive) {
        StringBuilder resultStr = new StringBuilder("");
        int decimalNumber = Integer.parseInt(number);
        if (isPositive) {
            resultStr.append("0");
        } else {
            resultStr.append("1");
        }
        buildBinaryNumberTail(bitAmountCounter, isPositive, resultStr, decimalNumber);
        return resultStr.toString();
    }

    private void buildBinaryNumberTail(int bitAmountCounter, boolean isPositive, StringBuilder resultStr, int decimalNumber) {
        for (int i = bitAmountCounter; i > 0; i--) {
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
