package LinkedList;


//获取单链表的节点个数(若有头节点的链表则不统计头节点)
public class LinkedSizeDemo extends SingleLinkedList {
    /**
     * @param head 链表的头节点
     * @return 返回有效节点的个数
     */
    public static int getSize(HeroNode head) {
        if (head.next == null) {//空链表
            return 0;
        }
        int size = 0;
        //不统计头节点
        HeroNode cur = head.next;
        while (cur != null){
            size++;
            cur = cur.next;
        }
        return size;
    }

    public static void main(String[] args) {
        //这里把求有效节点单独列出方便阅读 但是无法单独运行,若想检测代码,复制代码块到链表类中即可
       // System.out.println("有效的节点个数 ="+ getSize(SingleLinkedList. getHead()));
    }

}
