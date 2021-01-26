package MultiMath_Math.BasicOperations;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertThat;
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
        assertThat("wrong logaritm", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void logWithSpace() throws Exception {
        //Arrange
        String operation = "log   ( 5  )";
        double expected = Math.log(5);
        //Act
        double result = logarithm.log(operation);
        //Assert
        assertThat("wrong logarithm with space", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void logWithNegative() throws Exception {
        //Arrange
        String operation = "log(-3)";
        Exception expected = assertThrows(IllegalArgumentException.class, () -> {logarithm.log(operation);});
        String expectedMessage = "no valid logarithm expression: " + operation;
        //Act
        //double result = logarithm.log(operation);
        String actualMessage = expected.getMessage();
        //Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void logWithLeadingZero() throws Exception {
        //Arrange
        String operation = "log(05)";
        Exception expected = assertThrows(IllegalArgumentException.class, () -> {logarithm.log(operation);});
        String expectedMessage = "no valid logarithm expression: " + operation;
        //Act
        String actualMessage = expected.getMessage();
        //Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
