package MultiMath_Math.BasicOperations;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class SinusTest {
    Sinus obj;

    @BeforeEach
    void setUp() throws Exception {
        obj = new Sinus();
    }

    @Test
    public void sinusWithIntegerTest() throws Exception {
        // Arrange
        String number = "5";
        String op = "sin(" + number + ")";
        double expected = Math.sin(Integer.parseInt(number));
        // Act
        double result = obj.calcSinus(op);
        // Assert
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void sinusWithSpacesBetweenParentheses() throws Exception {
        // Arrange
        String number = "5";
        String op = "sin(  " + number +  "      )";
        double expected = Math.sin(Integer.parseInt(number));
        // Act
        double result = obj.calcSinus(op);
        // Assert
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void sinusWithoutLeadingZero() throws IllegalArgumentException {
        // Arrange
        String number = "01";
        String op = "sin(  " + number +  "      )";
        String expectedMsg = "No valid expression: " + op;
        // Act
        Exception result = assertThrows(IllegalArgumentException.class, () -> obj.calcSinus(op));
        String resultMessage = result.getMessage();
        // Assert
        assertTrue(resultMessage.contains(expectedMsg));
    }

    @Test
    public void sinusWithOneZero() throws Exception {
        // Arrange
        String number = "0";
        String op = "sin(" + number +  "    )";
        double expected = Math.sin(Integer.parseInt(number));
        // Act
        double result = obj.calcSinus(op);
        // Assert
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(expected));
    }
}
