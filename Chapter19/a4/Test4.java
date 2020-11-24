package Chapter19.a4;

public class Test4 {
    public static void main(String[] args){
        Integer[] list = {1,2,3,4,5,6,7,8,9};
        Integer key = new Integer(8);
        System.out.println(linearSearch(list , key));
    }

    public static <E extends Comparable<E>> int linearSearch(E[] list , E key){
        for(int i = 0 ; i <list.length ; i++){
            if(key.compareTo(list[i]) == 0) {
                System.out.print("The index of the matched is ");
                return i;
            }
        }

        return -1;//no match
    }

}
