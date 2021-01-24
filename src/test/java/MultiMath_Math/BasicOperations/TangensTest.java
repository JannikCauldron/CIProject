package MultiMath_Math.BasicOperations;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

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
}
