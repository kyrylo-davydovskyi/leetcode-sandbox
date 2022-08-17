package strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import strings.SortCharactersByFrequency;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class SortCharactersByFrequencyTest {

    public static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of("tree", List.of("eetr", "eert")),
                Arguments.of("cccaaa", List.of("cccaaa", "aaaccc")),
                Arguments.of("Aabb", List.of("bbAa", "bbaA"))
        );
    }

    @ParameterizedTest
    @MethodSource("testArguments")
    public void firstSymbolIsUnique(String line, List<String> expected) {
        var executor = new SortCharactersByFrequency();
        var actual = executor.frequencySort(line);

        assertThat(actual).isIn(expected);
    }
}
