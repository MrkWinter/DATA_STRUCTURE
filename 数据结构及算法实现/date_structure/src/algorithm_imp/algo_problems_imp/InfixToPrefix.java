package algorithm_imp.algo_problems_imp;

/**
 * @author MrkWinter
 * @version 1.0
 * 3. 中缀表达式转后缀表达式问题
 */
public class InfixToPrefix {
    public static void main(String[] args) {
        String s = new InfixToPrefix().infixToPrefix("(1+1)*3");
        System.out.println(s);
    }

    public String infixToPrefix(String expression) {
        //初始化数字栈 和 符号栈
        ArrayStack2 numStack = new ArrayStack2(20);
        ArrayStack2 opeStack = new ArrayStack2(20);
        char[] charArray = expression.toCharArray();
        //使用到的变量
        String spl = "";
        String opera = null;
        String result = "";
        //循环符号 在栈中进行操作 得到 后序表达式
        for (int i = 0; i < charArray.length; i++) {
            char curChar = charArray[i];
            if (ArrayStack2.isOperator(curChar)) {
                //是符号
                if (curChar == ')') {
                    while (true) {
                        opera = opeStack.pop();
                        if (opera.charAt(0) == '(')
                            break;
                        numStack.push(opera);
                    }
                } else {
                    while (true) {
                        if (opeStack.isEmpty() || curChar == '(' ||
                                ArrayStack2.priority(opeStack.peek().charAt(0)) < ArrayStack2.priority(curChar)) {
                            opeStack.push(curChar + "");
                            break;
                        } else {
                            numStack.push(opeStack.pop());
                        }
                    }
                }
            } else {
                //是数字
                spl += curChar;
                if (i + 1 == charArray.length || ArrayStack2.isOperator(charArray[i + 1])) {
                    numStack.push(spl);
                    spl = "";
                }
            }
        }
        while (!opeStack.isEmpty()) {
            numStack.push(opeStack.pop());
        }
        while (!numStack.isEmpty()) {
            result = numStack.pop() + result;
        }
        return result;
    }
}

class ArrayStack2 {
    private int maxSize;
    private int top;
    private String[] stackArr;

    //初始化栈
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        stackArr = new String[maxSize];
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
    public void push(String num) {
        if (isFull()) {
            throw new RuntimeException("栈满");
        }
        stackArr[++top] = num;
    }

    //出栈
    public String pop() {
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
    public String peek() {
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