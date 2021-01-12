package MultiMath_Math.BasicOperations;

import MultiMath_Math.BasicExceptions.DividedByZeroException;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class Division {

    private static final String DOUBLE_DECIMAL_FORMAT = "#.####";
    private static final String INT_DECIMAL_FORMAT = "#";

    @SuppressWarnings("UnnecessaryLocalVariable")
    public static double divide(double... divValues) throws DividedByZeroException {
        double quotient = divValues[0];
        String productString;

        for (int i = 1; i < divValues.length; i++) {
            if (isZero(divValues[i])) {
                throw new DividedByZeroException("You can't divide by 0! Divisor: 0");
            }
            quotient /= divValues[i];
        }
        productString = getRoundedValue(quotient, DOUBLE_DECIMAL_FORMAT);
        return Double.parseDouble(productString);
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    public static int divide(int... intValues) throws DividedByZeroException {
        double quotient = intValues[0];
        String productString;

        for (int i = 1; i < intValues.length; i++) {
            if (isZero(intValues[i])) {
                throw new DividedByZeroException("You can't divide by 0! Divisor: 0");
            }
            quotient /= intValues[i];
        }
        productString = getRoundedValue(quotient, INT_DECIMAL_FORMAT);
        return Integer.parseInt(productString);
    }


    private static String getRoundedValue(double product, String decimalFormat) {
        String productString;
        DecimalFormat df = new DecimalFormat(decimalFormat);
        df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US));
        df.setRoundingMode(RoundingMode.HALF_UP);
        productString = df.format(product);
        return productString;
    }

    private static boolean isZero(double number) {
        return number == 0.0d;
    }

}
