package MultiMath_Math.BasicOperations;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertThat;

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
        double expected = Math.log(-3);
        //Act
        double result = logarithm.log(operation);
        //Assert
        assertThat("no logarithm of negatives", result, CoreMatchers.equalTo(expected));
    }
}
