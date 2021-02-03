package MultiMath_Math.BasicOperations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArcusSinusTest {
    ArcusSinus obj;

    @BeforeEach
    void setUp() throws Exception {
        obj = new ArcusSinus();
    } 
    
    @Test
    public void arcussinusWithOneDigitPositiveInteger() {
         // Arrange
         String arcSinNumberToProcess = "5";
         String arcSinUserInput = "arcsin(" + arcSinNumberToProcess + ")";
         double expected = Math.asin(Double.parseDouble(arcSinNumberToProcess));
 
         // Act
         double result = obj.processArcSinExpression(arcSinUserInput);
 
         // Assert
         MatcherAssert.assertThat("result", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void arcussinusWithAnyPositiveDigitNumber() {
         // Arrange
         String arcSinNumberToProcess = "15";
         String arcSinUserInput = "arcsin(" + arcSinNumberToProcess + ")";
         double expected = Math.asin(Double.parseDouble(arcSinNumberToProcess));
 
         // Act
         double result = obj.processArcSinExpression(arcSinUserInput);
 
         // Assert
         MatcherAssert.assertThat("result", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void arcussinusWithSpacesBetweenParentheses() {
         // Arrange
         String arcSinNumberToProcess = "15";
         String arcSinUserInput = "arcsin(  " + arcSinNumberToProcess + "  )";
         double expected = Math.asin(Double.parseDouble(arcSinNumberToProcess));
 
         // Act
         double result = obj.processArcSinExpression(arcSinUserInput);
 
         // Assert
         MatcherAssert.assertThat("result", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void arcussinusWithAnyNegativeDigitNumber() {
         // Arrange
         String arcSinNumberToProcess = "-15";
         String arcSinUserInput = "arcsin(" + arcSinNumberToProcess + ")";
         double expected = Math.asin(Double.parseDouble(arcSinNumberToProcess));
 
         // Act
         double result = obj.processArcSinExpression(arcSinUserInput);
 
         // Assert
         MatcherAssert.assertThat("result", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void arcussinusWithWrongExpressionToGetException() {
         // Arrange
         String arcSinNumberToProcess = "5a";
         String arcSinUserInput = "arcsin(" + arcSinNumberToProcess + ")";
         String expectedExceptionMessage = "Mistake in arcus sinus expression";
 
         // Act
         Exception thrownException = assertThrows(IllegalArgumentException.class, () -> obj.processArcSinExpression(arcSinUserInput));
         String resultExceptionMessage = thrownException.getMessage();
 
         // Assert
         assertTrue(resultExceptionMessage.contains(expectedExceptionMessage));
    }
}
