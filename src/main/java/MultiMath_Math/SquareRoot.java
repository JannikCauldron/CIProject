package MultiMath_Math;

public class SquareRoot {
    private final String SQRT_PATTERN = "sqrt\\(\\s*[1-9]+\\s*\\)|sqrt\\(\\s*0+\\s*\\)";
    public double rooted(String inputString) {
        int inputNumber;
        if (inputString.matches(SQRT_PATTERN)) {
            String numberString = inputString.replaceAll("[^0-9]", "");
            inputNumber = Integer.parseInt(numberString);
        } else {
            throw new IllegalArgumentException("no valid root expression: " + inputString);
        }
        return Math.sqrt(inputNumber);
    }
}
