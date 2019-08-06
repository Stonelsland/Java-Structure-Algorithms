package Stack;

import org.omg.CORBA.ARG_OUT;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {

        //测试ArrayStack
        //创建一个ArrayStack对象表示栈
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;//控制是否退出
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("show");
            System.out.println("exit");
            System.out.println("push");
            System.out.println("pop");
            System.out.println("请输入指令:");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                      int res = stack.pop();
                        System.out.printf("出栈数据为%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }


    }

}
class ArrayStack{
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈,数据存在该数组中
    private int top = -1;

    //构造器
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull(){
        return top == maxSize-1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    //入栈-push
    public void push(int value){
        if (isFull()){
            return;
        }
        top++;
        stack[top]= value;
    }

    //出栈
    public int pop(){
        //先判断栈是否为空
        if (isEmpty()){
            //抛出异常
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历并显示栈,从栈顶开始遍历数据
    public void list(){
        if (isEmpty()){
            System.out.println("栈空");
            return;
        }
        //从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }
}
