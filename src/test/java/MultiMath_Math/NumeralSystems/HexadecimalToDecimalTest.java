package MultiMath_Math.NumeralSystems;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;

class HexadecimalToDecimalTest {
    HexadecimalToDecimal converter;

    @BeforeEach
    void setUp() {
        converter = new HexadecimalToDecimal();
    }

    @Test
    void convert_hex7_to_dec() {
        //arrange
        String in = "7";
        int expectedResult = 7;

        //act
        int actualResult = converter.convert(in);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }
}