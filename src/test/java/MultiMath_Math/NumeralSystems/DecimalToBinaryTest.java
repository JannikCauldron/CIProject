package MultiMath_Math.NumeralSystems;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;

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
}
