package Sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {4, 6, 8, 5, 9,-11,98,-845,12,1};
        heapSort(array);

    }

    public static void heapSort(int array[]) {
        System.out.println("堆排序");
        int temp = 0;
        //将无序序列构建成一个堆,根据升序降序需求选择大顶堆或小顶堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }
        //将堆顶元素与末尾元素交换,将最大元素沉到数组末端
        for (int j = array.length - 1; j > 0; j--) {
            temp = array[j];
            array[j] = array[0];
            array[0] = temp;
            adjustHeap(array, 0, j);
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 将一个数组(二叉树)调整为一个大顶堆
     * 完成将以i对应的非叶子结点的树调整成大顶堆
     *
     * @param array  待调整数组
     * @param i      非叶子节点在数组中索引
     * @param length 对多少个元素进行调整
     */
    public static void adjustHeap(int array[], int i, int length) {

        //取出当前元素的值保存在临时变量中
        int temp = array[i];
        //开始调整
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && array[k] < array[k + 1]) {//左子结点小于右子结点
                k++;//k指向右子结点
            }
            if (array[k] > temp) {//子结点大于父节点
                array[i] = array[k];//把较大的值赋给当前结点
                i = k;
            } else {
                break;
            }
        }
        //循环结束后,已经将以i为父节点的最大值放在了最顶
        array[i] = temp;//将temp值放在调整后的位置
    }
}
