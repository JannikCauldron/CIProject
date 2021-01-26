package MultiMath_Math.BasicOperations;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.CoderResult;
import java.util.regex.Matcher;

public class CommonLogarithmTest {
    CommonLogarithm commonLogarithm;

    @BeforeEach
    void setUp() throws Exception {
        commonLogarithm = new CommonLogarithm();
    }

    @Test
    public void log10Test() throws Exception {
        //Arrange
        String operation = "logc(3)";
        double expected = Math.log10(3);
        //Act
        double result = commonLogarithm.logc(operation);
        //Assert
        MatcherAssert.assertThat("wrong common logarithm", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void logcWithSpaceTest() throws Exception {
        //Arrange
        String operation = "logc   (  7 )";
        double expected = Math.log10(7);
        //Act
        double result = commonLogarithm.logc(operation);
        //Assert
        MatcherAssert.assertThat("wrong common logarithm with space", result, CoreMatchers.equalTo(expected));
    }
}
