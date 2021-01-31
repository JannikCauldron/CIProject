package MultiMath_Math.NumeralSystems;

public class DecimalToHexadecimal {

    private static final char[] HEXCHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String convert(int decimal) {
        String result = "";
        int tmp;
        while(decimal > 0) {
            tmp = decimal % 16;
            result = HEXCHARS[tmp] + result;
            decimal /= 16;
        }
        return result;
    }
}
