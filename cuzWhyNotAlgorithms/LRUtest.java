package cuzWhyNotAlgorithms;

public class LRUtest {
    public static void main(String[] args) {
        LRUcache cache = new LRUcache(2);
        cache.put(1 , 1);
        cache.put(2 , 2);
        System.out.println(cache);
        cache.put(3, 3);
        System.out.println(cache);
        cache.get(2);
        System.out.println(cache);
        cache.put(2 , 4);
        System.out.println(cache);
    }
}
