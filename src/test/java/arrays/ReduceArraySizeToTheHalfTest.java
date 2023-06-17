package arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ReduceArraySizeToTheHalfTest {

    public static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}, 2),
                Arguments.of(new int[]{7, 7, 7, 7, 7, 7}, 1),
                Arguments.of(new int[]{1, 9}, 1),
                Arguments.of(new int[]{1000,1000,3,7}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testArguments")
    public void minSetSize(int[] source, int expected) {
        var actual = ReduceArraySizeToTheHalf.minSetSize(source);

        assertThat(actual).isEqualTo(expected);
    }
}
