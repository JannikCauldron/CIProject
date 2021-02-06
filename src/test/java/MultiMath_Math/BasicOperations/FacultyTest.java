package MultiMath_Math.BasicOperations;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FacultyTest {
    Faculty obj;

    @BeforeEach
    void setUp() {
        obj = new Faculty();
    }

    @Test
    void faculty5Test() throws Exception {
        // Arrange
        String operation = "5!";
        int expected = 120;

        // Act
        int result = obj.faculty(operation);

        // Assert
        assertThat(result, CoreMatchers.equalTo(expected));
    }

    @Test
    void faculty0Test() throws Exception {
        // Arrange
        String operation = "0!";
        int expected = 1;

        // Act
        int result = obj.faculty(operation);

        // Assert
        assertThat(result, CoreMatchers.equalTo(expected));
    }

    @Test
    void faculty1Test() throws Exception {
        // Arrange
        String operation = "1!";
        int expected = 1;

        // Act
        int result = obj.faculty(operation);

        // Assert
        assertThat(result, CoreMatchers.equalTo(expected));
    }

    @Test
    void facultyMultiDigitTest() throws Exception {
        // Arrange
        String operation = "10!";
        int expected = 3628800;

        // Act
        int result = obj.faculty(operation);

        // Assert
        assertThat(result, CoreMatchers.equalTo(expected));
    }

    @Test
    void facultyOverflowTest() {
        // Arrange
        String operation = "100!";
        String expectedMessage = "Overflow!";

        // Act
        String actualMessage = assertThrows(Exception.class, () -> obj.faculty(operation)).getMessage();

        // Assert
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
