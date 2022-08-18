package arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RunningSumOfOneDimensionalArrayTest {

    public static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of(new int[] {1,2,3,4}, new int[] {1,3,6,10}),
                Arguments.of(new int[] {1,1,1,1,1}, new int[] {1,2,3,4,5}),
                Arguments.of(new int[] {3,1,2,10,1}, new int[] {3,4,6,16,17})
        );
    }

    @ParameterizedTest
    @MethodSource("testArguments")
    public void runningSumTest(int[] source, int[] expected) {
        var executor = new RunningSumOfOneDimensionalArray();
        var actual = executor.runningSum(source);

        assertThat(actual).isEqualTo(expected);
    }
}
