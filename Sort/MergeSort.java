package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
        int array[] = {8, 4, 5, 7, 1, 3, 6, 2, 0, 10, 9};
        int temp[] = new int[array.length];
        //测试归并排序
        testMerge(array);
        //10000000数据测试选择排序的速度(2ms)
        testMergeTime();
    }

    //分解+合并方法
    public static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;//中间索引
            //向左递归分解
            mergeSort(array, left, mid, temp);
            //向右递归分解
            mergeSort(array, mid + 1, right, temp);
            //到合并为止
            merge(array, left, mid, right, temp);
        }
    }
    //合并方法

    /**
     * @param array 待排序数组
     * @param left  左索引
     * @param right 右索引
     * @param mid   中间索引
     * @param temp  中转数组
     */
    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left;//左有序序列初始索引
        int j = mid + 1;//右有序序列初始索引
        int t = 0;//指向temp数组的当前索引

        //先把左右两边有序的数据填充至temp数组，直到左右两边有一边处理完毕。
        while (i <= mid && j <= right) {//未结束
            //若发现左序列当前元素小于等于右序列的当前元素，即将左序列元素入数组，左索引前进.
            if (array[i] <= array[j]) {
                temp[t] = array[i];
                i++;
                t++;
            } else {//左序列元素大，填充右序列当前元素，右索引前进。
                temp[t] = array[j];
                j++;
                t++;
            }
        }
        //把有剩余数据的一边的数据一次全部填充至temp
        //右序列结束，左序列有剩余元素，入temp
        while (i <= mid) {//右序列结束，左序列有剩余元素，入temp
            temp[t] = array[i];
            t++;
            i++;
        }
        //左序列结束，右序列有剩余元素，入temp
        while (j <= right) {
            temp[t] = array[j];
            t++;
            j++;
        }
        //将temp数组的元素copy到array数组中
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            array[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }

    //归并排序测试方法
    public static void testMerge(int[] array) {
        System.out.println("排序前");
        System.out.println(Arrays.toString(array));
        int temp[] = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
        System.out.println("排序后");
        System.out.println(Arrays.toString(array));
    }

    //归并排序时间测试方法
    public static void testMergeTime() {
        int[] array = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            array[i] = (int) (Math.random() * 1000000000);
        }
        Date datebefore = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:sss");
        String dateb = simpleDateFormat.format(datebefore);
        System.out.println("排序前的时间为" + dateb);
        int temp[] = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
        Date dateafter = new Date();
        String datea = simpleDateFormat.format(dateafter);
        System.out.println("排序后的时间为" + datea);
    }
}
