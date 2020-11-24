package Chapter21.q7;

import java.util.*;

public class Test7 {
    public static void main(String[] args) {
        String text = "Have a good day. Have a good class. " + "Have a good visit. Have fun!";

        HashMap<String, Integer> hashMap = new HashMap<>();

        String[] tokens = text.split("[ |.|!|?]");
        for (String key: tokens) {
            if (hashMap.get(key) != null) {
                hashMap.put(key, hashMap.get(key).intValue() + 1);
            }
            else {
                if (key.trim().length() > 0)
                    hashMap.put(key, 1);
            }
        }

        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();

        ArrayList<WordOccurrence> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry: entrySet) {
            list.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        }

        Collections.sort(list);
        for (WordOccurrence item: list) {
            System.out.println(item);
        }
    }
}

class WordOccurrence implements Comparable<WordOccurrence>{
    String word;
    int count ;

        public WordOccurrence(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(WordOccurrence o) {
            return count - o.count;
        }

        @Override
        public boolean equals(Object o) {
            return word.equals(((WordOccurrence)o).word);
        }

        @Override
        public String toString() {
            return word + ": " + count;
        }

}

