package date_structure_imp;

/**
 * @author MrkWinter
 * @version 1.0
 * 2 队列实现
 */
public class ArrayQueueDemo {
    private int front;
    private int rear;
    private int maxSize;
    private int[] arr;
    //创建数组构造器
    public ArrayQueueDemo(int size) {
        arr = new int[size];
        maxSize = size;
    }

    //判断队列为空
    public boolean isEmpty() {
        return front == rear;
    }

    //判断队列为满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //取得队列中元素个数
    public int getCount() {
        return (rear + maxSize - front) % maxSize;
    }

    //取得队头元素
    public int getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列无元素");
        }
        return arr[front];
    }

    //添加元素
    public void putQueue(int num) {
        if (isFull()) {
            throw new RuntimeException("队列满");
        }
        arr[rear] = num;
        rear = (rear + 1) % maxSize;
    }
    //得到元素
    public int getQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列无元素");
        }
        int temp = arr[front];
        front = (front+1)%maxSize;
        return temp;
    }
    //遍历队列元素
    public void showQueue() {
        for (int i = front; i < front + getCount(); i++) {
            System.out.print(arr[i%maxSize] + "\t");
        }
    }
}
