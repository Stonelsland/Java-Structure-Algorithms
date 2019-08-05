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
        System.out.println("有效的节点个数 ="+ getSize(SingleLinkedList. getHead()));
    }

}
