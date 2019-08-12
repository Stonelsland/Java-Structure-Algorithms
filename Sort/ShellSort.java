package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {

        int[] array = {8, 3, 5, 9, 2, 1, 6, 4, 0, 7};
        //希尔排序测试
        testShell(array);
        //100000数据测试希尔排序的速度(交换式12s 移位式<1s)
        testShellTime();
    }

    //交换希尔排序
    public static void exShellSort(int[] array) {
        int temp = 0;
        int count = 0;
        //循环分组
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                //遍历各组中所有元素，步长为gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
            //System.out.println("第"+(++count)+"轮希尔排序："+ Arrays.toString(array));
        }
    }

    //优化交换式希尔排序-->移位法
    public static void shellSort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int temp = array[j];
                if (array[j] < array[j - gap]) {
                    while (j - gap >= 0 && temp < array[j - gap]) {
                        //移动
                        array[j] = array[j - gap];
                        j -= gap;
                    }
                    //退出while后,即找到temp插入位置
                    array[j] = temp;
                }
            }
        }
    }

    //希尔排序测试方法
    public static void testShell(int[] array) {
        System.out.println("排序前");
        System.out.println(Arrays.toString(array));
        //exShellSort(array);
        shellSort(array);
        System.out.println("排序后");
        System.out.println(Arrays.toString(array));
    }

    //希尔排序时间测试方法
    public static void testShellTime() {
        int[] array = new int[100000];
        for (int i = 0; i < 100000; i++) {
            array[i] = (int) (Math.random() * 1000000);
        }
        Date datebefore = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateb = simpleDateFormat.format(datebefore);
        System.out.println("排序前的时间为" + dateb);

        //测试哪个方法即开启哪个方法及
        //exShellSort(array);
        shellSort(array);
        Date dateafter = new Date();
        String datea = simpleDateFormat.format(dateafter);
        System.out.println("排序后的时间为" + datea);
    }
}

