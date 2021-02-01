package MultiMath_Math.NumeralSystems;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DecimalToOctalTest {
    private DecimalToOctal converter;

    @BeforeEach
    void setUp() {
        converter = new DecimalToOctal();
    }

    @Test
    void convert_dec7_to_oct() throws Exception {
        //arrange
        int decimal = 7;
        String expectedResult = "7";

        //act
        String actualResult = converter.convert(decimal);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_dec14_to_oct() throws Exception {
        //arrange
        int decimal = 14;
        String expectedResult = "16";

        //act
        String actualResult = converter.convert(decimal);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_dec133337_to_oct() throws Exception {
        //arrange
        int decimal = 133337;
        String expectedResult = "404331";

        //act
        String actualResult = converter.convert(decimal);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_dec0_to_oct() throws Exception {
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
        int decimal = -11;
        String expectedMessage = "No conversion of negative values!";

        //act
        String actualMessage = assertThrows(Exception.class, () -> converter.convert(decimal)).getMessage();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void convert_baseValue() throws Exception {
        //arrange
        int decimal = 8;
        String expectedResult = "10";

        //act
        String actualResult = converter.convert(decimal);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }
}