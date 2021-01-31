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
        int decimal = 7;
        String expectedResult = "7";

        //act
        String actualResult = converter.convert(decimal);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_dec11_to_hex() {
        //arrange
        int decimal = 11;
        String expectedResult = "b";

        //act
        String actualResult = converter.convert(decimal);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_dec20_to_hex() {
        //arrange
        int decimal = 20;
        String expectedResult = "14";

        //act
        String actualResult = converter.convert(decimal);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }
}