package MultiMath_Math.NumeralSystems;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;

class DecimalToHexadecimalTest {
    DecimalToHexadecimal converter;

    @BeforeEach
    void setUp() {
        converter = new DecimalToHexadecimal();
    }

    @Test
    void convert_dec7_to_hex() {
        //arrange
        int operation = 7;
        int expectedResult = 7;

        //act
        int actualResult = converter.convert(operation);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }
}