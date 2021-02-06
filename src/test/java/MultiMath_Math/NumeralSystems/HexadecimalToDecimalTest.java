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
        String hex = "7";
        int expectedResult = 7;

        //act
        int actualResult = converter.convert(hex);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_hexC_to_dec() {
        //arrange
        String hex = "c";
        int expectedResult = 12;

        //act
        int actualResult = converter.convert(hex);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void test_case_neutrality() {
        //arrange
        String hex = "C";
        int expectedResult = 12;

        //act
        int actualResult = converter.convert(hex);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_hex10_to_dec() {
        //arrange
        String hex = "10";
        int expectedResult = 16;

        //act
        int actualResult = converter.convert(hex);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_hex1f4a9_to_dec() {
        //arrange
        String hex = "1f4a9";
        int expectedResult = 128169;

        //act
        int actualResult = converter.convert(hex);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }
}