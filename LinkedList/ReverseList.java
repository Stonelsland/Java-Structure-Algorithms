package LinkedList;

//反转单链表
/*
思路:
1. 先定义一个节点reserveHead = newNode();
2.从头到尾遍历原来的链表,每遍历一个节点就将其取出放在reserveHead的最前端
3.原来的链表的head.next = reserveHead.next
 */
public class ReverseList {
    //将单链表进行反转
    public static void reverseList(HeroNode head){
        //如果当前链表为空,或者只有一个节点,无需反转直接返回
        if (head.next == null || head.next.next == null){
            return;
        }
        //定义一个辅助变量(指针)遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        //2.从头到尾遍历原来的链表,每遍历一个节点就将其取出放在reserveHead的最前端
        while (cur != null){
            next = cur.next;//先保存当前节点的下一个节点,后面需要用到
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur;//将cur连接到新的链表上
            cur = next;//让cur后移
        }
        //将head.next 指向reserveHead.next,实现单链表反转
        head.next = reverseHead.next;
    }
}
