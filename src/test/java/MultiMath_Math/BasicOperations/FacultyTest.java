package MultiMath_Math.BasicOperations;

import MultiMath_Math.BasicOperations.Faculty;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

public class FacultyTest {
    Faculty obj;

    @BeforeEach
    void setUp() {
        obj = new Faculty();
    }

    @Test
    void faculty5Test() {
        // Arrange
        String operation = "5!";
        int expected = 120;

        // Act
        int result = obj.faculty(operation);

        // Assert
        assertThat(result, CoreMatchers.equalTo(expected));
    }

    @Test
    void faculty0Test() {
        // Arrange
        String operation = "0!";
        int expected = 1;

        // Act
        int result = obj.faculty(operation);

        // Assert
        assertThat(result, CoreMatchers.equalTo(expected));
    }

    @Test
    void faculty1Test() {
        // Arrange
        String operation = "1!";
        int expected = 1;

        // Act
        int result = obj.faculty(operation);

        // Assert
        assertThat(result, CoreMatchers.equalTo(expected));
    }

    @Test
    void facultyMultiDigitTest() {
        // Arrange
        String operation = "10!";
        int expected = 3628800;

        // Act
        int result = obj.faculty(operation);

        // Assert
        assertThat(result, CoreMatchers.equalTo(expected));
    }
}
