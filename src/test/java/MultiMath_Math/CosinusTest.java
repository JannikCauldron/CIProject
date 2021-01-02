package MultiMath_Math;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CosinusTest {
    Cosinus obj;

    @BeforeEach
    void setUp() throws Exception {
        obj = new Cosinus();
    }

    @Test
    public void cosinusWithOneIntegerTest() {
        // Arrange
        String number = "5";
        String op = "cos(" + number + ")";
        double expected = Math.cos(Integer.parseInt(number));
        // Act
        double result = obj.calcCosinus(op);
        // Assert
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void cosinusWithAnyIntegerTest() {
        // Arrange
        String number = "15";
        String op = "cos(" + number + ")";
        double expected = Math.cos(Integer.parseInt(number));
        // Act
        double result = obj.calcCosinus(op);
        // Assert
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void cosinusWithSpacesBetweenParenthesesTest() {
        // Arrange
        String number = "15";
        String op = "cos(    " + number + "    )";
        double expected = Math.cos(Integer.parseInt(number));
        // Act
        double result = obj.calcCosinus(op);
        // Assert
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void cosinusWrongExpressionTest() {
        // Arrange
        String number = "1a";
        String op = "cos(    " + number + "    )";
        String expectedMsg = "Error in cosinus expression";
        // Act
        Exception result = assertThrows(IllegalArgumentException.class, () -> obj.calcCosinus(op));
        String resultMsg = result.getMessage();
        // Assert
        assertTrue(resultMsg.contentEquals(expectedMsg));
    }
}
