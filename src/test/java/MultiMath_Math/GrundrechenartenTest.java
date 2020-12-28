package MultiMath_Math;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class GrundrechenartenTest {
    Grundrechenarten obj;

    @BeforeEach
    void setUp() throws Exception {
        obj = new Grundrechenarten();
    }

    @Test
    public void sinusWithIntegerTest() throws Exception {
        // Arrange
        String op = "sin(5)";
        double expected = Math.sin(5);
        // Act
        double result = obj.calcSinus(op);
        // Assert
        assertThat("wrong sinus", result, CoreMatchers.equalTo(expected));
    }
}
