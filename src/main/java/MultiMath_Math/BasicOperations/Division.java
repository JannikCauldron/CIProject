package MultiMath_Math.BasicOperations;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Division {

    public static double divide(double[] divValues) {
        double quotient = divValues[0];
        String productString;

        for (int i = 1; i < divValues.length; i++) {
            quotient /= divValues[i];
        }
        productString = getRoundedValue(quotient);
        return Double.parseDouble(productString);
    }


    private static String getRoundedValue(double product) {
        String productString;
        DecimalFormat df = new DecimalFormat("#.####");
        df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US));
        df.setRoundingMode(RoundingMode.HALF_UP);
        productString = df.format(product);
        return productString;
    }
}
