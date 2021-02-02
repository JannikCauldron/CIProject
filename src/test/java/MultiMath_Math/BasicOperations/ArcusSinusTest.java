package MultiMath_Math.BasicOperations;

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
         String number = "5";
         String operation = "arcsin(" + number + ")";
         double expected = Math.asin(Double.parseDouble(number));
 
         // Act
         double result = obj.processArcSinExpression(operation);
 
         // Assert
         MatcherAssert.assertThat("result", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void arcussinusWithAnyPositiveDigitNumber() {
         // Arrange
         String number = "15";
         String operation = "arcsin(" + number + ")";
         double expected = Math.asin(Double.parseDouble(number));
 
         // Act
         double result = obj.processArcSinExpression(operation);
 
         // Assert
         MatcherAssert.assertThat("result", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void arcussinusWithSpacesBetweenParentheses() {
         // Arrange
         String number = "15";
         String operation = "arcsin(  " + number + "  )";
         double expected = Math.asin(Double.parseDouble(number));
 
         // Act
         double result = obj.processArcSinExpression(operation);
 
         // Assert
         MatcherAssert.assertThat("result", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void arcussinusWithAnyNegativeDigitNumber() {
         // Arrange
         String number = "-15";
         String operation = "arcsin(" + number + ")";
         double expected = Math.asin(Double.parseDouble(number));
 
         // Act
         double result = obj.processArcSinExpression(operation);
 
         // Assert
         MatcherAssert.assertThat("result", result, CoreMatchers.equalTo(expected));
    }
}
