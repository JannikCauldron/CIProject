package MultiMath_Math.NumeralSystems;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DecimalToHexadecimalTest {
    DecimalToHexadecimal converter;

    @BeforeEach
    void setUp() {
        converter = new DecimalToHexadecimal();
    }

    @Test
    void convert_dec7_to_hex() throws Exception {
        //arrange
        int decimal = 7;
        String expectedResult = "7";

        //act
        String actualResult = converter.convert(decimal);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_dec11_to_hex() throws Exception {
        //arrange
        int decimal = 11;
        String expectedResult = "b";

        //act
        String actualResult = converter.convert(decimal);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_dec20_to_hex() throws Exception {
        //arrange
        int decimal = 20;
        String expectedResult = "14";

        //act
        String actualResult = converter.convert(decimal);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_dec420_to_hex() throws Exception {
        //arrange
        int decimal = 420;
        String expectedResult = "1a4";

        //act
        String actualResult = converter.convert(decimal);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_dec0_to_hex() throws Exception {
        //arrange
        int decimal = 0;
        String expectedResult = "0";

        //act
        String actualResult = converter.convert(decimal);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_negativeValue() {
        //arrange
        int decimal = -10;
        String expectedMessage = "No conversion of negative values!";

        //act
        String actualMessage = assertThrows(Exception.class, () -> converter.convert(decimal)).getMessage();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void convert_baseValue() throws Exception {
        //arrange
        int decimal = 16;
        String expectedResult = "10";

        //act
        String actualResult = converter.convert(decimal);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }
}