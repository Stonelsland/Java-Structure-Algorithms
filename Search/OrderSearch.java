package Search;

//顺序查找(线性查找)
public class OrderSearch {
    public static void main(String[] args) {
        int array[] ={3,8,14,-1,39,27,70};
        int index = orderSearch(array,114);
        if (index != -1){
            System.out.println("找到了,是第"+(index+1)+"个");
        }else {
            System.out.println("没找到");
        }

    }

    /**
     * 找到一个满足条件的值就但会
     * @param array
     * @param value
     * @return
     */
    public  static int orderSearch(int[] array,int value){
        //线性查找逐一比对,发现相同数值返回下标
        for (int i = 0; i < array.length; i++) {
            if (array[i]==value){
                return i;
            }
        }
        return -1;
    }
}
