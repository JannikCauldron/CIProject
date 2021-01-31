package MultiMath_Math.NumeralSystems;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;

class DecimalToOctalTest {
    DecimalToOctal converter;

    @BeforeEach
    void setUp() {
        converter = new DecimalToOctal();
    }

    @Test
    void convert_dec7_to_oct() {
        //arrange
        int decimal = 7;
        String expectedResult = "7";

        //act
        String actualResult = converter.convert(decimal);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_dec14_to_oct() {
        //arrange
        int decimal = 14;
        String expectedResult = "16";

        //act
        String actualResult = converter.convert(decimal);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_dec133337_to_oct() {
        //arrange
        int decimal = 133337;
        String expectedResult = "404331";

        //act
        String actualResult = converter.convert(decimal);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }
}