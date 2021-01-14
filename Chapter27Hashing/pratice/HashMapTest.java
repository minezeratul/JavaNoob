package Chapter27Hashing.pratice;

import java.util.HashMap;


public class HashMapTest {
     public static void main(String[] args){
          HashMapPratice map = new HashMapPratice();
          map.put(1 , 5);
          map.put(2 , 6);
          map.put(3 , 7);
          map.put(4 , 8);
         System.out.println(map);
         
         map.remove(4);
         System.out.println(map);

         System.out.println(map.containsKey(3));
         System.out.println(map.containsKey(4));

         System.out.println(map.containsValue(7));
         System.out.println(map.containsValue(8));

         System.out.println(map.get(3));
         System.out.println(map.entrySet());
         System.out.println(map.keySet());
         System.out.println(map.values());
      }
}
