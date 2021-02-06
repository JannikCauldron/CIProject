package MultiMath_Math.NumeralSystems;

public class HexadecimalToDecimal {
    public int convert(String hex) {
        String hexChars = "0123456789abcdef";
        return hexChars.indexOf(hex);
    }
}
