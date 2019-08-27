package Search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int array[] = {2,2,2,0, 63, 106, 202, 358, 1,462,462,462,1,576, 902, 908,1, 1,913,222,1,222,1112};
        //int index = binarySearch(array, 0, array.length - 1, 555);
//        if (index != -1) {
//            System.out.println("找到了,是第" + (index + 1) + "个");
//        } else {
//            System.out.println("没找到");
//        }
        List<Integer> indexList = binarySearchs(array,0,array.length-1,1);
        System.out.println(indexList);
    }

    //二分查找算法

    /**
     * @param array 数组
     * @param left  左索引
     * @param right 右索引
     * @param value 待查找值
     * @return 找到匹配值返回数组下标, 否则返回-1
     */
    public static int binarySearch(int[] array, int left, int right, int value) {

        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = array[mid];
        if (value < midValue) {//向左递归
            return binarySearch(array, left, mid - 1, value);
        } else if (value > midValue) {//向右递归
            return binarySearch(array, mid + 1, right, value);
        } else {
            return mid;
        }
    }

    //二分查找重复元素算法

    public static ArrayList<Integer> binarySearchs(int[] array, int left, int right, int value) {

        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midValue = array[mid];
        if (value < midValue) {//向左递归
            return binarySearchs(array, left, mid - 1, value);
        } else if (value > midValue) {//向右递归
            return binarySearchs(array, mid + 1, right, value);
        } else {
            ArrayList<Integer> indexList = new ArrayList<Integer>();
            //向mid索引左扫描，满足所有条件的下标加入集合中
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || array[temp] != value) {
                    break;
                }
                //否则，就temp放入到list中
                indexList.add(temp);
                temp--;//temp左移
            }
            indexList.add(mid);
            //向右扫描
            temp = mid + 1;
            while (true) {
                if (temp > array.length - 1 || array[temp] != value) {
                    break;
                }
                //否则，就temp放入到list中
                indexList.add(temp);
                temp++;//temp左移
            }
            return indexList;
        }
    }
}
