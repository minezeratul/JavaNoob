package Chapter19.a7;

public class Test7 {
    public static void main(String[] args) {
        Integer[] list = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(BinarySearch(list,9));

    }

    public static <E extends Comparable<E>> int BinarySearch(E[] list , E key){
        int start = 0 ;
        int end = list.length - 1;
        int mid = (start + end ) / 2 ;
        while (list[mid] != key && end > start) {
            if ( list[mid].compareTo(key) == 1) {
                end = mid - 1;
            } else if ( list[mid].compareTo(key) == -1 ) {
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        return  (list[mid] != key) ? -1 : mid ;
        }
    }


