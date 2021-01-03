package MultiMath_Math.BasicOperations;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Multiplication {

    public static int multiply(int... factors) {
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static double multiply(double[] factors) {
        double product = 1;
        String productString;
        for (double factor : factors) {
            product *= factor;
        }

        // round product to 4 decimals
        DecimalFormat df = new DecimalFormat("#.####");
        df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US));
        df.setRoundingMode(RoundingMode.HALF_UP);
        productString = df.format(product);

        return Double.parseDouble(productString);

    }
}
