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
            results[i] = (int) num.negateParser(operations[i]);
        }
        // Assert
        MatcherAssert.assertThat("Negate Numbers Integer Parser Test", results, CoreMatchers.equalTo(expected));
    }

    @Test
    public void whenInNegateParserCannotProcessTooManyDecimalsExceptionThrown_thenAssertionSucceeds() {
        // Arrange
        String operation = "negate(1.11111111111111)";
        String expectedMessage = "You can't operate this function with invalid decimal places! Number: 1.11111111111111";
        String resultMessage;
        ProcessDecimalPlacesException exception;
        // Act
        exception = assertThrows(ProcessDecimalPlacesException.class, () -> num.negateParser(operation));
        resultMessage = exception.getMessage();
        // Assert
        assertTrue(resultMessage.contains(expectedMessage));
    }

    @Test
    public void negateDoubleParserTest() throws ProcessDecimalPlacesException {
        // Arrange
        String[] operations = {"negate(1.0)", "negate(-3.1)"};
        double[] expected = {-1.0, 3.1};
        double[] results = new double[expected.length];
        // Act
        for (int i = 0; i < expected.length; i++) {
            results[i] = num.negateParser(operations[i]);
        }
        // Assert
        MatcherAssert.assertThat("Negate Numbers Double Parser Test", results, CoreMatchers.equalTo(expected));
    }

    @Test
    public void primefactorizationParserTest() throws ProcessDecimalPlacesException {
        // Arrange
        String[] operations = {"primefactorization(100)", "primefactorization(23)"};
        int[][] expected = {{2, 2, 5, 5}, {23}};
        int[][] results = new int[expected.length][];
        // Act
        for (int i = 0; i < expected.length; i++) {
            results[i] = num.primefactorizationParser(operations[i]);
        }
        // Assert
        MatcherAssert.assertThat("Primefactorization Test", results, CoreMatchers.equalTo(expected));
    }

    @Test
    public void whenInPrimefactorizationCannotProcessDoubleExceptionThrown_thenAssertionSucceeds() {
        // Arrange
        String operation = "primefactorization(3.1)";
        String expectedMessage = "You can't operate this function with decimal places! Number: 3.1";
        String resultMessage;
        ProcessDecimalPlacesException exception;
        // Act
        exception = assertThrows(ProcessDecimalPlacesException.class, () -> num.primefactorizationParser(operation));
        resultMessage = exception.getMessage();
        // Assert
        assertTrue(resultMessage.contains(expectedMessage));
    }

    @Test
    public void gcdParserTest() throws ProcessDecimalPlacesException {
        // Arrange
        String[] operations = {"gcd(100,50)", "gcd(23,998)", "gcd(42, 921)"};
        int[] expected = {50, 1, 3};
        int[] results = new int[expected.length];
        // Act
        for (int i = 0; i < expected.length; i++) {
            results[i] = num.gcdParser(operations[i]);
        }
        // Assert
        MatcherAssert.assertThat("Greatest Common Divisor Test ", results, CoreMatchers.equalTo(expected));
    }

    @Test
    public void whenInGcdParserTestCannotProcessDoubleExceptionThrown_thenAssertionSucceeds() {
        // Arrange
        String operation = "gcd(10.1)";
        String expectedMessage = "You can't operate this function with decimal places! Number: 10.1";
        String resultMessage;
        ProcessDecimalPlacesException exception;
        // Act
        exception = assertThrows(ProcessDecimalPlacesException.class, () -> num.gcdParser(operation));
        resultMessage = exception.getMessage();
        // Assert
        assertTrue(resultMessage.contains(expectedMessage));
    }

    @Test
    public void lcmParserTest() throws ProcessDecimalPlacesException {
        // Arrange
        String[] operations = {"lcm(100,50)", "lcm(23,998)", "lcm(42, 921)"};
        int[] expected = {100, 22954, 12894};
        int[] results = new int[expected.length];
        // Act
        for (int i = 0; i < expected.length; i++) {
            results[i] = num.lcmParser(operations[i]);
        }
        // Assert
        MatcherAssert.assertThat("Greatest Common Divisor Test ", results, CoreMatchers.equalTo(expected));
    }

    @Test
    public void whenInLcmParserTestCannotProcessDoubleExceptionThrown_thenAssertionSucceeds() {
        // Arrange
        String operation = "lcm(10.1, 5.0)";
        String expectedMessage = "You can't operate this function with decimal places! Values: 10.1,5.0";
        String resultMessage;
        ProcessDecimalPlacesException exception;
        // Act
        exception = assertThrows(ProcessDecimalPlacesException.class, () -> num.lcmParser(operation));
        resultMessage = exception.getMessage();
        // Assert
        assertTrue(resultMessage.contains(expectedMessage));
    }
}
