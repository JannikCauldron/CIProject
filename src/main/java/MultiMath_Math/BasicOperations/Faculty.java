package MultiMath_Math.BasicOperations;

public class Faculty {
    private static final String FACULTY_PATTERN = "\\d+\\s*!";
    private static final int FACULTY_BASE_RESULT = 1;
    private static final int FIRST_ACTIVE_FACTOR = 2;
    private static final int OPERATION_START_INDEX = 0;
    private static final int INVALID_VALUE_FOR_TESTS = 0;
    public static final String OVERFLOW_EXCEPTION_MESSAGE = "Overflow!";

    private int facultyMatch(String operation) {
        int output = INVALID_VALUE_FOR_TESTS;
        if (operation.matches(FACULTY_PATTERN)) {
            output = Integer.parseInt(operation.substring(OPERATION_START_INDEX, operation.length() - 1));
        }
        return output;
    }

    public int faculty(String operation) throws Exception {
        int input = facultyMatch(operation);
        return (int)calculateFaculty(input);
    }

    private long calculateFaculty(int input) throws Exception {
        long result = FACULTY_BASE_RESULT;
        for (long factor = FIRST_ACTIVE_FACTOR; factor <= input; factor++) {
            if (factor * result > Integer.MAX_VALUE) throw new Exception(OVERFLOW_EXCEPTION_MESSAGE);
            result *= factor;
        }
        return result;
    }
}
