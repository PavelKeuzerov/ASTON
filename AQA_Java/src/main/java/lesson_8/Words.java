package lesson_8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Words {
    public static void main(String[] args) {
        String[] words = {"arm", "leg", "neck", "mouth", "teeth",
                "head", "stomach", "arm", "eyes", "leg",
                "teeth", "neck", "mouth", "neck", "mouth"};

        Set<String> uniqueWords = new HashSet<>();
        for (String w : words) {
            uniqueWords.add(w);
        }

        for (String word : uniqueWords) {
            System.out.println(word);
        }

        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (wordCounts.containsKey(word)) {
                int count = wordCounts.get(word);
                Integer put = wordCounts.put(word, count + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }

        for (String word : wordCounts.keySet()) {
            int count = wordCounts.get(word);
            System.out.println("repeated word: " + word + " - " + count + " time");
        }
    }
}
