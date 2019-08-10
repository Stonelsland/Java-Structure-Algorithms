package Stack;

import com.sun.xml.internal.ws.client.sei.ResponseBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {

        //将中缀表达式转换为后缀表达式
        //1.直接对str不便进行操作,故转换为中缀表达式对应的list
        //测试中缀表达式list输出
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println(infixExpressionList);

        //2.将得到的中缀表达式list转换为对应的后缀表达式
        List<String> infixToSuffix = InfixToSuffix(infixExpressionList);
        System.out.println(infixToSuffix);

        //3.将转换后的后缀表达式计算结果
        int res = cal(infixToSuffix);
        System.out.println("计算结果为" + res);

        /*
        //定义逆波兰表达式
        //(3+4)x5-6 ==> 3 4 + 5 x 6 -
        String suffixExpression = "3 4 + 5 x 6 -";
        //先将表达式放入arraylist中x
        //将ArrayList传递给一个方法,遍历ArrayList配合栈完成计算
        List<String> list = getListString(suffixExpression);
        System.out.println("表达式为" + list);

        int res = cal(list);
        System.out.println("计算结果为" + res);
         */

    }


    //方法:将中缀表达式转换为对应的list
    public static List<String> toInfixExpressionList(String s) {
        //定义一个list,存放中缀表达式中的内容
        List<String> list = new ArrayList<String>();
        int i = 0;//相当于指针,用于遍历中缀表达式字符串
        String str;//多位数拼接
        char c;//每遍历一个字符,就放入到c
        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                list.add("" + c);
                i++;
            } else {
                str = "";//将str置空
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;//多位数拼接
                    i++;
                }
                list.add(str);
            }
        } while (i < s.length());
        return list;
    }

    //将中缀表达式转换为后缀表达式
    public static List<String> InfixToSuffix(List<String> list) {
        //定义两个栈
        Stack<String> s1 = new Stack<String>();//符号栈
        //Stack<String> s2 = new Stack<String>();//中间栈
        //s2在整个转换过程中并不存在pop操作且最终需要逆序输出
        //故这里将s2栈简化为List来存储中间运算结果
        List<String> s2 = new ArrayList<String>();

        //遍历
        for (String item : list) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //若扫描到")",则依次弹出s1栈顶的运算符并压入s2
                //直到遇到"("为止,此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//将"("弹出s1栈
            } else {
                //当item优先级小于等于s1的栈顶运算符时,将s1栈顶运算符弹出至s2中,并重复4.1步骤与新的s1栈顶运算符比较
                while (s1.size() != 0 && Operator.getValue(s1.peek()) >= Operator.getValue(item)) {
                    s2.add(s1.pop());
                }
                //将item入栈
                s1.push(item);
            }
        }
        //将s1中剩余预算符全部依次弹出入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    //将一个逆波兰表达式将数据和运算符放到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        //将表达式分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String exp : split) {
            list.add(exp);
        }
        return list;
    }

    public static int cal(List<String> list) {
        Stack<String> stack = new Stack<String>();
        for (String cram : list) {
            if (cram.matches("\\d+")) {
                stack.push(cram);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                switch (cram) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        System.out.println("运算符有误");
                        break;

                }
                stack.push("" + res);
            }

        }
        return Integer.parseInt(stack.pop());
    }
}

//定义Operator类返回运算符优先级
class Operator {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 1;
    private static int DIV = 1;

    //定义方法返回优先级数字
    public static int getValue(String operator) {
        int result = 0;
        switch (operator) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("Operator Error");
                break;
        }
        return result;
    }
}