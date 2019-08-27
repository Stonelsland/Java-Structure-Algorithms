package Search;

import java.util.Arrays;

public class FibonacciSearch {

    public static void main(String[] args) {
        int[] array = {2,3,5,8,14,19,33,56,78,104,238,555,902,1234};
        int index = fibonacciSearch(array,1094);
        System.out.println(index);
    }

    //获取斐波那契数列
    public static int[] Fibonacci() {
        int maxSize = 20;
        int[] F = new int[maxSize];
        F[0] = 1;
        F[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }
        return F;
    }

    //非递归实现斐波那契查找算法

    /**
     * @param array 数组
     * @param value 待查找的值
     * @return 返回对应下标, 查找失败返回-1
     */
    public static int fibonacciSearch(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;
        int k = 0;//斐波那契分割数值下标
        int mid = 0;
        int F[] = Fibonacci();
        //获取斐波那契分割数值下标
        while (right > F[k] - 1) {
            k++;
        }
        //若数组长度不足F[k],则构造新数组指向原数组,不足部分填充为0
        int[] temp = Arrays.copyOf(array, F[k]);
        //将0填充转换为F[k]
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = array[right];
        }
        //
        while (left <= right) {
            mid = left + F[k - 1] - 1;
            if (value < temp[mid]) {
                right = mid - 1;
                k--;
            } else if (value > temp[mid]) {
                left = mid + 1;
                k -= 2;

            } else {
                if (mid <= right) {
                    return mid;
                } else {
                    return right;
                }
            }

        }
        return -1;
    }
}
