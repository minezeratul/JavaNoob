

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class WordOccurence {
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("Usage: java WordOccurence fullfilename");
            System.exit(1);
        }

        String filename = args[0];

        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();

        try {
            Scanner input = new Scanner(new File(filename));

            while (input.hasNext()) {
                String line = input.nextLine();
                String[] words = line.split("[ @!~{}\\[\\]$#^&*\n\t\r.,;?'\")(]");

                for (int i = 0; i < words.length; i++) {
                    if (words[i].trim().length() > 0 && words[i].trim().matches("[A-Z|a-z]+")) {
                        String key = words[i].toLowerCase();

                        if (treeMap.get(key) != null) {
                            int count = treeMap.get(key);
                            count++;
                            treeMap.put(key, count);
                        }
                        else {
                            treeMap.put(key, 1);
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        Set<Map.Entry<String, Integer>> entrySet = treeMap.entrySet();

        System.out.println("\nDisplay words and their count in " + " ascending order of the words");
       // for (Map.Entry<String, Integer> entry: entrySet)
      //     System.out.println(entry.getValue() + "\t" + entry.getKey());
        entrySet.forEach(entry -> System.out.println(entry.getValue() + "\t" + entry.getKey())); // lambda expression
    }
}
