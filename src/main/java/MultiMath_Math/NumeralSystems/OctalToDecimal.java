package MultiMath_Math.NumeralSystems;

public class OctalToDecimal {

    private static final int OCTAL_BASE = 8;
    private static final int DIVISION_MODULO_DIVISOR = 10;
    private static final String NEGATIVE_VALUE_EXCEPTION_MESSAGE = "No negative Values!";

    public int convert(int oct) throws Exception {
        if (oct < 0) throw new Exception(NEGATIVE_VALUE_EXCEPTION_MESSAGE);
        if (!Integer.toString(oct).matches("^[0-7]+")) throw new Exception("Not an octal number!");
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
