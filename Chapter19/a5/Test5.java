package Chapter19.a5;

public class Test5 {
    public static void main(String[] args) {
        Integer[] list = {1,2,3,4,5};
        System.out.print("The maximum is " + max(list));
    }

    public static <E extends Comparable<E>> E max(E[] list){
        E currentMax = list[0];

        for (int i = 1; i < list.length; i++)
            if (currentMax.compareTo(list[i]) < 0)
                currentMax = list[i];

        return currentMax;
    }
}
