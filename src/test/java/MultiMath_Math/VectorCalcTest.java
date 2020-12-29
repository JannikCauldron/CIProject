package MultiMath_Math;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;


class VectorCalcTest {
  VectorCalc obj;


  @BeforeEach
  void setUp() {
    obj = new VectorCalc();
  }


  @Test
  void vecAddTest(){
    // Arrange
    int[] v1 = {1, 1, 1};
    int[] v2 = {1, 1, 1};
    int[] expected = {2, 2, 2};

    // Act
    int[] result = obj.vecAdd(v1, v2);

    // Assert
    assertThat("testing vector add", result, CoreMatchers.equalTo(expected));

  }
}