package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {-3, 18, 0, 25, -20, 30, -1, 900, 456, 13};
        //测试选择排序
        testQuick(array);
        //100000数据测试选择排序的速度(<<1s)
        //1000000数据测试选择排序的速度(<1s)
        //1000000数据测试选择排序的速度(2s)
        testQuickTime();
    }

    public static void quickSort(int[] array, int left, int right) {

        int l = left;//左下标
        int r = right;//右下标
        //中轴值
        int pivot = array[(left + right) / 2];
        int temp = 0;
        //比pivot小的值放到左边，比pivot值大的放在右边
        while (l < r) {
            //在pivot左边一直找，直到找到大于pivot的值
            while (array[l] < pivot) {
                l++;
            }
            //在pivot左边一直找，直到找到大于pivot的值
            while (array[r] > pivot) {
                r--;
            }
            //判断左右两边是否遍历完
            if (l >= r) {
                break;
            }
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            //若发现 array[l] == pivot,则r前移。若array[r]，则l后移
            if (array[l] == pivot) {
                r--;
            }
            if (array[r] == pivot) {
                l++;
            }
        }
        //若l == r，则必须l++ r--,否则会出现栈溢出
        if (l == r) {
            l++;
            r--;
        }
        //向左递归
        if (left < r) {
            quickSort(array, left, r);
        }
        //向右递归
        if (l < right) {
            quickSort(array, l, right);
        }
    }

    //快速排序测试方法
    public static void testQuick(int[] array) {
        System.out.println("排序前");
        System.out.println(Arrays.toString(array));
        //exShellSort(array);
        quickSort(array, 0, array.length - 1);
        System.out.println("排序后");
        System.out.println(Arrays.toString(array));
    }

    //选择排序时间测试方法
    public static void testQuickTime() {
        int[] array = new int[100000];
        for (int i = 0; i < 100000; i++) {
            array[i] = (int) (Math.random() * 1000000);
        }
        Date datebefore = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateb = simpleDateFormat.format(datebefore);
        System.out.println("排序前的时间为" + dateb);

        quickSort(array, 0, array.length - 1);
        Date dateafter = new Date();
        String datea = simpleDateFormat.format(dateafter);
        System.out.println("排序后的时间为" + datea);
    }
}
