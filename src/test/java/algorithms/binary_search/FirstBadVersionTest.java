package algorithms.binary_search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstBadVersionTest {

    public static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of(10, 7),
                Arguments.of(20, 7),
                Arguments.of(13, 5),
                Arguments.of(7, 1),
                Arguments.of(7, 7)
        );
    }


    @ParameterizedTest
    @MethodSource("testArguments")
    public void firstBadVersionTest(int latest, int expected) {
        var executor = new FirstBadVersion(expected);
        var actual = executor.firstBadVersion(latest);

        assertThat(actual).isEqualTo(expected);
    }
}
