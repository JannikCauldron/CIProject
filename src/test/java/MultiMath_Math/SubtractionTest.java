package MultiMath_Math;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;

class SubtractionTest {
    Subtraction sub;

    @BeforeEach
    void setUp() throws Exception {
        sub = new Subtraction();
    }

    @Test
    void simpleSubtraction() {
        //arrange
        String operation = "17 - 8";
        double expectedResult = 9;
        //act
        double actualResult = sub.operate(operation);
        //assert
        assertThat("simpleSubtraction went wrong - operation '" + operation + "' calculated to " + actualResult,
                actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void multipleSimpleSubtraction() {
        //arrange
        String operation = "17 - 8 - 5";
        double expectedResult = 4;
        //act
        double actualResult = sub.operate(operation);
        //assert
        assertThat("multipleSimpleSubtraction went wrong - operation '" + operation + "' calculated to " + actualResult,
                actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void multipleSimpleSubtractionWithMissingSpaces() {
        //arrange
        String operation = "17 -8- 5";
        double expectedResult = 4;
        //act
        double actualResult = sub.operate(operation);
        //assert
        assertThat("multipleSimpleSubtractionWithMissingSpaces went wrong - operation '" + operation + "' calculated to " + actualResult,
                actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void simpleSubtractionWithDoubles() {
        //arrange
        String operation = "53.8 - 24.9";
        double expectedResult = 28.9;
        //act
        double actualResult = sub.operate(operation);
        //assert
        assertThat("multipleSimpleSubtractionWithMissingSpaces went wrong - operation '" + operation + "' calculated to " + actualResult,
                actualResult, CoreMatchers.equalTo(expectedResult));
    }
}
