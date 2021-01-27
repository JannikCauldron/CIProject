package MultiMath_Math.Precedence;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        String actualResult = detector.detect(operation)[0];
        //assert
        assertThat("Erkennung von " + operation + " wurde fehlerhaft erkannt als " + actualResult, actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void twoBracketsDetection() {
        //arrange
        String operation = "((2 + 5) * 8)";
        String[] expectedResult = new String[] {"2 + 5", " * 8"};
        //act
        String[] actualResult = detector.detect(operation);
        //assert
        assertThat("Erkennung von " + operation + " wurde fehlerhaft erkannt als " + Arrays.toString(actualResult), actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void severalBracketsDetection() {
        //arrange
        String operation = "(34 / ((2 + 5) * 8))";
        String[] expectedResult = new String[] {"2 + 5", " * 8", "34 / "};
        //act
        String[] actualResult = detector.detect(operation);
        //assert
        assertThat("Erkennung von " + operation + " wurde fehlerhaft erkannt als " + Arrays.toString(actualResult), actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void severalBracketsWithMissingOuterBracketDetection() {
        //arrange
        String operation = "12 * (2 - 7)";
        String[] expectedResult = new String[] {"2 - 7", "12 * "};
        //act
        String[] actualResult = detector.detect(operation);
        //assert
        assertThat("Erkennung von " + operation + " wurde fehlerhaft erkannt als " + Arrays.toString(actualResult), actualResult, CoreMatchers.equalTo(expectedResult));
    }

    @Test
    void bracketsWithMissingOuterBracketAndNumbersOnRightDetection() {
        //arrange
        String operation = "(2 - 7) * 4 + 2";
        String[] expectedResult = new String[] {"2 - 7", " * 4 + 2"};
        //act
        String[] actualResult = detector.detect(operation);
        //assert
        assertThat("Erkennung von " + operation + " wurde fehlerhaft erkannt als " + Arrays.toString(actualResult), actualResult, CoreMatchers.equalTo(expectedResult));
    }
}
