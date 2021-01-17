package MultiMath_Math.BasicOperations;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

public class NumerologyTest {

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
    public void isOddTest() {
        // Arrange
        int[] operations = {0, 1, 2, 3, 11, 12, 999998};
        boolean[] expected = {false, true, false, true, true, false, false};
        boolean[] results = new boolean[expected.length];
        // Act
        for (int i = 0; i < expected.length; i++) {
            results[i] = Numerology.isOdd(operations[i]);
        }
        // Assert
        MatcherAssert.assertThat("Is Odd Test", results, CoreMatchers.equalTo(expected));
    }
}
