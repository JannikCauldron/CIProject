package MultiMath_Math.BasicOperations;

import MultiMath_Math.BasicOperations.SquareRoot;
import org.hamcrest.CoreMatchers;
import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class SquareRootTest {
    SquareRoot squareRoot;

    @BeforeEach
    void setUp() throws Exception {
        squareRoot = new SquareRoot();
    }

    @Test
    public void rootTest() throws Exception {
        // Arrange
        String operation = "sqrt(9)";
        double expected = Math.sqrt(9);
        // Act
        double result = squareRoot.rooted(operation);
        // Assert
        MatcherAssert.assertThat("wrong root", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void rootWithSpaceTest() throws Exception {
        // Arrange
        String operation = "sqrt(   9  )";
        double expected = Math.sqrt(9);
        // Act
        double result = squareRoot.rooted(operation);
        // Assert
        MatcherAssert.assertThat("wrong root with space", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void rootWithNegativeTest() throws Exception {
        // Arrange
        String operation = "sqrt(-3)";
        Exception expected = assertThrows(IllegalArgumentException.class, () -> squareRoot.rooted(operation));
        String expectedMessage = "no valid root expression: " + operation;
        // Act
        String actualMessage = expected.getMessage();
        // Assert
        assertTrue(actualMessage.contentEquals(expectedMessage));
    }

    @Test
    public void rootWithLeadingZeroTest() throws Exception {
        // Arrange
        String operation = "sqrt(07)";
        String expectedMessage = "no valid root expression: " + operation;
        // Act
        Exception result = assertThrows(IllegalArgumentException.class, () -> squareRoot.rooted(operation));
        String resultMessage = result.getMessage();
        // Assert
        assertTrue(resultMessage.contentEquals(expectedMessage));
    }

    @Test
    public void rootWithOnlyZeroTest() throws Exception {
        // Arrange
        String operation = "sqrt(0)";
        double expected = Math.sqrt(0);
        // Act
        double result = squareRoot.rooted(operation);
        // Assert
        MatcherAssert.assertThat("wrong root", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void rootWithDecimalTest() throws Exception {
        // Arrange
        String operation = "sqrt(0.25)";
        double expected = Math.sqrt(0.25);
        // Act
        double result = squareRoot.rooted(operation);
        // Assert
        MatcherAssert.assertThat("wrong root of decimal", result, CoreMatchers.equalTo(expected));
    }
}
