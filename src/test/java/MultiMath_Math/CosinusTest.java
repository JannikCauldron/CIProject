package MultiMath_Math;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
