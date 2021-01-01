package MultiMath_Math;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class PowerTest {
    Power pow;

    @BeforeEach
    void setUp() throws Exception {
        pow = new Power();
    }

    @Test
    public void exponentiateTest() throws Exception {
        //Arrange
        String operation = "3 ^ 2";
        double expected = Math.pow(3, 2);
        //Act
        double result = pow.exponentiate(operation);
        //Assert
        assertThat("wrong power", result, CoreMatchers.equalTo(expected));
    }

    @Test
    public void powerWithoutSpace() {
        // Arrange
        String operation = "3^2";
        double expected = 9;
        // Act
        double result = pow.exponentiate(operation);
        // Assert
        assertThat("wrong power without spaces", result, CoreMatchers.equalTo(expected));
    }
}
