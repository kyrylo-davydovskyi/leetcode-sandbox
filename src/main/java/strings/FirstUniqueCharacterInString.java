package strings;

import java.util.*;

public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {
        var symbols = s.toCharArray();
        var score = new HashMap<Character, Integer>();
        for (char symbol : symbols) {
            score.merge(symbol, 1, Integer::sum);
        }


        for (int i = 0; i < symbols.length; i++) {
            if (score.get(symbols[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
