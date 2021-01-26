package MultiMath_Math.BasicOperations;

public class Logarithm {
    private String logPattern = "log\\s*\\(\\s*[0-9]+\\s*\\)";

    public double log(String inputString) {
        double inputNumber;
        if (inputString.matches(logPattern)) {
            String numberString = inputString.replaceAll("[^0-9]", "");
            inputNumber = Double.parseDouble(numberString);
        } else {
            return 0;
        }
        return Math.log(inputNumber);
    }
}
