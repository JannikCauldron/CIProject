package MultiMath_Math.NumeralSystems;

public class OctalToDecimal {

    private static final int OCTAL_BASE = 8;
    private static final int DIVISION_MODULO_DIVISOR = 10;

    public int convert(int oct) {
        int decimal = 0;
        decimal += (oct % DIVISION_MODULO_DIVISOR) * Math.pow(OCTAL_BASE, 0);
        oct /= DIVISION_MODULO_DIVISOR;
        if (oct != 0) decimal += oct * Math.pow(OCTAL_BASE, 1);
        return decimal;
    }
}
