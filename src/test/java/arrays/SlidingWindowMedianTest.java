package arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SlidingWindowMedianTest {
    public static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of(new int[]{1,3,-1,-3,5,3,6,7}, 3, new double[] {1.,-1.,-1.,3.,5.,6.}),
                Arguments.of(new int[]{1,2,3,4,2,3,1,4,2}, 3, new double[] {2.,3.,3.,3.,2.,3.,2.})
        );
    }

    @ParameterizedTest
    @MethodSource("testArguments")
    public void maximumWealthTest(int[] source, int k, double[] expected) {
        var actual = SlidingWindowMedian.medianSlidingWindow(source, k);

        assertThat(actual).isEqualTo(expected);
    }
}
