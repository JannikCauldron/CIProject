package MultiMath_Math.BasicOperations;

import java.util.List;

public class Format {


    public static String removeWhitespace(String operation) {
        return operation.replaceAll("\\s+", "");
    }

    public static String returnNumberStringInBrackets(String operation) {
        int posBrackedOpen = operation.indexOf("(");
        int posBrackedClosed = operation.indexOf(")");
        return operation.substring(posBrackedOpen + 1, posBrackedClosed);
    }

    public static Integer getIntValue(String operation) {
        return Integer.valueOf(operation);
    }

    public static Double getDoubleValue(String operation) {
        return Double.valueOf(operation);
    }

    public static String getValueBetweenBrackets(String operation) {
        operation = removeWhitespace(operation);
        operation = returnNumberStringInBrackets(operation);
        return operation;
    }

    public static int[] convertToIntArray(List<Integer> values) {
        int[] results = new int[values.size()];
        int i = 0;
        for (Integer value :
                values) {
            results[i] = value;
            i++;
        }
        return results;
    }

    public static int[] format2Integer(String[] valueStrings) {
        int[] intValues = new int[valueStrings.length];
        for (int i = 0; i < valueStrings.length; i++) {
            intValues[i] = Format.getIntValue(valueStrings[i]);
        }
        return intValues;
    }

    public static String[] splitOperationByDelimiter(String operation, String delimiter) {
        return operation.split(delimiter);
    }
}
