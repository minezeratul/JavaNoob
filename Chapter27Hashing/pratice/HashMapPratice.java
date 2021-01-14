package Chapter27Hashing.pratice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class HashMapPratice<K , V> {

    public static class Entry<K , V>{
        K key;
        V value;

        public Entry(K key , V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "[" + key + "=" + value + "]";
        }
    }

    private static int INITIAL_CAPACITY = 4 ;
    private static int MAX_CAPACITY = 1 << 30;
    private static float LOAD_FACTOR = 0.75f;
    private int capacity;
    private int size = 0;
    private float loadfactorTheshold;//larger then resize

    LinkedList<Entry<K , V>>[] table;//Separate-Chaining

    public HashMapPratice(){
        this(INITIAL_CAPACITY , LOAD_FACTOR);
    }

    public HashMapPratice(int capactiy){
        this(capactiy , LOAD_FACTOR);
    }

    public HashMapPratice(int capactiy , float loadfactorTheshold){
        if (capactiy > MAX_CAPACITY)
            this.capacity = MAX_CAPACITY;
        else
            this.capacity = trimToPowerOf2(capactiy);

        this.loadfactorTheshold = loadfactorTheshold;
        table = new LinkedList[capactiy];

    }

    private void removeEntries(){
        for (int i = 0 ; i < capacity ; i++){
            if (table[i] != null)
                table[i].clear();
        }
    }

    public boolean containsKey(K key){
        return get(key) != null;
    }

    public boolean containsValue(V val){
        for (int i = 0 ; i < capacity ; i++){
            if (table[i] != null){
                LinkedList<Entry<K , V>> bucket = table[i];
                for (Entry<K , V> entry : bucket)
                    if (entry.getValue().equals(val))
                        return true;
            }
        }

        return false;
    }

    public V get(K key){
        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] != null){
            LinkedList<Entry<K , V>> bucket = table[bucketIndex];
            for (Entry<K , V> entry : bucket)
                if (entry.getKey().equals(key))
                    return entry.getValue();
        }

        return null;
    }

    public void remove(K key){
        int bucketIndex = hash(key.hashCode());

        if (table[bucketIndex] != null){
            LinkedList<Entry<K , V>> bucket = table[bucketIndex];
            for (Entry<K , V> entry : bucket)
                if (entry.getKey().equals(key)){
                    bucket.remove(entry);
                    size--;
                    break;
                }
        }
    }

    public V put(K key ,V value){//when replaced , return old value
        if (get(key) != null){
            int bucketIndex = hash(key.hashCode());
            LinkedList<Entry<K , V>> bucket = table[bucketIndex];
            for (Entry<K , V> entry : bucket)
                if (entry.getKey().equals(key)){
                    V oldValue = entry.getValue();
                    entry.value = value;
                    return oldValue;
                }
        }

        if (size >= capacity * loadfactorTheshold) {
            if (capacity == MAX_CAPACITY)
                throw new RuntimeException("Exceeding maximum capacity");

            rehash();
        }

        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] == null)
            table[bucketIndex] = new LinkedList<Entry<K , V>>();

        table[bucketIndex].add(new Entry<K , V>(key , value));
        size++;

        return value;
    }

    private void rehash(){
        Set<Entry<K , V>> set = entrySet();
        capacity <<= 1;
        table = new LinkedList[capacity];
        size = 0;

        for (Entry<K , V> entry : set)
            put(entry.getKey() , entry.getValue());
    }

    public Set<Entry<K , V>> entrySet(){
        Set<Entry<K , V>> set = new HashSet<>();

        for (int i = 0 ; i < capacity ; i++){
            if (table[i] != null){
                LinkedList<Entry<K , V>> bucket = table[i];
                for (Entry<K , V> entry : bucket)
                    set.add(entry);
            }
        }

        return set;
    }

    public Set<K> keySet(){
        Set<K> set = new HashSet<>();
        for (int i = 0 ;i < capacity ; i++){
            if (table[i] != null){
                LinkedList<Entry<K , V>> bucket = table[i];
                for (Entry<K , V> entry : bucket)
                    set.add(entry.getKey());
            }
        }

        return set;
    }

    public Set<V> values(){
        Set<V> set = new HashSet<>();

        for (int i = 0 ; i < capacity ; i++){
            if (table[i] != null){
                LinkedList<Entry<K , V>> bucket = table[i];
                for (Entry<K ,V> entry : bucket)
                    set.add(entry.getValue());
            }
        }

        return set;
    }

    private int hash(int hashcode){//double hashing
        return supplementalHash(hashcode) & (capacity - 1);
    }

    private static int supplementalHash(int h){
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public int trimToPowerOf2(int capacity){
        int cap = 1 ;
        while (cap < capacity){
            cap <<= 1;
        }

        return cap;
    }

    public int size(){
        return size;
    }

    public void clear(){
        size = 0;
        removeEntries();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        Iterator<Entry<K , V>> iterator = entrySet().iterator();
        if (!iterator.hasNext())
            return "[]";

        StringBuilder builder = new StringBuilder("[");

        for (;;){
            Entry<K , V> entry = iterator.next();
            K key = entry.getKey();
            V val = entry.getValue();
            builder.append(key != this ? key : "(This map)");
            builder.append("=");
            builder.append(val != this ? val : "(This map)");
            if (!iterator.hasNext())
                return builder.append("]").toString();

            builder.append(", ");
        }

    }

}
