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
        double expectedResult = 5;
        //act
        double result = calc.operate(operation);
        //assert
        assertThat("result of simple addition '" + operation + "' is wrong", result, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void simpleAdditionWithoutSpaces() {
        //arrange
        String operation = "3+2";
        double expectedResult = 5;
        //act
        double result = calc.operate(operation);
        //assert
        assertThat("result of simple addition without spaces '" + operation + "' is wrong", result, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void multipleSimpleAdditions() {
        //arrange
        String operation = "3 + 2 + 8";
        double expectedResult = 13;
        //act
        double result = calc.operate(operation);
        //assert
        assertThat("result of multiple simple additions '" + operation + "' is wrong", result, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void simpleAdditionWithLargerNumbers() {
        //arrange
        String operation = "13 + 12";
        double expectedResult = 25;
        //act
        double result = calc.operate(operation);
        //assert
        assertThat("result of simple addition with larger numbers '" + operation + "' is wrong", result, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void simpleAdditionWithDoubles() {
        //arrange
        String operation = "5.7 + 24.2";
        double expectedResult = 29.9;
        //act
        double result = calc.operate(operation);
        //assert
        assertThat("result of simple addition with larger numbers '" + operation + "' is wrong", result, CoreMatchers.equalTo(expectedResult));
    }
}
