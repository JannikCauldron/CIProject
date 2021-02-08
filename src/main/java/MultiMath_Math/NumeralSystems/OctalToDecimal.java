package MultiMath_Math.NumeralSystems;

public class OctalToDecimal {

    private static final int OCTAL_BASE = 8;
    private static final int DIVISION_MODULO_DIVISOR = 10;
    private static final String NEGATIVE_VALUE_EXCEPTION_MESSAGE = "No negative Values!";
    private static final String NO_OCTAL_NUMBER_EXCEPTION_MESSAGE = "Not an octal number!";
    private static final String OCTAL_PATTERN = "^[0-7]+";

    public int convert(int oct) throws Exception {
        if (oct < 0) throw new Exception(NEGATIVE_VALUE_EXCEPTION_MESSAGE);
        if (!Integer.toString(oct).matches(OCTAL_PATTERN)) throw new Exception(NO_OCTAL_NUMBER_EXCEPTION_MESSAGE);
        return calculateDecimalByOct(oct);
    }

    private int calculateDecimalByOct(int oct) {
        int decimal = 0, power = 0;
        while (oct != 0) {
            decimal += (oct % DIVISION_MODULO_DIVISOR) * Math.pow(OCTAL_BASE, power++);
            oct /= DIVISION_MODULO_DIVISOR;
        }
        return decimal;
    }
}
