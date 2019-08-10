package Recursion;

public class RecursionTest {
    //通过实例描述递归调用机制
    public static void main(String[] args) {
        int n = 1;
        Print(5);
        Factorial(n);
        System.out.println(n);
    }

    //打印问题
    public static void Print(int n){
        if (n>2){
            Print(n-1);
        }
        System.out.println("n="+n);
    }

    //阶乘问题
    public static int Factorial(int n){
        if (n==1){
            return 1;
        }else {
            return Factorial(n-1)*n;
        }
    }
}
