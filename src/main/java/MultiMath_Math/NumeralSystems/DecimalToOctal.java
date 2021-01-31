package MultiMath_Math.NumeralSystems;

public class DecimalToOctal {

    private static final char[] OCT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7'};
    private static final String EMPTY_STRING = "";
    private static final int OCT_BASE = 8;

    public String convert(int decimal) {
        String result = EMPTY_STRING;
        int tmp;
        while(decimal > 0) {
            tmp = decimal % OCT_BASE;
            result = OCT_CHARS[tmp] + result;
            decimal /= OCT_BASE;
        }
        return result;
    }
}
