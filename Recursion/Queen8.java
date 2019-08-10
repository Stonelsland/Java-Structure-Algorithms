package Recursion;

//八皇后问题
public class Queen8 {
    //定义皇后个数
    int max = 8;
    int[] queen = new int[max];
    static int count = 0;//统计解法个数

    public static void main(String[] args) {

        //测试
        Queen8 queen8 = new Queen8();
        queen8.place(0);
        System.out.println("共有"+count+"个解法");

    }

    //放置第n个皇后
    //[注]place每一次递归时都执行一次for循环,因此会有回溯
    private void place(int n){
        if (n==max){
            showQueen();
            return;
        }
        //依次放入皇后并判断是否冲突
        for (int i = 0; i < max; i++) {
            //将当前皇后放入对应行的第一列
            queen[n] = i;
            //判断当放置到第i列时是否冲突
            if (determine(n)){
                place(n+1);
            }
            //若冲突,则继续执行queen[n] = i;即将当前皇后在当前行后移一个位置
        }
    }

    //检测当放置第n个皇后时,是否与已经摆放皇后的位置条件冲突
    /**
     * @param n
     * @return
     */
    private boolean determine(int n) {
        for (int i = 0; i < n; i++) {
            //queen[i] == queen[n]条件为判断当前皇后是否与前面的所有皇后在同一列
            //Math.abs(n - i) == Math.abs(queen[n] - queen[i]条件为判断当前皇后是否与前面的所有皇后在同一斜线
            //判断是否同一斜线的原理即使判断行数差与列数差是否相等
            if (queen[i] == queen[n] || Math.abs(n - i) == Math.abs(queen[n] - queen[i])) {
                return false;
            }
        }
        return true;
    }

    //输出皇后摆放位置
    private void showQueen() {
        count++;
        for (int i = 0; i < queen.length; i++) {
            System.out.print(queen[i] + " ");
        }
        System.out.println();
    }
}
