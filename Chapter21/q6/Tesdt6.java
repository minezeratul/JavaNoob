package Chapter21.q6;

import java.util.*;

public class Tesdt6 {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Enter an integer: ");
            int number = input.nextInt();

            if (number == 0) break;

            Integer key = new Integer(number);

            if (treeMap.get(key) != null) {
                int value = ((Integer)treeMap.get(key)).intValue();
                value++;
                treeMap.put(key, new Integer(value));
            }
            else {
                treeMap.put(key, new Integer(1));
            }
        }

        Integer max = Collections.max(treeMap.values());
        Set<Integer> keys = treeMap.keySet();
        Iterator<Integer> iterator = keys.iterator();

        while (iterator.hasNext()) {
            Object key = iterator.next();
            Integer value = (Integer)(treeMap.get(key));
            if (value.equals(max)) {
                System.out.println("Number " + key + " occurred most");
            }
        }
    }
}
