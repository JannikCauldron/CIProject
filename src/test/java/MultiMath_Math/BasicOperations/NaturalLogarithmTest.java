package MultiMath_Math.BasicOperations;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NaturalLogarithmTest {
    NaturalLogarithm naturalLogarithm;

    @BeforeEach
    void setUp() throws Exception {
        naturalLogarithm = new NaturalLogarithm();
    }

    @Test
    public void lognTest() throws Exception {
        //Arrange
        String operation = "logn(5)";
        double expected = Math.log(5);
        //Act
        double result = naturalLogarithm.logn(operation);
        //Assert
        MatcherAssert.assertThat("wrong natural logarithm", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void lognWithSpaceTest() throws Exception {
        //Arrange
        String operation = "logn   ( 5  )";
        double expected = Math.log(5);
        //Act
        double result = naturalLogarithm.logn(operation);
        //Assert
        MatcherAssert.assertThat("wrong natural logarithm with space", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void lognWithNegativeTest() throws Exception {
        //Arrange
        String operation = "logn(-3)";
        Exception expected = assertThrows(IllegalArgumentException.class, () -> naturalLogarithm.logn(operation));
        String expectedMessage = "no valid natural logarithm expression: " + operation;
        //Act
        String resultMessage = expected.getMessage();
        //Assert
        assertTrue(resultMessage.contentEquals(expectedMessage));
    }

    @Test
    public void lognWithLeadingZeroTest() throws Exception {
        //Arrange
        String operation = "logn(05)";
        Exception expected = assertThrows(IllegalArgumentException.class, () -> naturalLogarithm.logn(operation));
        String expectedMessage = "no valid natural logarithm expression: " + operation;
        //Act
        String resultMessage = expected.getMessage();
        //Assert
        assertTrue(resultMessage.contentEquals(expectedMessage));
    }

    @Test
    public void lognWithZeroTest() throws Exception {
        //Arrange
        String operation = "logn(0)";
        double expected = Math.log(0);
        //Act
        double result = naturalLogarithm.logn(operation);
        //Assert
        MatcherAssert.assertThat("wrong natural logarithm", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void lognWithDecimalTest() throws Exception {
        //Arrange
        String operation = "logn(0.7)";
        double expected = Math.log(0.7);
        //Act
        double result = naturalLogarithm.logn(operation);
        //Assert
        MatcherAssert.assertThat("wrong natural logarithm of decimal", result, CoreMatchers.equalTo(expected));
    }
}
