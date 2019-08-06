package LinkedList;

import java.util.Stack;
//栈的基本使用
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");
        while (stack.size()>0){
            System.out.println(stack.pop());//pop即是将栈顶的数据取出
        }
    }
}
