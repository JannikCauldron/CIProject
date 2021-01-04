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
        int expectedResult = 9;
        //act
        int actualResult = sub.operate(operation);
        //assert
        assertThat("simpleSubtraction went wrong", actualResult, CoreMatchers.equalTo(expectedResult));
    }
}
