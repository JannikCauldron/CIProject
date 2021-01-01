package MultiMath_Math;

public class SquareRoot {
    public double rooted(String root) {
        String sqrtPattern = "sqrt\\(\\s*[0-9]+\\s*\\)";
        int input;
        if (root.matches(sqrtPattern)) {
            String numberString = root.replaceAll("[^0-9]", "");
            input = Integer.parseInt(numberString);
        } else {
            return 0;
        }
        return Math.sqrt(input);
    }
}
