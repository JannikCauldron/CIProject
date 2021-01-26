package MultiMath_Math.BasicOperations;

public class Logarithm {
    private String logPattern = "log\\s*\\(\\s*[1-9]+\\s*\\)|log\\s*\\(\\s*0+\\s*\\)";

    public double log(String inputString) {
        double inputNumber;
        if (inputString.matches(logPattern)) {
            String numberString = inputString.replaceAll("[^0-9]", "");
            inputNumber = Double.parseDouble(numberString);
        } else {
            throw new IllegalArgumentException("no valid logarithm expression: " + inputString);
        }
        return Math.log(inputNumber);
    }
}
