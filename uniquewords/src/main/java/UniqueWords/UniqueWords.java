package UniqueWords;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.reverseOrder;

public class UniqueWords {
    private static Map<String, Integer> getWordsOccurrence(String[] wordsArr) {
        Map<String, Integer> occurenceMap = new HashMap<>();
        if (wordsArr == null) {
            return occurenceMap;
        }
        if (wordsArr.length == 0) {
            return occurenceMap;
        }
        Arrays.stream(wordsArr).forEach(s -> {
            if (s != null) {
                s = s.toLowerCase();
                if (occurenceMap.keySet().contains(s)) {
                    occurenceMap.put(s, occurenceMap.get(s) + 1);
                } else {
                    occurenceMap.put(s, 1);
                }
            }
        });
        return occurenceMap;
    }

    public static void main(String[] args) {
        System.out.println("Выпьем за любовь:");
        getWordsOccurrence(Nikolaev.VYPIEMZALUBOV)
                .entrySet()
                .stream()
                .sorted(reverseOrder(Map.Entry.comparingByValue()))
                .forEach(System.out::println);


        System.out.println("\n5 причин:");
        getWordsOccurrence(Nikolaev.PYATPRICHIN)
                .entrySet()
                .stream()
                .sorted(reverseOrder(Map.Entry.comparingByValue()))
                .forEach(System.out::println);
    }
}
