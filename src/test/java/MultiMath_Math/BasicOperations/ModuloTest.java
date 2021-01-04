package MultiMath_Math.BasicOperations;

import org.hamcrest.CoreMatchers;
import static org.junit.Assert.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ModuloTest {
    Modulo modulo;

    @BeforeEach
    void setUp() throws Exception {
        modulo = new Modulo();
    }

    @Test
    public void moduloTest() throws Exception{
        // Arrange
        String operation = "3 % 2";
        double expected = 3 % 2;
        // Act
        double result = modulo.moduloOp(operation);
        // Assert
        assertThat("wrong modulo", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void moduloWithoutSpaceTest() throws Exception{
        // Arrange
        String operation = "3%2";
        double expected = 1;
        // Act
        double result = modulo.moduloOp(operation);
        // Assert
        assertThat("wrong modulo with spaces", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void moduloMoreThanOneDigitTest() throws Exception{
        // Arrange
        String operation = "13 % 10";
        double expected = 13%10;
        // Act
        double result = modulo.moduloOp(operation);
        // Assert
        assertThat("wrong modulo for numbers bigger than one digit", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void moduloNumbersDifferentLengthTest() throws Exception{
        // Arrange
        String operation = "10%3";
        double expected = 10%3;
        // Act
        double result = modulo.moduloOp(operation);
        // Assert
        assertThat("wrong modulo for numbers with different length", result, CoreMatchers.equalTo(expected));
    }
}
