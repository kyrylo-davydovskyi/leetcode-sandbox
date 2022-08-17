import java.util.HashMap;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
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
