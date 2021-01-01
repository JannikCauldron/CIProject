package MultiMath_Math;

public class SquareRoot {
    private String sqrtPattern = "sqrt\\(\\s*[0-9]+\\s*\\)";
    public double rooted(String inputString) {
        int inputNumber;
        if (inputString.matches(sqrtPattern)) {
            String numberString = inputString.replaceAll("[^0-9]", "");
            inputNumber = Integer.parseInt(numberString);
        } else {
            return Double.NaN;
        }
        return Math.sqrt(inputNumber);
    }
}
