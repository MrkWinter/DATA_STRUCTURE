package algorithm_imp.algo_problems_imp;

/**
 * @author MrkWinter
 * @version 1.0
 * 1 约瑟夫环问题
 */
public class Joseph {
    public static void main(String[] args) {
        new Joseph().josephRing(20, 4, 3);
    }

    public void josephRing(int nums, int begin, int k) {
        new LinkList(nums).showRingByOrder(begin, k);
    }
}

class LinkList {
    private LinkNode firstNode;
    private LinkNode endNode = null;
//添加一个函数根据 nums 形成一个环
    public LinkList(int nums) {
        if (nums < 1) {
            throw new RuntimeException("模拟环编号数应大于0");
        }
        for (int i = 1; i < nums + 1; i++) {
            if (i == 1) {
                firstNode = new LinkNode(i);
                endNode = firstNode;
            } else {
                endNode.next = new LinkNode(i);
                endNode = endNode.next;
            }
            endNode.next = firstNode;
        }
    }
//添加一个函数根据 根据 参数 不断输出出环的编号
    public void showRingByOrder(int begin, int k) {
        if (begin < 1 || k < 1) {
            throw new RuntimeException("模拟环开始和跳过编号应大于0");
        }
        LinkNode curNode = firstNode;
        LinkNode behindNode = endNode;
        for (int i = 0; i < begin - 1; i++) {
            curNode = curNode.next;
            behindNode = behindNode.next;
        }
        while (true) {
            if (curNode == behindNode) {
                System.out.println(curNode);
                return;
            }
            for (int i = 0; i < k - 1; i++) {
                curNode = curNode.next;
                behindNode = behindNode.next;
            }
            System.out.println(curNode);
            curNode = curNode.next;
            behindNode.next = curNode;
        }
    }
}

class LinkNode {
    public int no;
    public LinkNode next;

    public LinkNode(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "LinkNode{" +
                "no=" + no +
                '}';
    }
}



