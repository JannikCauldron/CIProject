package MultiMath_Math.NumeralSystems;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class DecimalToBinaryTest {
    DecimalToBinary numberConverter;

    @BeforeEach
    void setUp() throws Exception {
        numberConverter = new DecimalToBinary();
    }

    @Test
    void simpleDecimalToBinaryConversion() {
        //arrange
        String operation = "bin(2)";
        String expectedResult = "10";
        //act
        String actualResult = numberConverter.operate(operation);
        //assert
        assertThat("Umwandlung: " + operation + " wurde fehlerhaft zu: " + actualResult, actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void biggerDecimalToBinaryConversion() {
        //arrange
        String operation = "bin(5326789)";
        String expectedResult = "10100010100011111000101";
        //act
        String actualResult = numberConverter.operate(operation);
        //assert
        assertThat("Umwandlung: " + operation + " wurde fehlerhaft zu: " + actualResult, actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void decimalToBinaryConversionWithWrongInput() {
        //arrange
        String operation = "bin(43fe)";
        String expectedResult = "Invalid input for conversion";
        //act
        Exception result = assertThrows(IllegalArgumentException.class, () -> numberConverter.operate(operation));
        String actualResult = result.getMessage();
        //assert
        assertTrue(actualResult.contentEquals(expectedResult));
    }

    @Test
    void negativeDecimalToBinaryConversion() {
        //arrange
        String operation = "bin(-23)";
        String expectedResult = "101000";
        //act
        String actualResult = numberConverter.operate(operation);
        //assert
        assertThat("Umwandlung: " + operation + " wurde fehlerhaft zu: " + actualResult, actualResult, CoreMatchers.equalTo(expectedResult));
    }
}
