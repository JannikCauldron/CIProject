package MultiMath_Math.BasicOperations;

public class Faculty {
    private static final String FACULTY_PATTERN = "\\d+\\s*!";
    private static final int FACULTY_BASE_RESULT = 1;
    private static final int FIRST_ACTIVE_FACTOR = 2;
    private static final int OPERATION_START_INDEX = 0;
    private static final int INVALID_VALUE_FOR_TESTS = 0;

    private int facultyMatch(String operation) {
        int output = INVALID_VALUE_FOR_TESTS;
        if (operation.matches(FACULTY_PATTERN)) {
            output = Integer.parseInt(operation.substring(OPERATION_START_INDEX, operation.length() - 1));
        }
        return output;
    }

    public int faculty(String operation) {
        int input = facultyMatch(operation);
        int result = FACULTY_BASE_RESULT;
        for (int factor = FIRST_ACTIVE_FACTOR; factor <= input; factor++) result *= factor;
        return result;
    }
}
