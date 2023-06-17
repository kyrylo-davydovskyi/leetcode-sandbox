package arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RichestCustomerWealthTest {
    public static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {2, 8, 7},
                        {7, 1, 3},
                        {1, 9, 5}
                }, 17),
                Arguments.of(new int[][]{
                        {1,2,3},
                        {3,2,1},
                }, 6),
                Arguments.of(new int[][]{
                        {1,5},
                        {7,3},
                        {3,5}
                }, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("testArguments")
    public void maximumWealthTest(int[][] accounts, Integer expected) {
        var executor = new RichestCustomerWealth();
        var actual = executor.maximumWealth(accounts);

        assertThat(actual).isEqualTo(expected);
    }
}
