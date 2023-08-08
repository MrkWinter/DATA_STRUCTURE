package algorithm_imp.algo_problems_imp;

/**
 * @author MrkWinter
 * @version 1.0
 * 2 计数器 问题实现
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "3*(2+45)";
        int calculate = calculate(expression);
        System.out.println(calculate);
    }

    public static int calculate(String expression) {
        //初始化数字栈和符号栈
        ArrayStack numStack = new ArrayStack(20);
        ArrayStack opeStack = new ArrayStack(20);
        char[] expCharArr = expression.toCharArray();
        //初始化所用变量
        String spl = "";
        int num1 = 0;
        int num2 = 0;
        char operator = 0;
        int result = 0;
        //遍历表达式 计算或放入对应的栈中
        for (int i = 0; i < expCharArr.length; i++) {
            char curChar = expCharArr[i];
            if (ArrayStack.isOperator(curChar)) {
                //符号栈
                if (opeStack.isEmpty())
                    opeStack.push(curChar);
                else if (curChar == '(')
                    opeStack.push(curChar);
                else if (curChar == ')') {
                    while ((operator = (char) opeStack.pop())!='(') {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        result = ArrayStack.simpleCal(num2, num1, operator);
                        numStack.push(result);
                    }
                } else {
                    if (ArrayStack.priority((char) opeStack.peek()) > ArrayStack.priority(curChar)) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        operator = (char) opeStack.pop();
                        result = ArrayStack.simpleCal(num2, num1, operator);
                        numStack.push(result);
                        opeStack.push(curChar);
                    } else {
                        opeStack.push(curChar);
                    }
                }
            } else {
                //数字栈
                spl += curChar;
                if (i + 1 == expCharArr.length || ArrayStack.isOperator(expCharArr[i + 1])) {
                    //下一个是符号
                    numStack.push(Integer.parseInt(spl));
                    spl = "";
                }
            }
        }
        //符号加入栈完毕 开始出栈计算
        while (numStack.getNum() != 1) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            operator = (char) opeStack.pop();
            result = ArrayStack.simpleCal(num2, num1, operator);
            numStack.push(result);
        }
        return numStack.peek();
    }
}

class ArrayStack {
    private int maxSize;
    private int top;
    private int[] stackArr;

    //初始化栈
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        stackArr = new int[maxSize];
    }

    //判断栈为空
    public boolean isEmpty() {
        return top == -1;
    }

    //判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //入栈
    public void push(int num) {
        if (isFull()) {
            throw new RuntimeException("栈满");
        }
        stackArr[++top] = num;
    }

    //出栈
    public int pop() {
        if (isFull()) {
            throw new RuntimeException("栈空");
        }
        return stackArr[top--];
    }

    //显示栈
    public void showStack() {
        if (isEmpty()) {
            System.out.println("空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArr[i] + " ");
        }
    }

    //查看栈顶元素
    public int peek() {
        return stackArr[top];
    }

    //查看栈中元素个数
    public int getNum() {
        return top + 1;
    }

    //判断运算符优先级
    public static int priority(char operator) {
        if (operator == '/' || operator == '*')
            return 1;
        if (operator == '+' || operator == '-')
            return 0;
        else
            return -1;
    }

    //简单计算
    public static int simpleCal(int num1, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                result = 0;
                break;
        }
        return result;
    }

    //判断是否为运算符
    public static boolean isOperator(char operator) {
        if (operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '(' || operator == ')') {
            return true;
        }
        return false;
    }
}