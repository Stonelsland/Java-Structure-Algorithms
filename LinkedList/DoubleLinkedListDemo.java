package LinkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {

        //测试
        System.out.println("双向链表测试");
        //创建节点
        HeroNode1 heroNode1 = new HeroNode1(1, "宋江", "及时雨");
        HeroNode1 heroNode2 = new HeroNode1(2, "卢俊义", "玉麒麟");
        HeroNode1 heroNode3 = new HeroNode1(3, "吴用", "智多星");
        HeroNode1 heroNode4 = new HeroNode1(4, "林冲", "豹子头");

        //创建链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        //测试加入
//        doubleLinkedList.add(heroNode1);
//        doubleLinkedList.add(heroNode2);
//        doubleLinkedList.add(heroNode3);
//        doubleLinkedList.add(heroNode4);

        doubleLinkedList.addByOrder(heroNode1);
        doubleLinkedList.addByOrder(heroNode3);
        doubleLinkedList.addByOrder(heroNode4);
        doubleLinkedList.addByOrder(heroNode2);
        doubleLinkedList.list();

        //修改测试
        HeroNode1 newHeroNode = new HeroNode1(4,"公孙胜","入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.delete(3);
        System.out.println("删除后的链表");
        doubleLinkedList.list();
    }
}

//创建双向链表类
class DoubleLinkedList{

    private HeroNode1 head = new HeroNode1(0, "", "");

    public HeroNode1 getHead() {
        return head;
    }

    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode1 temp = head.next;
        while (true) {
            //判断是否到链表尾
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
    public void add(HeroNode1 heroNode) {
        //因head节点不能动，故创建辅助变量temp
        HeroNode1 temp = head;
        //遍历链表，找到最后节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果没有找到，将temp后移
            temp = temp.next;
        }
        //当退出while循环时temp到了链表的最后
        //temp.next = heroNode;
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    //第二种方式在添加英雄时,根据排名将英雄插入指定位置
    //如果排名已经存在则提示添加失败
    public void addByOrder(HeroNode1 heroNode) {
        //双向链表按顺序添加
        HeroNode1 temp = head;
        boolean flag = false;//flag标志添加的编号是否存在,默认为false
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                //位置定位成功,在temp后添加
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("插入冲突,已存在");
        } else {
            heroNode.next = temp.next;
            heroNode.pre = temp;
            temp.next = heroNode;
        }
    }
    //修改节点信息,根据no定位修改,但no编号不能更改
    //双向链表节点内容修改和单链表相同
    public void update(HeroNode1 newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点,根据no编号
        //定义一个辅助变量
        HeroNode1 temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {
                break;//链表遍历结束
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到预修改节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号为%d的节点,修改失败\n", newHeroNode.no);

        }
    }

    //从双向链表中删除节点
    //对于双向链表，可以直接找到待删除节点自我删除
    public void delete(int no){

        //判断当前链表是否为空
        if (head.next == null){
            System.out.println("链表为空");
            return;
        }

        HeroNode1 temp = head.next;
        boolean flag = false;//标记是否找到待删除节点
        while (true){
            if (temp.next == null){//已到链表最后节点的next
                break;
            }
            if (temp.no == no){
                //找到待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){//找到
            temp.pre.next = temp.next;
            //需要先判断待删除节点是否为最后一个节点，否则可能出现空指针
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }

        }else {
            System.out.println("没有找到待删除节点");
        }
    }

}

//定义HeroNode 每个对象就是一个节点
class HeroNode1 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode1 next;
    public HeroNode1 pre;

    //构造器
    public HeroNode1(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\''
                + '}';
    }
}
