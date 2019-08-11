package Sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//冒泡排序实现
public class BubbleSort {
    public static void main(String[] args) {
        //测试冒泡排序方法
        int array[] = {2, 1, 3, 5, 4};
        testBubble(array);
        //100000数据测试冒泡排序速度(20s左右)
        testBubbleTime();
    }

    //将冒泡排序封装为一个方法
    public static void bubbleSort(int[] array) {
        int temp = 0;
        boolean flag = false;//标识变量,表示是否进行过交换
        //冒泡排序时间复杂度为O(n^2)
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                //若前面的数字大于后面的数字则交换位置
                if (array[j] > array[j + 1]) {
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            //System.out.println((i + 1) + "趟排序后的数组");
            //System.out.println(Arrays.toString(array));
            if (flag == false) {//在一趟排序中没有进行交换
                //System.out.println("排序结束");
                break;
            } else {
                flag = false;//重置flag及逆行下一次判断
            }
        }
    }

    //冒泡排序测试方法
    public static void testBubble(int[] array) {
        System.out.println("排序前");
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println("排序后");
        System.out.println(Arrays.toString(array));
    }
    //冒泡排序时间测试方法
    public static void testBubbleTime() {
        int[] array0 = new int[100000];
        for (int i = 0; i < 100000; i++) {
            array0[i] = (int) (Math.random() * 1000000);
        }
        Date datebefore = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateb = simpleDateFormat.format(datebefore);
        System.out.println("排序前的时间为" + dateb);
        bubbleSort(array0);
        Date dateafter = new Date();
        String datea = simpleDateFormat.format(dateafter);
        System.out.println("排序后的时间为" + datea);
    }
}
