package strings;

import java.util.function.Function;
import java.util.stream.Collectors;

public class RansomNote {

    /**
     * 383. Ransom Note
     * Given two strings ransomNote and magazine, 
     * return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
     * Each letter in magazine can only be used once in ransomNote.
     * @param ransomNote
     * @param magazine
     * @return boolean can note be constructed
     */
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
