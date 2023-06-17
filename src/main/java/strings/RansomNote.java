package strings;

import java.util.function.Function;
import java.util.stream.Collectors;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        var ransomNoteMap = ransomNote.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        var magazineMap = magazine.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (var entry : ransomNoteMap.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();

            if (!magazineMap.containsKey(key)
                    || magazineMap.get(key) < value) {
                return false;
            }
        }

        return true;
    }

}
