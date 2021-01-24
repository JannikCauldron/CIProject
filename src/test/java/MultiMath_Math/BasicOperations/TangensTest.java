package MultiMath_Math.BasicOperations;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TangensTest {
    Tangens obj;

    @BeforeEach
    void setUp() throws Exception {
        obj = new Tangens();
    }

    @Test
    public void tangensWithOneDigitPositiveInteger() {
        // Arrange
        String number = "5";
        String operation = "tan(" + number + ")";
        double expected = Math.tan(Integer.parseInt(number));

        // Act
        double result = obj.calcTangens(operation);

        // Assert
        MatcherAssert.assertThat("result", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void tangensWithAnyPositiveDigitInteger() {
        // Arrange
        String number = "50";
        String operation = "tan(" + number + ")";
        double expected = Math.tan(Integer.parseInt(number));

        // Act
        double result = obj.calcTangens(operation);

        // Assert
        MatcherAssert.assertThat("result", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void tangensWithSpacesBetweenParentheses() {
        // Arrange
        String number = "50";
        String operation = "tan(  " + number + "  )";
        double expected = Math.tan(Integer.parseInt(number));

        // Act
        double result = obj.calcTangens(operation);

        // Assert
        MatcherAssert.assertThat("result", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void tangensWithDigitAndLetter() {
        // Arrange
        String number = "5a";
        String operation = "tan(  " + number + "  )";
        String expectedMsg = "Error in tangens expression";

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> obj.calcTangens(operation));
        String resultMsg = exception.getMessage();

        // Assert
        assertTrue(resultMsg.contentEquals(expectedMsg));
    }

    @Test
    public void tangensWithAnyNegativeDigitsInExpression() {
        // Arrange
        String number = "-50";
        String operation = "tan(" + number + ")";
        double expected = Math.tan(Integer.parseInt(number));

        // Act
        double result = obj.calcTangens(operation);

        // Assert
        MatcherAssert.assertThat("result", result, CoreMatchers.equalTo(expected));
    }
}
