package Stack;
//栈实现综合计算器(中缀表达式)
public class Calculator {
    public static void main(String[] args) {
        //
        String expression = "35+2*6-12/6";
        //创建两个栈,一个数栈,一个符号栈
        ArrayStack2 numstack = new ArrayStack2(10);
        ArrayStack2 operstack = new ArrayStack2(10);
        //定义需要的相关变量
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//每次扫描到的字符保存到ch
        String num = "";//用于拼接多位数
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch,做相应处理
            if (operstack.isOper(ch)) {
                //判断符号栈是否为空
                if (!operstack.isEmpty()) {
                    //如果符号栈有操作符就进行比较
                    if (operstack.priority(ch) <= operstack.priority(operstack.peek())) {
                        num1 = numstack.pop();
                        num2 = numstack.pop();
                        oper = operstack.pop();
                        res = numstack.cal(num1, num2, oper);
                        //将运算结果入数栈
                        numstack.push(res);
                        //将当前操作符入符号栈
                        operstack.push(ch);
                    } else {
                        //若当前操作符优先级大于栈中操作符,则直接入栈
                        operstack.push(ch);
                    }
                } else {
                    //如果为空则直接入符号栈
                    operstack.push(ch);
                }
            } else {
                //numstack.push(ch - 48);//参考ASCII码表
                //不能发现是数就立刻入栈,因为可能是多位数
                //当扫描到数时,继续扫描下一位,若还是数则继续扫描直到出现符号
                //创建字符串变量拼接数字为多位数
                num += ch;
                //若ch已经是最后一位,则直接入栈
                if (index == expression.length() - 1) {
                    numstack.push(Integer.parseInt(num));
                } else {
                    //判断下一位
                    if (operstack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符,则入栈
                        numstack.push(Integer.parseInt(num));
                        //!!!!!!!!!!!!此处必须清空num
                        num = "";
                    }
                }
            }
            //令index后移,并判断是否到expression最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        while (true) {
            if (operstack.isEmpty()) {
                break;
            }
            num1 = numstack.pop();
            num2 = numstack.pop();
            oper = operstack.pop();
            res = numstack.cal(num1, num2, oper);
            numstack.push(res);//入栈
        }
        System.out.printf("表达式%s = %d", expression, numstack.pop());
    }
}

class ArrayStack2 {
    private int maxSize;//栈的大小
    private int[] stack;//数组模拟栈,数据存在该数组中
    private int top = -1;

    //构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈-push
    public void push(int value) {
        if (isFull()) {
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        //先判断栈是否为空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //查看栈顶的值但是不popchu
    public int peek() {
        return stack[top];
    }

    //遍历并显示栈,从栈顶开始遍历数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        //从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }

    //返回运算符的优先级,优先级由开发者确定,优先级使用数字表示
    //数字越大,优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';

    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
