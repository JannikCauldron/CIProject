package MultiMath_Math;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class SquareRootTest {
    SquareRoot squareRoot;

    @BeforeEach
    void setUp() throws Exception {
        squareRoot = new SquareRoot();
    }

    @Test
    public void rootTest() throws Exception {
        // Arrange
        String operation = "sqrt(9)";
        double expected = Math.sqrt(9);
        // Act
        double result = squareRoot.rooted(operation);
        // Assert
        assertThat("wrong root", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void rootWithSpace() throws Exception {
        // Arrange
        String operation = "sqrt(   9  )";
        double expected = Math.sqrt(9);
        // Act
        double result = squareRoot.rooted(operation);
        // Assert
        assertThat("wrong root with space", result, CoreMatchers.equalTo(expected));
    }
}
