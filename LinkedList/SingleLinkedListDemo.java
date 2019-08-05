package LinkedList;

//单链表实现水浒传英雄管理
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        //创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //测试加入
//        singleLinkedList.add(heroNode1);
//        singleLinkedList.add(heroNode2);
//        singleLinkedList.add(heroNode3);
//        singleLinkedList.add(heroNode4);

        //测试顺序加入
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);

        //显示
        singleLinkedList.list();

        //测试修改节点
        HeroNode newHeroNode = new HeroNode(2, "卢本伟", "五五开");
        singleLinkedList.update(newHeroNode);
        System.out.println("修改后链表如下");
        singleLinkedList.list();

        //测试删除节点
        singleLinkedList.delete(1);
        System.out.println("删除节点后链表如下");
        singleLinkedList.list();

    }
}

//定义SingleLinkedList，管理英雄数据
class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点到单向链表
    /*
    思路：在不考虑编号顺序时
    1.找到当前链表的最后节点
    2.将最后节点的next 指向下一个新的节点
     */
    public void add(HeroNode heroNode) {
        //因head节点不能动，故创建辅助变量temp
        HeroNode temp = head;
        //遍历链表，找到最后节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果没有找到，将temp后移
            temp = temp.next;
        }
        //当退出while循环时temp到了链表的最后
        temp.next = heroNode;
    }

    //第二种方式在添加英雄时,根据排名将英雄插入指定位置
    //如果排名已经存在则提示添加失败
    public void addByOrder(HeroNode heroNode) {
        //头节点不能动,因此仍然通过辅助变量定位添加位置
        //因为单链表,则temp位于添加位置的前一个节点,否则不能插入
        HeroNode temp = head;
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
            temp.next = heroNode;
        }
    }


    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表尾
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //修改节点信息,根据no定位修改,但no编号不能更改
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点,根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
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

    //删除节点
    //仍需辅助变量temp辅助找到待删除节点的前一个节点
    //比较时是temp.next.no与待删除节点的no相比较
    public void delete(int no){
        HeroNode temp = head;
        boolean flag = false;//标记是否找到待删除节点
        while (true){
            if (temp.next == null){
                break;
            }
            if (temp.next.no == no){
                //找到待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){//找到
            temp.next = temp.next.next;
        }else {
            System.out.println("没有找到待删除节点");
        }
    }

}

//定义HeroNode 每个对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    //构造器
    public HeroNode(int no, String name, String nickname) {
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
