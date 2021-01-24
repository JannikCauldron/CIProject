package MultiMath_Math.NumeralSystems;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;

public class DecimalToBinaryTest {
    DecimalToBinary conv;

    @BeforeEach
    void setUp() throws Exception {
        conv = new DecimalToBinary();
    }

    @Test
    void simpleDecimalToBinaryConversion() {
        //arrange
        String operation = "bin(2)";
        int expectedResult = 10;
        //act
        int actualResult = conv.operate(operation);
        //assert
        assertThat("Umwandlung: " + operation + " wurde fehlerhaft zu: " + actualResult, actualResult, CoreMatchers.equalTo(expectedResult));
    }
}
