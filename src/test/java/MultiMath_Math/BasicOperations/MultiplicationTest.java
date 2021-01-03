package MultiMath_Math.BasicOperations;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

public class MultiplicationTest {


    @Test
    public void integerMultiplicationTest() throws Exception {
        // Arrange
        int[][] factorsArray = {{3, 5},            // 2 factors
                {3, 5, 2},                         // 3 factors
                {2, 3, 3, 7, 11, 31, 151, 331},    // int max -1
                {0, 1}};                           // multiply by 0
        int[] expectedProductArray = {15, 30, 2147483646, 0};
        int ArrayLength = factorsArray.length;
        int[] resultArray = new int[ArrayLength];
        // Act
        for (int i = 0; i < ArrayLength; i++) {
            resultArray[i] = Multiplication.multiply(factorsArray[i]);
        }
        // Assert
        MatcherAssert.assertThat("Integer Multiplication Test:", resultArray, CoreMatchers.equalTo(expectedProductArray));
    }

    @Test
    public void doubleMultiplicationTest() throws Exception {
        // Arrange
        double[][] factorsArray = {{3d, 5d},         // integer range
                {2d, 3d, 3d, 7d, 11d, 31d, 151d, 332d},    // above integer range
                {3.01d, 123.0d, 5.08d},                 // double with decimal places (round decimals 4)
                {0.01d, 0.3d},                       // double with only decimals (round decimals 4)
                {0.001d, 0.03d}};                    // double with product rounds to 0.0000 (round decimals 4)
        double[] expectedProductArray = {15d, 2153971512d, 1880.7684d, 0.003d, 0.0000d};
        // Act
        int ArrayLength = factorsArray.length;
        double[] resultArray = new double[ArrayLength];
        for (int i = 0; i < ArrayLength; i++) {
            resultArray[i] = Multiplication.multiply(factorsArray[i]);
        }
        // Assert
        MatcherAssert.assertThat("Integer Multiplication Test:", resultArray, CoreMatchers.equalTo(expectedProductArray));
    }


}
