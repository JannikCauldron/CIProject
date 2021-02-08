package MultiMath_Math.NumeralSystems;

public class DecimalToOctal {

    private static final char[] OCT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7'};
    private static final int OCT_BASE = 8;
    private static final int START_INDEX = 0;
    private static final String NEGATIVE_VALUE_EXCEPTION_MESSAGE = "No conversion of negative values!";
    private static final String RESULT_FOR_ZERO = "0";
    private StringBuilder oct;

    public String convert(int decimal) throws Exception {

        if (decimal == 0) return RESULT_FOR_ZERO;
        if (decimal < 0) throw new Exception(NEGATIVE_VALUE_EXCEPTION_MESSAGE);

        oct = new StringBuilder();
        int rest;
        while(decimal > 0) {
            rest = decimal % OCT_BASE;
            oct.insert(START_INDEX, OCT_CHARS[rest]);
            decimal /= OCT_BASE;
        }
        return oct.toString();
    }
}
