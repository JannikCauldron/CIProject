package MultiMath_Math.NumeralSystems;

public class OctalToDecimal {

    private static final int OCTAL_BASE = 8;
    private static final int DIVISION_MODULO_DIVISOR = 10;

    public int convert(int oct) {
        int decimal = 0;
        int i = 0;
        while (oct != 0) {
            decimal += (oct % DIVISION_MODULO_DIVISOR) * Math.pow(OCTAL_BASE, i);
            oct /= DIVISION_MODULO_DIVISOR;
            i++;
        }
        return decimal;
    }
}
