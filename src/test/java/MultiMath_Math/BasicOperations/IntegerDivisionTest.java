package MultiMath_Math.BasicOperations;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntegerDivisionTest {
    IntegerDivision integerDivision;

    @BeforeEach
    void SetUp() throws Exception {
        integerDivision = new IntegerDivision();
    }

    @Test
    public void intDivisionTest() throws Exception {
        //Arrange
        String operation = "div(7,3)";
        int expected = 7 / 3;
        //Act
        int result = integerDivision.div(operation);
        //Assert
        MatcherAssert.assertThat("wrong integer division", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void intDivisionWithSpaceTest() throws Exception {
        //Arrange
        String operation = "div ( 7  , 3    )";
        int expected = 2;
        //Act
        int result = 7 / 3;
        //Assert
        MatcherAssert.assertThat("wrong integer division with space", result, CoreMatchers.equalTo(expected));
    }
}
