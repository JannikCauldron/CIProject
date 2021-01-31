package MultiMath_Math.NumeralSystems;

public class DecimalToHexadecimal {

    private static final char[] HEXCHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int HEX_BASE = 16;
    public static final String EMPTY_STRING = "";

    public String convert(int decimal) {
        String hex = EMPTY_STRING;
        int hextmp;
        while(decimal > 0) {
            hextmp = decimal % HEX_BASE;
            hex = HEXCHARS[hextmp] + hex;
            decimal /= HEX_BASE;
        }
        return hex;
    }
}
