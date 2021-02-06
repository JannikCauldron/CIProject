package MultiMath_Math.BasicOperations;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ArcusCosinusTest {
    ArcusCosinus obj;

    @BeforeEach
    void setUp() throws Exception {
        obj = new ArcusCosinus();
    }

    @Test
    public void arcusCosinusWithOnePositiveDigitInExpression() throws Exception {
        // Arrange
        String arcusCosinusNumberInExpression = "5";
        String arcusCosinusUserInput = "arccos(" + arcusCosinusNumberInExpression + ")";
        double expectedResult = Math.acos(Double.parseDouble(arcusCosinusNumberInExpression));

        // Act
        double actualResult = obj.processArcusCosinusExpression(arcusCosinusUserInput);

        // Assert
        MatcherAssert.assertThat("result", actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    public void arcusCosinusWithAnyPositiveDigitInExpression() throws Exception {
        // Arrange
        String arcusCosinusNumberInExpression = "15";
        String arcusCosinusUserInput = "arccos(" + arcusCosinusNumberInExpression + ")";
        double expectedResult = Math.acos(Double.parseDouble(arcusCosinusNumberInExpression));

        // Act
        double actualResult = obj.processArcusCosinusExpression(arcusCosinusUserInput);

        // Assert
        MatcherAssert.assertThat("result", actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    public void arcusCosinusWithSpacesBetweenParentheses() throws Exception {
        // Arrange
        String arcusCosinusNumberInExpression = "15";
        String arcusCosinusUserInput = "arccos(  " + arcusCosinusNumberInExpression + "  )";
        double expectedResult = Math.acos(Double.parseDouble(arcusCosinusNumberInExpression));

        // Act
        double actualResult = obj.processArcusCosinusExpression(arcusCosinusUserInput);

        // Assert
        MatcherAssert.assertThat("result", actualResult, CoreMatchers.equalTo(expectedResult));
    }

    
}
