package lesson_8;

import java.util.*;

public class Words {
    public static void main(String[] args) {
        String[] words = {"arm", "leg", "neck", "mouth", "teeth",
                "head", "stomach", "arm", "eyes", "leg",
                "teeth", "neck", "mouth", "neck", "mouth"};

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        System.out.println("Unique words " + uniqueWords);

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
