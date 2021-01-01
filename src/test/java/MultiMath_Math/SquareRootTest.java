package MultiMath_Math;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
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
        assertThat("wrong root", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void rootWithSpace() throws Exception {
        // Arrange
        String operation = "sqrt(   9  )";
        double expected = Math.sqrt(9);
        // Act
        double result = squareRoot.rooted(operation);
        // Assert
        assertThat("wrong root with space", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void rootWithNegative() throws Exception {
        // Arrange
        String operation = "sqrt(-3)";
        Exception expected = assertThrows(IllegalArgumentException.class, () -> {squareRoot.rooted(operation);});
        String expectedMessage = "no valid root expression: " + operation;
        // Act
        String actualMessage = expected.getMessage();
        // Assert
        assertTrue(actualMessage.contentEquals(expectedMessage));
    }

    @Test
    public void rootWithLeadingZero() throws Exception {
        // Arrange
        String operation = "sqrt(07)";
        String expectedMessage = "no valid root expression: " + operation;
        // Act
        Exception result = assertThrows(IllegalArgumentException.class, () -> {squareRoot.rooted(operation);});
        String resultMessage = result.getMessage();
        // Assert
        assertTrue(resultMessage.contentEquals(expectedMessage));
    }
}
