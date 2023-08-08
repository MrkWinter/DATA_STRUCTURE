package date_structure_imp;

/**
 * @author MrkWinter
 * @version 1.0
 * 4. 栈的实现
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);

        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.showStack();
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
}
