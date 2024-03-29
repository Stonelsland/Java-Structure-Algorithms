package Queue;
import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        CircleArray circle = new CircleArray(5);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取数据");

            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    circle.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int value = scanner.nextInt();
                    circle.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circle.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circle.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");

    }
}
class CircleArray{
    private int maxSize;//数组最大容量
    //front变量含义调整为指向队列的第一个元素
    private int front;//队列头
    //rear变量含义调整为指向队列最后一个元素的后一个位置 初始值为0
    private int rear;//队列尾
    private int[] array;//存放数据模拟队列

    public CircleArray(int arrayMaxSize){
        maxSize = arrayMaxSize;
        array = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return  rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否为满
        if (isFull()){
            System.out.println("队列已满，不能加入");
            return;
        }
        //直接将数据加入
        array[rear] = n;
        //将rear后移，考虑取模
        rear = (rear+1)%maxSize;
    }

    //获取队列的数据
    public int getQueue(){
        //判断是否为空
        if (isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        //这里需要分析front是指向队列的第一个元素
        //1.先把front对应的值保存到一个临时变量中
        //2.将front后移,考虑取模
        //3.将临时保存的变量返回
        int value = array[front];
        front = (front+1)%maxSize;
        return value;
    }

    // 求出当前有效数据的个数
    public int Size(){
        return (rear + maxSize - front) % maxSize;
    }
    //显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
//        for (int i = 0; i < array.length; i++) {
//            System.out.printf("array[%d] = %d\n",i,array[i]);
//        }
        //从front开始遍历，遍历多少个元素
        for (int i = front; i < front + Size(); i++) {
            System.out.printf("array[%d] = %d\n",i % maxSize,array[i % maxSize]);
        }
    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        return array[front];
    }

}
