package Tree;

public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(array);
        arrayBinaryTree.preOrder(0);
    }
}
//ArrayBinaryTree类 实现顺序存储
class ArrayBinaryTree{
    private int[] array;

    public ArrayBinaryTree(int[] array) {
        this.array = array;
    }

    //顺序存储二叉树前序遍历
    public void preOrder(int index){
        if (array==null||array.length<=0){
            System.out.println("数组为空!");
        }
        System.out.print(array[index]+"\t");
        //向左递归
        if (2*index+1<array.length){
            preOrder(2*index+1);
        }
        //向右递归
        if (2*index+2<array.length){
            preOrder(2*index+2);
        }
    }
}