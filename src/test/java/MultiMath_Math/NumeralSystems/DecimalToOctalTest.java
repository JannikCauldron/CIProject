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
        int expectedResult = 7;

        //act
        int actualResult = converter.convert(decimal);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }
}