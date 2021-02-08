package MultiMath_Math.NumeralSystems;

public class OctalToDecimal {
    public int convert(int oct) {
        int result = 0;
        result += (oct % 10) * Math.pow(8, 0);
        oct /= 10;
        if (oct != 0) result += oct * Math.pow(8, 1);
        return result;
    }
}
