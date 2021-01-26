package MultiMath_Math.BasicOperations;

public class CommonLogarithm {
    private final String LOGC_PATTERN = "logc\\s*\\(\\s*[1-9][0-9]+(\\.[0-9]+)?\\s*\\)|logc\\s*\\(\\s*[0-9](\\.[0-9]+)?\\s*\\)";

    public double logc(String inputString) {

        double inputNumber;
        int indexOfDot;
        String subString1;
        String subString2;
        int inputStringLength = inputString.length();

        if (inputString.matches(LOGC_PATTERN)) {
            if (inputString.contains(".")) {

                indexOfDot = inputString.indexOf('.');

                subString1 = inputString.substring(0, indexOfDot);
                subString2 = inputString.substring(indexOfDot+1, inputStringLength);

                String numberString1 = subString1.replaceAll("[^0-9]", "");
                String numberString2 = subString2.replaceAll("[^0-9]", "");
                String numberString = numberString1 + "." + numberString2;

                inputNumber = Double.parseDouble(numberString);

            } else {
                String numberString = inputString.replaceAll("[^0-9]", "");
                inputNumber = Double.parseDouble(numberString);
            }
        } else {
            throw new IllegalArgumentException("no valid common logarithm expression: " + inputString);
        }
        return Math.log10(inputNumber);
    }
}
