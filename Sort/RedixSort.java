package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RedixSort {
    public static void main(String[] args) {
        int array[] = {13, 33, 782, 617, 5, 19, 77};

        //基数排序测试
        testRedix(array);
        //10000000数据测试选择排序的速度(1.001s)
        testRedixTime();
    }

    //基数排序方法
    public static void redixSort(int[] array) {
        //定义一个二维数组,表示十个桶,每个桶是一个一维数组
        int[][] bucket = new int[10][array.length];
        //定义一维数组记录各个桶中每轮存放数据个数
        int[] bucketCount = new int[10];
        //得到数组中最大数的位数
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int maxLength = (max + "").length();
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //对每个元素对应位数进行排序处理
            for (int j = 0; j < array.length; j++) {
                //取出每个元素的倒数第i位数
                int digit = array[j] / n % 10;
                bucket[digit][bucketCount[digit]] = array[j];
                bucketCount[digit]++;
            }
            //遍历每一个桶,并将每一个桶中数据放回原数组
            int index = 0;
            for (int k = 0; k < bucketCount.length; k++) {
                //若桶中有数据,才放入到原数组中
                if (bucketCount[k] != 0) {
                    //遍历该桶
                    for (int l = 0; l < bucketCount[k]; l++) {
                        //取出元素放入原数组中
                        array[index++] = bucket[k][l];
                    }
                }
                //每一轮处理过后要将计数器置零
                bucketCount[k] = 0;
            }
            //System.out.println("第" + (i + 1) + "轮后的排序结果" + Arrays.toString(array));
        }
    }


    //快速排序测试方法
    public static void testRedix(int[] array) {
        System.out.println("排序前");
        System.out.println(Arrays.toString(array));
        redixSort(array);
        System.out.println("排序后");
        System.out.println(Arrays.toString(array));
    }

    //快速排序时间测试方法
    public static void testRedixTime() {
        int[] array = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            array[i] = (int) (Math.random() * 100000000);
        }
        Date datebefore = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:sss");
        String dateb = simpleDateFormat.format(datebefore);
        System.out.println("排序前的时间为" + dateb);
        redixSort(array);
        Date dateafter = new Date();
        String datea = simpleDateFormat.format(dateafter);
        System.out.println("排序后的时间为" + datea);
    }
}
