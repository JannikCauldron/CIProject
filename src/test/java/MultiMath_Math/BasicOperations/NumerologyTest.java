package MultiMath_Math.BasicOperations;

import MultiMath_Math.BasicExceptions.ProcessDecimalPlacesException;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumerologyTest {

    Numerology num;

    @BeforeEach
    void setUp() throws Exception {
        num = new Numerology();
    }

    @Test
    public void isEvenTest() {
        // Arrange
        int[] operations = {0, 1, 2, 3, 11, 12, 999998};
        boolean[] expected = {true, false, true, false, false, true, true};
        boolean[] results = new boolean[expected.length];
        // Act
        for (int i = 0; i < expected.length; i++) {
            results[i] = Numerology.isEven(operations[i]);
        }
        // Assert
        MatcherAssert.assertThat("Is Even Test", results, CoreMatchers.equalTo(expected));
    }

    @Test
    public void isPrimeTest() {
        // Arrange
        int[] operations = {17, 7, 23, 13, 19, 109, 90, 69, 77, 108};
        boolean[] expected = {true, true, true, true, true, true, false, false, false, false};
        boolean[] results = new boolean[expected.length];
        // Act
        for (int i = 0; i < expected.length; i++) {
            results[i] = Numerology.isPrime(operations[i]);
        }
        // Assert
        MatcherAssert.assertThat("Is Prime Digit Test", results, CoreMatchers.equalTo(expected));
    }

    @Test
    public void isPrimeParserIntegerDoubleTest() throws ProcessDecimalPlacesException {
        // Arrange
        String[] operations = {"isPrime(1)", "isPrime( 1 )", "isPrime(3.0)"};
        boolean[] expected = {false, false, true};
        boolean[] results = new boolean[expected.length];
        // Act
        for (int i = 0; i < expected.length; i++) {
            results[i] = num.isPrimeParser(operations[i]);
        }
        // Assert
        MatcherAssert.assertThat("Is Prime Digit Parser Test", results, CoreMatchers.equalTo(expected));
    }

    @Test
    public void isEvenParserIntegerDoubleTest() throws ProcessDecimalPlacesException {
        // Arrange
        String[] operations = {"even(0)", "even( 1)", "even(2 )", "even( 3 )", "even(4.0)"};
        boolean[] expected = {true, false, true, false, true};
        boolean[] results = new boolean[expected.length];
        // Act
        for (int i = 0; i < expected.length; i++) {
            results[i] = num.isEvenParser(operations[i]);
        }
        // Assert
        MatcherAssert.assertThat("Is Even Parser Test", results, CoreMatchers.equalTo(expected));
    }

    @Test
    public void whenInEvenCannotProcessDoubleExceptionThrown_thenAssertionSucceeds() {
        // Arrange
        String operation = "even(10.0001)";
        String expectedMessage = "You can't operate this function with decimal places! Number: 10.0001";
        String resultMessage;
        ProcessDecimalPlacesException exception;
        // Act
        exception = assertThrows(ProcessDecimalPlacesException.class, () -> num.isEvenParser(operation));
        resultMessage = exception.getMessage();
        // Assert
        assertTrue(resultMessage.contains(expectedMessage));
    }

    @Test
    public void whenInIsPrimeCannotProcessDoubleExceptionThrown_thenAssertionSucceeds() {
        // Arrange
        String operation = "isPrime(3.1)";
        String expectedMessage = "You can't operate this function with decimal places! Number: 3.1";
        String resultMessage;
        ProcessDecimalPlacesException exception;
        // Act
        exception = assertThrows(ProcessDecimalPlacesException.class, () -> num.isPrimeParser(operation));
        resultMessage = exception.getMessage();
        // Assert
        assertTrue(resultMessage.contains(expectedMessage));
    }

    @Test
    public void negateIntegerParserTest() throws ProcessDecimalPlacesException {
        // Arrange
        String[] operations = {"negate(1)", "negate(-1)"};
        int[] expected = {-1, 1};
        int[] results = new int[expected.length];
        // Act
        for (int i = 0; i < expected.length; i++) {
            results[i] = num.negateIntegerParser(operations[i]);
        }
        // Assert
        MatcherAssert.assertThat("Negate Numbers Integer Parser Test", results, CoreMatchers.equalTo(expected));
    }

}
