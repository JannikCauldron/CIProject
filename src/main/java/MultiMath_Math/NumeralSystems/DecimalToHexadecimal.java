package MultiMath_Math.NumeralSystems;

public class DecimalToHexadecimal {

    private static final char[] HEXCHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int HEX_BASE = 16;
    private static final String EMPTY_STRING = "";
    private static final int START_INDEX = 0;
    private static final String NEGATIVE_VALUE_EXCEPTION_MESSAGE = "No conversion of negative values!";
    private static final String RESULT_FOR_ZERO = "0";
    private static StringBuilder hex;

    public String convert(int decimal) throws Exception {

        if (decimal < 0) throw new Exception(NEGATIVE_VALUE_EXCEPTION_MESSAGE);
        if (decimal == 0) return RESULT_FOR_ZERO;

        hex = new StringBuilder(EMPTY_STRING);
        int rest;
        while(decimal > 0) {
            rest = decimal % HEX_BASE;
            hex.insert(START_INDEX, HEXCHARS[rest]);
            decimal /= HEX_BASE;
        }
        return hex.toString();
    }
}
