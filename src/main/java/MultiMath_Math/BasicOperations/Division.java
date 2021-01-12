package MultiMath_Math.BasicOperations;

import MultiMath_Math.BasicExceptions.DividedByZeroException;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class Division {

    private static String DOUBLE_DECIMALFORMAT = "#.####";
    private static String INT_DECIMALFORMAT = "#";

    public static double divide(double... divValues) throws DividedByZeroException {
        double quotient = divValues[0];
        String productString;

        for (int i = 1; i < divValues.length; i++) {
            if (isZero(divValues[i])) {
                throw new DividedByZeroException("You can't divide by 0! Divisor: 0");
            }
            quotient /= divValues[i];
        }
        productString = getRoundedValue(quotient, DOUBLE_DECIMALFORMAT);
        return Double.parseDouble(productString);
    }


    public static int divide(int... intValues) throws DividedByZeroException {
        double quotient = (double) intValues[0];
        String productString;

        for (int i = 1; i < intValues.length; i++) {
            if (isZero((double) intValues[i])) {
                throw new DividedByZeroException("You can't divide by 0! Divisor: 0");
            }
            quotient /= (double) intValues[i];
        }
        productString = getRoundedValue(quotient, INT_DECIMALFORMAT);
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
        if (number == 0.0d) {
            return true;
        }
        return false;
    }

}
