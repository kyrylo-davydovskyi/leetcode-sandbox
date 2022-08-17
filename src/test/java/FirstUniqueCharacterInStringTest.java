import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstUniqueCharacterInStringTest {

    public static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of("aaaaaa", -1),
                Arguments.of("abcde", 0),
                Arguments.of("loveleetcode", 2),
                Arguments.of("leetcode", 0),
                Arguments.of("aadadaad", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("testArguments")
    public void firstSymbolIsUnique(String line, Integer index) {
        var executor = new FirstUniqueCharacterInString();
        assertThat(executor.firstUniqChar(line))
                .isEqualTo(index);
    }
}
