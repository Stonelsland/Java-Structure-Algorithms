package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {111, 25, 89, 20, 8, 33};
        //插入排序测试
        testInsert(array);
        //100000数据测试插入排序的速度(1s)
        testInsertTime();
    }

    //插入排序
    public static void insertSort(int[] array) {
        int insertValue = 0;//待插入数
        int insertIndex = 0;//待插入数上一个数的下标
        for (int i = 1; i < array.length; i++) {
            insertValue = array[i];
            insertIndex = i - 1;
            //寻找插入位置
            //insertValue >= 0保证插入位置不越界
            //若insertValue < array[insertIndex]则未找到插入位置
            //未满足条件则array[insertIndex]后移
            while (insertIndex >= 0 && insertValue < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            //当退出while循环式,则说明找到插入位置,insertIndex+1
            //判断是否需要赋值
            if (insertIndex + 1 != i) {
                array[insertIndex + 1] = insertValue;
            }
        }
    }

    //插入排序测试方法
    public static void testInsert(int[] array) {
        System.out.println("排序前");
        System.out.println(Arrays.toString(array));
        insertSort(array);
        System.out.println("排序后");
        System.out.println(Arrays.toString(array));
    }

    //插入排序时间测试方法
    public static void testInsertTime() {
        int[] array0 = new int[100000];
        for (int i = 0; i < 100000; i++) {
            array0[i] = (int) (Math.random() * 1000000);
        }
        Date datebefore = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateb = simpleDateFormat.format(datebefore);
        System.out.println("排序前的时间为" + dateb);

        insertSort(array0);
        Date dateafter = new Date();
        String datea = simpleDateFormat.format(dateafter);
        System.out.println("排序后的时间为" + datea);
    }
}

