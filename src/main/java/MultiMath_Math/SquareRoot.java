package MultiMath_Math;

public class SquareRoot {
    private String sqrtPattern = "sqrt\\(\\s*[1-9]+\\s*\\)";
    public double rooted(String inputString) {
        int inputNumber;
        if (inputString.matches(sqrtPattern)) {
            String numberString = inputString.replaceAll("[^0-9]", "");
            inputNumber = Integer.parseInt(numberString);
        } else {
            throw new IllegalArgumentException("no valid root expression: " + inputString);
        }
        return Math.sqrt(inputNumber);
    }
}
