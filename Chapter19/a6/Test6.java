package Chapter19.a6;

public class Test6 {
    public static void main(String[] args) {
        Integer[][] list = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.print("The maximum is " + max(list));
    }

    public static <E extends Comparable<E>> E max(E[][] list) {
        E currentMax = list[0][0];

        for (int i = 1; i < list.length; i++)
            for(int j = 0 ; j < list[i].length ; j++)
            if (currentMax.compareTo(list[i][j]) < 0)
                currentMax = list[i][j];

        return currentMax;

    }
}
