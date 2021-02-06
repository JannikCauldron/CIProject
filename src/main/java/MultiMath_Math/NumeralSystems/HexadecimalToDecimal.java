package MultiMath_Math.NumeralSystems;

public class HexadecimalToDecimal {

    private static final String HEX_CHARS = "0123456789abcdef";

    public int convert(String hex) {
        hex = hex.toLowerCase();
        int result = 0;
        for(int i = 0; i < hex.length(); i++) {
            result = 16 * result + HEX_CHARS.indexOf(hex.charAt(i));
        }
        return result;
    }
}
