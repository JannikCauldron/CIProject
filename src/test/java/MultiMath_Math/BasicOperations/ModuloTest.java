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
}
