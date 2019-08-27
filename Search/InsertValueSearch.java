package Search;

public class InsertValueSearch {
    public static void main(String[] args) {

        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }
        //对比插值查找与二分查找
        int indexi = insertValueSearch(array, 0, array.length - 1, 1);
        System.out.println(indexi);
        int indexb = binarySearch(array, 0, array.length - 1, 1);
        System.out.println(indexb);

    }

    public static int insertValueSearch(int[] array, int left, int right, int value) {
        System.out.println("插值查找执行");
        if (left > right || value < array[0] || value > array[array.length - 1]) {
            return -1;
        }
        //插值算法核心公式，计算自适应中值
        int mid = left + (right - left) * (value - array[left] / array[right] - array[left]);
        int midValue = array[mid];
        if (value > midValue) {
            return insertValueSearch(array, mid + 1, right, value);
        } else if (value < midValue) {
            return insertValueSearch(array, left, mid - 1, value);
        } else {
            return mid;
        }
    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        System.out.println("二分查找执行");
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

}
