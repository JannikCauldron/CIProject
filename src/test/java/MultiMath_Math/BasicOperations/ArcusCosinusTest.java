package MultiMath_Math.BasicOperations;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class ArcusCosinusTest {
    ArcusCosinus obj;

    @BeforeEach
    void setUp() throws Exception {
        obj = new ArcusCosinus();
    }

    @Test
    public void arcusCosinusWithOnePositiveDigitInExpression() throws Exception {
        // Arrange
        String num = "5";
        String op = "arccos(" + num + ")";
        double expect = Math.acos(Double.parseDouble(num));

        // Act
        double res = obj.calcArcCos(op);

        // Assert
        MatcherAssert.assertThat("result", res, CoreMatchers.equalTo(expect));
    }
}
