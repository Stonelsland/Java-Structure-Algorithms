package LinkedList;

public class Josephu {
    public static void main(String[] args) {
        //测试构建环形与遍历
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addChild(20);
        circleSingleLinkedList.showChild();


        //测试JosePhu问题
        circleSingleLinkedList.countChild(4,7,20);
    }
}

//创建环形单向链表
class CircleSingleLinkedList {
    //创建一个first节点;
    private Child first = new Child(-1);

    //添加节点构成环形链表
    public void addChild(int nums) {
        //对nums进行数据校验
        if (nums < 1) {
            System.out.println("nums值不正确");
            return;
        }
        Child cur = null;//创建辅助变量帮助构建环形链表
        //使用for创建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号创建节点
            Child child = new Child(i);
            //如果是第一个
            if (i == 1) {
                first = child;
                first.setNext(first);//构成环状
                cur = first;//令cur指向第一个节点
            } else {
                cur.setNext(child);
                child.setNext(first);
                cur = child;
            }
        }
    }

    //遍历当前环形链表
    public void showChild() {
        //判断是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Child cur = first;
        while (true) {
            System.out.printf("编号为%d\n", cur.getNo());
            if (cur.getNext() == first) {//遍历完毕
                break;
            }
            cur = cur.getNext();//cur后移
        }
    }
    //根据用户的输入计算出圈顺序

    /**
     * @param startNo  表示从第几个人开始数
     * @param countNum 表示数的次数
     * @param nums     表示最初有多少人在圈中
     */
    public void countChild(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误,请重新输入");
            return;
        }

        //创建类辅助指针
        Child helper = first;
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //报数前先让first和helper移动k-1次
        for (int j = 0; j < startNo-1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //当报数时,令first和helper指针同时移动m-1次,然后出圈
        //这里是一个循环操作,知道圈中只有一个节点
        while (true){
            if (helper == first){//圈中只有一个节点
                break;
            }
            //令first和helper指针同时移动countNum-1次
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点就是要出圈的人
            System.out.printf("%d出圈\n",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的编号为%d\n",first.getNo());
    }
}

//创建Child类,表示一个节点
class Child {
    private int no;
    private Child next;

    public Child(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Child getNext() {
        return next;
    }

    public void setNext(Child next) {
        this.next = next;
    }
}
