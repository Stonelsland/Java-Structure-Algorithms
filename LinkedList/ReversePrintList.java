package LinkedList;

import java.util.Stack;

/*
从尾到头打印链表
方式1:先将单链表反转,再遍历进行打印,但是会破坏链表的结构,不建议采用
方式2:可以利用栈这个数据结构,将各个节点压入栈中,利用栈先进后出的特点,就实现了逆序打印的效果
本次代码的实现将采用方式2
 */
public class ReversePrintList {
    public static void main(String[] args) {
        //reversePrint(SingleLinkedList.getHead());
    }

    public static void  reversePrint(HeroNode head){
        if (head.next ==null){
            return;
        }
        //创建一个栈,将各个节点压入栈
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈中
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        //将栈中的节点进行pop出栈打印
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}
