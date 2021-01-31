package MultiMath_Math.NumeralSystems;

public class DecimalToHexadecimal {

    public String convert(int decimal) {
        String result = "";
        char hexchars[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        result += hexchars[decimal];
        return result;
    }
}
