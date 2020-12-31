package MultiMath_Math;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;

class CalculatorTest {
    Calculator calc;

    @BeforeEach
    void setUp() throws Exception {
        calc = new Calculator();
    }

    @Test
    void simpleAddition() {
        //arrange
        String operation = "3 + 2";
        int expectedResult = 5;
        //act
        int result = calc.operate(operation);
        //assert
        assertThat("simpleAddition Result", result, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void simpleAdditionWithoutSpaces() {
        //arrange
        String operation = "3+2";
        int expectedResult = 5;
        //act
        int result = calc.operate(operation);
        //assert
        assertThat("simpleAdditionWithoutSpaces Result", result, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void multipleSimpleAdditions() {
        //arrange
        String operation = "3 + 2 + 8";
        int expectedResult = 13;
        //act
        int result = calc.operate(operation);
        //assert
        assertThat("multipleSimpleAdditions Result", result, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void simpleAdditionWithBiggerNumbers() {
        //arrange
        String operation = "13 + 12";
        int expectedResult = 25;
        //act
        int result = calc.operate(operation);
        //assert
        assertThat("simpleAdditionWithBiggerNumbers Result", result, CoreMatchers.equalTo(expectedResult));
    }
}
