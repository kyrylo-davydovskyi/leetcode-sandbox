package strings;

import java.util.HashMap;

public class SortCharactersByFrequency {

    /**
     * 451. Sort Characters By Frequency
     * Given a string s, sort it in decreasing order based on the frequency of the characters. 
     * The frequency of a character is the number of times it appears in the string.
     * Return the sorted string. If there are multiple answers, return any of them.
     * @param s
     * @return sorted string
     */
    public static String frequencySort(String s) {
        var symbols = s.toCharArray();
        var score = new HashMap<Character, Integer>();
        for (char symbol : symbols) {
            score.merge(symbol, 1, Integer::sum);
        }
        var resultLine = new StringBuilder();
        score.entrySet()
                .stream()
                .sorted((element1, element2) -> Integer.compare(element2.getValue(), element1.getValue()))
                .forEach(x -> {
                    var segment = String.valueOf(x.getKey()).repeat(Math.max(0, x.getValue()));
                    resultLine.append(segment);
                });
        return resultLine.toString();
    }
}
