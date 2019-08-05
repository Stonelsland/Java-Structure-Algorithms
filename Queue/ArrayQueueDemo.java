package Queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        //创建队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
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
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
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

class ArrayQueue{
    private int maxSize;//数组最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] array;//存放数据模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrayMaxSize){
        maxSize = arrayMaxSize;
        array = new int[maxSize];
        front = -1;//指向队列头部前一个位置
        rear = -1;//指向队列尾部，指向队列尾得数据（即队列最后一个数）
    }


    //判断队列是否为满
    public boolean isFull(){
        return rear == maxSize -1;
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
        rear++;
        array[rear] = n;
    }

    //获取队列的数据
    public int getQueue(){
        //判断是否为空
        if (isEmpty()){
            //通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return array[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d] = %d\n",i,array[i]);
        }
    }

    //显示队列头部数据，不是取出数据
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，不能取数据");
        }
        return array[front+1];
    }

}
