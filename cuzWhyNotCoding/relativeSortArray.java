package cuzWhyNotCoding;

import java.util.Arrays;

public class relativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString( relativeSort(arr1 , arr2) ));
    }

    //CountingSort
    public static int[] relativeSort(int[] arr1 , int[] arr2){
        int[] dptable = new int[1001];//record the times of nums

        for (int num1 : arr1)
            dptable[num1]++;

        int i = 0 ;
        for (int num2 : arr2)
            while (dptable[num2] > 0){
                arr1[i++] = num2;
                dptable[num2]--;
            }

        int length = dptable.length;
        for (int num1 = 0 ; num1 < length ; num1++){
            while (dptable[num1] > 0){
                arr1[i++] = num1;
                dptable[num1]--;
            }
        }

        return arr1;
    }

    //BucketSort
    /*  public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //由于arr1的可能取值为0-1000，共1001个取值，不算一个很大的取值范围，所以可以利用桶式排序
        int[] bucket = new int[1001];
        //计数每个桶有多少个数，也就是每个值在数组中有几个
        for(int num:arr1){
            bucket[num]++;
        }
        //由于重新排序不会改变数组的长度，所以可以利用原数组，可以节省空间复杂度
        int i = 0;
        //由于排序是按照相对顺序进行排序，所以，首先根据arr2中的桶的顺序，依次从对应的桶中取数到arr1中
        //并注意，每拿出一个数，需要将对桶中的数的个数进行-1操作
        for(int num:arr2){
            while(bucket[num]-- > 0){
                arr1[i++] = num;
            }
        }
        //未在arr2中的桶中的数，按照桶号升序进行输出，所以进行二次遍历
        for(int j = 0; j < 1001; ++j){
            while(bucket[j]-- > 0){
                arr1[i++] = j;
            }
        }
        return arr1;
    }

     */

}
