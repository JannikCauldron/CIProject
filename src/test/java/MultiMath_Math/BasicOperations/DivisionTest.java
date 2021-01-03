package MultiMath_Math.BasicOperations;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

public class DivisionTest {


    @Test
    public void doubleMultiplicationTest() throws Exception {
        // Arrange
        double[][] divArray = {{5d, 2d},         // with decimals
                {50d, 2d, 5d, 5d},    // without decimals
                {0.05, 1000},                 // division below 4 decimals and round half_up
                {7531, 73},                       // ###.####
                {-0.001d, 0.03d}};                    // periodic number 0.033333333
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
}
