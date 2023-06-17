package strings;

import java.util.HashMap;

public class FirstUniqueCharacterInString {

    /**
     * 387. First Unique Character in a String
     * Given a string s, find the first non-repeating character in it and return its index. 
     * If it does not exist, return -1.
     * @param s 
     * @return first unique char
     */
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
