package MultiMath_Math.NumeralSystems;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HexadecimalToDecimalTest {
    HexadecimalToDecimal converter;

    @BeforeEach
    void setUp() {
        converter = new HexadecimalToDecimal();
    }

    @Test
    void convert_hex7_to_dec() throws Exception {
        //arrange
        String hex = "7";
        int expectedResult = 7;

        //act
        int actualResult = converter.convert(hex);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_hexC_to_dec() throws Exception {
        //arrange
        String hex = "c";
        int expectedResult = 12;

        //act
        int actualResult = converter.convert(hex);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void test_case_neutrality() throws Exception {
        //arrange
        String hex = "C";
        int expectedResult = 12;

        //act
        int actualResult = converter.convert(hex);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_hex10_to_dec() throws Exception {
        //arrange
        String hex = "10";
        int expectedResult = 16;

        //act
        int actualResult = converter.convert(hex);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_hex1f4a9_to_dec() throws Exception {
        //arrange
        String hex = "1f4a9";
        int expectedResult = 128169;

        //act
        int actualResult = converter.convert(hex);

        //assert
        assertThat(actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void convert_invalidValue() {
        //arrange
        String hex = "0123EinTest4567";
        String expectedMessage = "Input was no hexadecimal String!";

        //act
        String actualMessage = assertThrows(Exception.class, () -> converter.convert(hex)).getMessage();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }
}