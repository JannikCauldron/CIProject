package MultiMath_Math.Precedence;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThat;

public class BracketDetectTest {
    BracketDetect detector;

    @BeforeEach
    void setUp() throws Exception {
        detector = new BracketDetect();
    }

    @Test
    void simpleBracketDetection() {
        //arrange
        String operation = "(2 + 5)";
        String expectedResult = "2 + 5";
        //act
        String actualResult = detector.detect(operation);
        //assert
        assertThat("Erkennung von " + operation + " wurde fehlerhaft erkannt als " + actualResult, actualResult, CoreMatchers.equalTo(expectedResult));
    }
}
