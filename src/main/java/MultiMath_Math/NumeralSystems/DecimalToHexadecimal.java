package MultiMath_Math.NumeralSystems;

public class DecimalToHexadecimal {

    private static final char[] HEXCHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int HEX_BASE = 16;
    private static final String EMPTY_STRING = "";
    private static final int START_INDEX = 0;
    private static StringBuilder hex;

    public String convert(int decimal) {
        hex = new StringBuilder(EMPTY_STRING);
        int hexTmp;
        while(decimal > 0) {
            hexTmp = decimal % HEX_BASE;
            hex.insert(START_INDEX, HEXCHARS[hexTmp]);
            decimal /= HEX_BASE;
        }
        return hex.toString();
    }
}
