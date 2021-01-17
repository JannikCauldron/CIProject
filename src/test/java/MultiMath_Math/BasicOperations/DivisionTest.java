package MultiMath_Math.BasicOperations;

import MultiMath_Math.BasicExceptions.DividedByZeroException;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DivisionTest {


    @Test
    public void doubleDivisionTest() throws Exception {
        // Arrange
        double[][] divArray = {{5d, 2d},         // with decimals
                {50d, 2d, 5d, 5d},               // without decimals
                {0.05, 1000},                    // division below 4 decimals and round half_up
                {7531, 73},                      // ###.####
                {-0.001d, 0.03d}};               // periodic number 0.033333333
        double[] expectedQuotientArray = {2.5d, 1d, 0.0001d, 103.1644d, -0.0333d};
        // Act
        int ArrayLength = divArray.length;
        double[] resultArray = new double[ArrayLength];
        for (int i = 0; i < ArrayLength; i++) {
            resultArray[i] = Division.divide(divArray[i]);
        }
        // Assert
        MatcherAssert.assertThat("Double Division Test:", resultArray, CoreMatchers.equalTo(expectedQuotientArray));
    }

    @Test
    public void integerDivisionTest() throws Exception {
        // Arrange
        int[][] divArray = {{5, 2},         // round up
                {50, 2, 5, 5},                 // no rounding necessary
                {12, 11},                      // round down
                {0, 1000},                     // zero dividing
                {-1, -1, -1, -1, -1}};         // negative numbers
        int[] expectedQuotientArray = {3, 1, 1, 0, -1};
        // Act
        int ArrayLength = divArray.length;
        int[] resultArray = new int[ArrayLength];
        for (int i = 0; i < ArrayLength; i++) {
            resultArray[i] = Division.divide(divArray[i]);
        }
        // Assert
        MatcherAssert.assertThat("Integer Division Test:", resultArray, CoreMatchers.equalTo(expectedQuotientArray));
    }

    @Test
    public void whenDividedByZeroExceptionThrown_thenAssertionSucceeds() throws DividedByZeroException {
        // Arrange
        int dividend = 10;
        int divisor = 0;
        String expectedMessage = "You can't divide by 0! Divisor: 0";
        String resultMessage = "";
        DividedByZeroException exception;
        // Act
        exception = assertThrows(DividedByZeroException.class, () -> {
            Division.divide(dividend, divisor);
        });
        resultMessage = exception.getMessage();
        // Assert
        assertTrue(resultMessage.contains(expectedMessage));
    }

    @Test
    public void divisionIntegerParsingTest() throws Exception {
        // Arrange
        String[] operations = {"6/3", "20 / 10", " 100 /10/  9"};
        int[] expected = {2, 2, 1};
        int[] results = new int[expected.length];
        // Act
        for (int i = 0; i < operations.length; i++) {
            results[i] = Division.parseIntDivision(operations[i]);
        }
        // Assert
        MatcherAssert.assertThat("Division Parsing Error", results, CoreMatchers.equalTo(expected));

    }


}
