package MultiMath_Math.BasicOperations;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class Division {

    private static String DOUBLE_DECIMALFORMAT = "#.####";
    private static String INT_DECIMALFORMAT = "#";

    public static double divide(double[] divValues) {
        double quotient = divValues[0];
        String productString;

        for (int i = 1; i < divValues.length; i++) {
            quotient /= divValues[i];
        }
        productString = getRoundedValue(quotient, DOUBLE_DECIMALFORMAT);
        return Double.parseDouble(productString);
    }

    public static int divide(int[] intValues) {
        double quotient = (double)intValues[0];
        String productString;

        for (int i = 1; i < intValues.length; i++) {
            quotient /= (double)intValues[i];
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

}
