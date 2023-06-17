package strings;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lombok.extern.slf4j.Slf4j;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class RansomNoteTest {
    
    public static Stream<Arguments> generateTests() {
        return Stream.of(
            Arguments.of("ab", "ba", true),
            Arguments.of("ab", "aa", false),
            Arguments.of("ab", "a", false),
            Arguments.of("abcd", "aabbcd", true)
        );
    }

    @ParameterizedTest
    @MethodSource("generateTests")
    public void test(String ransomNote, String magazine, Boolean expected) {
        var actual = RansomNote.canConstruct(ransomNote, magazine);
        assertThat(actual).isEqualTo(expected);
    }
}
