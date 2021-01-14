package Chapter27Hashing.pratice;

import java.util.LinkedList;

public class HashSetPratice<E> {
    private static int INITIAL_CAPACITY = 4;
    private static int MAX_CAPACITY = 1 << 30;
    private static float LOAD_FACTOR = 0.75f;
    private int capacity;
    private int size = 0;
    private float loadfactorTheshold;//larger then resize

    private LinkedList<E>[] table;

    public HashSetPratice(){
        this(INITIAL_CAPACITY , LOAD_FACTOR);
    }

    public HashSetPratice(int capactiy){
        this(capactiy , LOAD_FACTOR);
    }

    public HashSetPratice(int capactiy , float loadfactorTheshold){
        if (capactiy > MAX_CAPACITY)
            this.capacity = MAX_CAPACITY;
        else
            this.capacity = trimToPowerOf2(capactiy);

        this.loadfactorTheshold = loadfactorTheshold;
        table = new LinkedList[capactiy];

    }

    public void clear(){
        size = 0 ;
        removeElements();
    }

    private void removeElements(){
        for (int i = 0 ; i < capacity ; i++){
            if (table[i] != null)
                table[i].clear();
        }
    }
    
    public int trimToPowerOf2(int capacity){
        int cap = 1 ;
        while (cap < capacity){
            cap <<= 1;
        }

        return cap;
    }
}
