package MultiMath_Math;

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
}
