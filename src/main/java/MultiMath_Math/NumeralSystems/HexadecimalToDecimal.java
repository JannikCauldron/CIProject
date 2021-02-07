package MultiMath_Math.NumeralSystems;

public class HexadecimalToDecimal {

    private static final String HEX_CHARS = "0123456789abcdef";
    private static final int HEX_BASE = 16;

    public int convert(String hex) throws Exception {
        hex = hex.toLowerCase();
        if (!hex.matches("^[a-f0-9]+")) throw new Exception("Input was no hexadecimal String!");
        return calculateDec_CharByChar(hex);
    }

    private int calculateDec_CharByChar(String hex) {
        int decimal = 0;
        for(int index = 0; index < hex.length(); index++) {
            decimal = HEX_BASE * decimal + HEX_CHARS.indexOf(hex.charAt(index));
        }
        return decimal;
    }
}
