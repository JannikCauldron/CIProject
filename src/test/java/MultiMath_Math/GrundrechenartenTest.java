package MultiMath_Math;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;


public class GrundrechenartenTest {
    Grundrechenarten obj;

    @BeforeEach
    void setUp() throws Exception {
        obj = new Grundrechenarten();
    }

    @Test
    public void sinusWithIntegerTest() throws Exception {
        // Arrange
        String number = "5";
        String op = "sin(" + number + ")";
        double expected = Math.sin(Integer.parseInt(number));
        // Act
        double result = obj.calcSinus(op);
        // Assert
        MatcherAssert.assertThat(result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void sinusWithSpacesBetweenParentheses() throws Exception {
        // Arrange
        String number = "5";
        String op = "sin(  " + number +  "      )";
        double expected = Math.sin(Integer.parseInt(number));
        // Act
        double result = obj.calcSinus(op);
        // Assert
        assertThat(result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void sinusWithoutLeadingZero() throws IllegalArgumentException {
        // Arrange
        String number = "01";
        String op = "sin(  " + number +  "      )";
        Exception expected = assertThrows(IllegalArgumentException.class, () -> {
            obj.calcSinus(op);
        });
        String expectedMsg = "No valid expression: " + op;
        // Act
        //double result = obj.calcSinus(op);
        String actualMsg = expected.getMessage();
        // Assert
        assertTrue(actualMsg.contains(expectedMsg));
    }
}
