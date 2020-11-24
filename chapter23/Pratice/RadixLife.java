package chapter23.Pratice;

import java.util.Arrays;

public class RadixLife {
    public static void main(String[] args) {
        int[] arr = {5, 4, 6, 7, 3, 2, 8, 9, 1, 11, 10, 100};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("---------------------------------");

        int[] arr2 = {5, 4, 6, 7, 3, 2, 8, 9, 1, 11, 10, 100};
        System.out.println(Arrays.toString(arr2));
        bucket(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    public static void radixSort(int[] arr) {

        //根据前面的推导过程，我们可以得到最终的代码
        //1.得到数组中最大数的位数
        int max = arr[0];//假设第一个数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {//如果我们假定max不是最大的
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();

        //定义一个二维数组表示10个桶(桶的编号为：0-9)，每个桶就是一个一维数组
        //说明
        //1.二维数组包含10个一维数组
        //2.为了防止在放数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.lenght
        //3.基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组，来记录各个桶每次放入的个数
        //可以这样理解
        //bucketElementCounts[0],就是记录bucket[0]桶的放入数据的个数
        int[] bucketElementCounts = new int[10];

        //这里我们采用循环将代码进行处理：
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //针对每个元素对应的位进行排序处理，第一次是个位，第二次是十位，第三次是百位....
            for (int value : arr) {
                //取出每个元素对应位的值
                int digitOfElement = (value / n) % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = value;
                bucketElementCounts[digitOfElement]++;
            }
            //按照桶的顺序(一维数组的下标一次取出数据，放入原来的数组)
            int index = 0;
            //遍历每一个桶，并将桶中的数据放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，我们才放入到原数组中
                if (bucketElementCounts[k] != 0) {
                    //循环该桶，即第k个桶(即第K个一维数组)，放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素，放入到arr中
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                //注意：第i+1轮处理后，需要对每一个bucketElementCounts[k]置零，;
                bucketElementCounts[k] = 0;

            }
            //打印出每一轮的排序结果
            System.out.println("第" + (i + 1) + "轮排序结果：" + Arrays.toString(arr));
        }
    }

    public static void bucket(int[] data)//data为待排序数组
    {
        int n = data.length;
        int[][] bask = new int[10][n];
        int[] index = new int[10];
        int max = Integer.MIN_VALUE;
        for (int value : data) {
            max = Math.max(max, (Integer.toString(value).length()));
        }
        StringBuilder str;
        for (int i = max - 1; i >= 0; i--) {
            for (int datum : data) {
                str = new StringBuilder();
                if (Integer.toString(datum).length() < max) {
                    for (int k = 0; k < max - Integer.toString(datum).length(); k++)
                        str.append("0");
                }
                str.append(datum);
                bask[str.charAt(i) - '0'][index[str.charAt(i) - '0']++] = datum;
            }
            int pos = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < index[j]; k++) {
                    data[pos++] = bask[j][k];
                }
            }
            for (int x = 0; x < 10; x++)
                index[x] = 0;
        }
    }

}