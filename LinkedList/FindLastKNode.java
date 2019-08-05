package LinkedList;

public class FindLastKNode {
    //查找单链表的倒数第k个节点
    /*
    思路
    1. 编写一个方法,接收head节点,同时接收一个index
    2.index表示的是倒数第index个节点
    3.先把链表从头到尾遍历,得到链表的总长度getSize
    4.得到Size后,从链表第一个开始遍历(size-index)
    */
    public static HeroNode findLastIndexCode(HeroNode head, int index) {
        //判断为空 没有找到
        if (head.next == null) {
            return null;//没有找到
        }
        //第一个遍历的到链表的长度
        int size = LinkedSizeDemo.getSize(head);
        //第二次遍历size-index位置便是要找到的倒数第k个节点
        //先对index进行校验
        if (index <= 0 || index > size){
            return null;
        }
        //定义辅助变量 for循环定位
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }
}
