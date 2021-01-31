package MultiMath_Math.NumeralSystems;

public class DecimalToOctal {
    public String convert(int decimal) {
        String result = "";
        int tmp;
        char octChars[]={'0','1','2','3','4','5','6','7'};
        while(decimal > 0) {
            tmp = decimal % 8;
            result = octChars[tmp] + result;
            decimal = decimal / 8;
        }
        return result;
    }
}
