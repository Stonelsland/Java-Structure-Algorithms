package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = {101, 34, 119, 11, -1, 11, 123};
        //选择排序测试
        testSelect(array);
        //100000数据测试选择排序的速度(3-4s)
        testSelectTime();
    }

    //选择排序
    public static void selectSort(int[] array) {
        int minIndex = 0;//最小值下标
        int min = 0;
        //选择排序的时间复杂度为O(n^2)
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            min = array[i];
            for (int j = i; j < array.length; j++) {
                if (min > array[j]) {//发现比假定值更小的值
                    min = array[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                array[minIndex] = array[i];
                array[i] = min;
            }
//            System.out.println((i+1) + "轮排序后");
//            System.out.println(Arrays.toString(array));
        }
    }

    //选择排序测试方法
    public static void testSelect(int[] array) {
        System.out.println("排序前");
        System.out.println(Arrays.toString(array));
        selectSort(array);
        System.out.println("排序后");
        System.out.println(Arrays.toString(array));
    }

    //选择排序时间测试方法
    public static void testSelectTime() {
        int[] array0 = new int[100000];
        for (int i = 0; i < 100000; i++) {
            array0[i] = (int) (Math.random() * 1000000);
        }
        Date datebefore = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateb = simpleDateFormat.format(datebefore);
        System.out.println("排序前的时间为" + dateb);

        selectSort(array0);
        Date dateafter = new Date();
        String datea = simpleDateFormat.format(dateafter);
        System.out.println("排序后的时间为" + datea);
    }
}
