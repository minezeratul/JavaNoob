package cuzWhyNotCoding;

import java.util.Arrays;

public class moveZeroes {
    public static void main(String[] args) {
        int[] arr1 = {1 , 0 , 3 , 12 , 0};
        moveZero1(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {1 , 0 , 3 , 12 , 0};
        moveZero2(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {1 , 0 , 3 , 12 , 0};
        moveZero3(arr3);
        System.out.println(Arrays.toString(arr3));
    }

    //double pointers scanning 0ms 38.8MB
    public static void moveZero1(int[] arr){
        if(arr == null)
            return;

        int i = 0 ;
        int length = arr.length;
        for (int j = 0 ; j < length ; j++)
            if (arr[j] != 0)
                arr[i++] = arr[j];

            for (int k = i ; k < length ; k++)
                arr[k] = 0;

    }

    //single pointer scanning 0ms 38.3MB
    public static void moveZero2(int[] arr){
        if (arr == null)
            return;

        int i = 0;
        int length = arr.length;
        for (int j = 0 ; j < length ; j++){
            if (arr[j] != 0) {
                int temp = arr[j];
                arr[j]  = arr[i];
                arr[i++] = temp;
            }
        }
    }


    //In my opinion the best solve , 0ms 38.8MB
    // 其实优化的地方就是#1处。它避免了数组开头是非零元素的交换也就是阻止（i==j）时交换。
    // 当i > j 时，只需要把 i 的值赋值给j 并把原位置的值置0。
    // 同时这里也把交换操作换成了赋值操作，减少了一条操作语句，理论上能更节省时间。
    // 如果元素不为0，i,j跟着一起动
    public static void moveZero3(int[] arr){
        if (arr == null)
            return;

        int length;
        if (arr == null || (length = arr.length) == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] != 0) {
                if (i > j) {// #1
                   arr[j] = arr[i];
                   arr[i] = 0;
                }
                j++;
            }
        }

    }
}
