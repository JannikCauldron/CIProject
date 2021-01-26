package MultiMath_Math.BasicOperations;

public class Logarithm {

    private final String LOG_PATTERN = "log\\s*\\(\\s*[1-9][0-9]+(\\.[0-9]+)?\\s*\\)|log\\s*\\(\\s*[0-9](\\.[0-9]+)?\\s*\\)";
    private final String FIRST_PATTERN = "log\\s*\\(\\s*[1-9][0-9]+|log\\s*\\(\\s*[0-9]";
    private final String LAST_PATTERN = "(\\.[0-9]+)?\\s*\\)";

    public double log(String inputString) {
        double inputNumber;
        int indexOfDot;
        String subString1 = "";
        String subString2 = "";
        int inputStringLength = inputString.length();

        if (inputString.matches(LOG_PATTERN)) {
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
            throw new IllegalArgumentException("no valid logarithm expression: " + inputString);
        }
        return Math.log(inputNumber);
    }
}
