package MultiMath_Math.NumeralSystems;

public class OctalToDecimal {

    private static final int OCTAL_BASE = 8;
    private static final int DIVISION_MODULO_DIVISOR = 10;

    public int convert(int oct) {
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
