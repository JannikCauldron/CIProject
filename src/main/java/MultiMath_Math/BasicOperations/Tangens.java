package MultiMath_Math.BasicOperations;

public class Tangens {

    public double calcTangens(String input) {
        int result;
        String pattern = "^tan\\(\\d+\\)$";

        if (input.matches(pattern)) {
            String extractNumber = input.replaceAll("\\D", "");
            result = Integer.parseInt(extractNumber);
            return Math.tan(result);
        }
        return -1;
    }
}
