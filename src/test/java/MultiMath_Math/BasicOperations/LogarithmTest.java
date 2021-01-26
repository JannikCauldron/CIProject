package MultiMath_Math.BasicOperations;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LogarithmTest {
    Logarithm logarithm;

    @BeforeEach
    void setUp() throws Exception {
        logarithm = new Logarithm();
    }

    @Test
    public void logTest() throws Exception {
        //Arrange
        String operation = "log(5)";
        double expected = Math.log(5);
        //Act
        double result = logarithm.log(operation);
        //Assert
        MatcherAssert.assertThat("wrong logarithm", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void logWithSpaceTest() throws Exception {
        //Arrange
        String operation = "log   ( 5  )";
        double expected = Math.log(5);
        //Act
        double result = logarithm.log(operation);
        //Assert
        MatcherAssert.assertThat("wrong logarithm with space", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void logWithNegativeTest() throws Exception {
        //Arrange
        String operation = "log(-3)";
        Exception expected = assertThrows(IllegalArgumentException.class, () -> logarithm.log(operation));
        String expectedMessage = "no valid logarithm expression: " + operation;
        //Act
        String resultMessage = expected.getMessage();
        //Assert
        assertTrue(resultMessage.contentEquals(expectedMessage));
    }

    @Test
    public void logWithLeadingZeroTest() throws Exception {
        //Arrange
        String operation = "log(05)";
        Exception expected = assertThrows(IllegalArgumentException.class, () -> logarithm.log(operation));
        String expectedMessage = "no valid logarithm expression: " + operation;
        //Act
        String resultMessage = expected.getMessage();
        //Assert
        assertTrue(resultMessage.contentEquals(expectedMessage));
    }

    @Test
    public void logWithZeroTest() throws Exception {
        //Arrange
        String operation = "log(0)";
        double expected = Math.log(0);
        //Act
        double result = logarithm.log(operation);
        //Assert
        MatcherAssert.assertThat("wrong logarithm", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void logWithDecimalTest() throws Exception {
        //Arrange
        String operation = "log(0.7)";
        double expected = Math.log(0.7);
        //Act
        double result = logarithm.log(operation);
        //Assert
        MatcherAssert.assertThat("wrong logarithm of decimal", result, CoreMatchers.equalTo(expected));
    }
}
