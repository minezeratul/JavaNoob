package chapter23.Pratice;

import java.util.Arrays;
import java.util.Random;

public class QuickSelectionSort {
    public static void main(String[] args) {
        int[] arr = {1 , 4, 5, 6,2, 8, 3, 7  ,9 ,0};
        System.out.println(Arrays.toString(arr));
        shuffle(arr);
        System.out.println("\n" + Arrays.toString(arr));
        quickSelection(arr);
        System.out.println(Arrays.toString(arr));
    }


    //public static <E> void shuffle(ArrayList<E> list) {
    //        for (int i = 0; i < list.size() - 1; i++) {
    //            int index = (int) (Math.random() * list.size());
    //            E temp = list.get(i);
    //            list.set(i, list.get(index));
    //            list.set(index, temp);
    //        }
    //    }

    public static void shuffle(int[] arr){
        int n = arr.length;
        Random random = new Random();
        for (int i = 0 ; i < n; i++) {
            // 从 i 到最后随机选一个元素
            int r = i + random.nextInt(n - i);
            System.out.print(random.nextInt(n - i) + " ");
            swap(arr, i, r);
        }
    }

    public static void quickSelection(int[] arr){
        quickSelection(arr , 0 ,arr.length - 1);
    }

    public static void quickSelection(int[] arr , int first , int last){
        if (first > last)
            return;

        int pivotIndex = partition(arr , first ,last);
        //我们其实不能保证每次p都是正中间的索引的 , 
        // 为了尽可能防止极端情况发生，
        // 我们需要在算法开始的时候对arr来一次随机打乱
        quickSelection(arr , first , pivotIndex - 1);
        quickSelection(arr , pivotIndex + 1 , last);
    }

    public static int partition(int[] arr , int low , int high){
        if (low == high) return low;

        int pivot = arr[low];
        int i = low , j = high + 1;
        while (true){
            //保证arr[low -- i]都小于pivot
            while (arr[++i] < pivot){
                if (i == high)
                    break;
            }

            //保证arr[low -- i]都大于pivot
            while (arr[--j] > pivot){
                if (j == low)
                    break;
            }

            if (i >= j)
                break;

            // 如果走到这里，一定有：
            // nums[i] > pivot && nums[j] < pivot
            // 所以需要交换 nums[i] 和 nums[j]，
            // 保证 nums[low..i] < pivot < nums[j..high]

            swap(arr , i , j);
        }
        // 将 pivot 值交换到正确的位置

        swap(arr , j , low);
        // 现在 nums[low..j-1] < nums[j] < nums[j+1..high]
        return j;
    }

    public static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
