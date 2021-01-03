package MultiMath_Math.BasicOperations;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MultiplicationTest {


    @Test
    public void integerMultiplicationTest() throws Exception {
        // Arrange
        int[][] factorsArray =  {   {3,5},                      // 2 factors
                                    {3,5,2},                    // 3 factors
                                    {2,3,3,7,11,31,151,331},    // int max length -1
                                    {0,1}   };
        int[] expectedProductArray =  { 15, 30, 2147483646, 0 };
        // Act
        int ArrayLength = factorsArray.length;
        int[] resultArray = new int[ArrayLength];
        for(int i = 0; i < ArrayLength; i++) {
            resultArray[i] = Multiplication.multiply(factorsArray[i]);
        }
        // Assert
        MatcherAssert.assertThat("Integer Multiplication Test:", resultArray, CoreMatchers.equalTo(expectedProductArray));
    }



}
