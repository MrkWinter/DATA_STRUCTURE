package date_structure_imp;

import java.util.Stack;

/**
 * @author MrkWinter
 * @version 1.0
 * 3 单链表的演示
 */
public class SingleLinkList {
    private final HeroNode headNode = new HeroNode(0, null, null);
    private HeroNode endNode = headNode;

    //判断链表为空
    public boolean isEmpty() {
        return headNode.next == null;
    }

    //得到链表中元素个数
    public int getCount() {
        HeroNode temp = headNode;
        int count = 0;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    //直接尾部插入
    public void putValueEnd(HeroNode heroNode) {
        endNode.next = heroNode;
        endNode = heroNode;
    }

    //头部插入
    public void putValueHead(HeroNode heroNode) {
        heroNode.next = headNode.next;
        headNode.next = heroNode;
    }

    //按编号插入
    public void putValueByNo(HeroNode heroNode) {
        HeroNode temp = headNode;
        while (true) {
            if (temp.next == null) {
                putValueEnd(heroNode);
                break;
            }
            if (temp.next.no == heroNode.no) {
                System.out.println("该编号已存在");
                break;
            }
            if (temp.next.no > heroNode.no) {
                heroNode.next = temp.next;
                temp.next = heroNode;
                break;
            }
            temp = temp.next;
        }
    }

    //遍历打印链表
    public void showLinkList() {
        HeroNode temp = headNode.next;
        if (isEmpty()) {
            System.out.println("空");
            return;
        }
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //删除元素
    public void deleteByNo(int no) {
        HeroNode temp = headNode;
        boolean flag = true;
        while (temp.next != null) {
            if (temp.next.no == no) {
                HeroNode temp2 = temp.next.next;
                temp.next = temp2;
                flag = false;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("未有该元素");
        }
    }

    //返回倒数第n个结点
    public HeroNode getValueEndByN(int n) {
        int count = getCount();
        if (n < 0 || n > count) {
            return null;
        }
        HeroNode temp = headNode;
        for (int i = 0; i < count - n; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //链表反转
    public void reverseLinkList() {
        HeroNode temp1 = headNode.next;
        HeroNode temp2 = null;
        HeroNode heroNode = new HeroNode(0, null, null);
        while (temp1 != null) {
            temp2 = temp1.next;
            temp1.next = heroNode.next;
            heroNode.next = temp1;
            temp1 = temp2;
        }
        headNode.next = heroNode.next;
        heroNode.next = null;
    }
    //反向打印链表
    public void reversePrint(HeroNode heroNode) {
        if(heroNode.next == null) {
            return;
        }
        reversePrint(heroNode.next);
        System.out.println(heroNode.next);
    }
    public void reversePrint2(HeroNode heroNode) {
        if(heroNode.next == null) {
            return;
        }
        Stack<HeroNode> heroNodes = new Stack<>();
        HeroNode temp = heroNode.next;
        while (temp != null) {
            heroNodes.push(temp);
            temp = temp.next;
        }
        while (heroNodes.size()>0) {
            HeroNode pop = heroNodes.pop();
            System.out.println(pop);
        }
    }
    //将两个链表合成一个链表！！！！！！！！！！！！！！！

    public HeroNode getHeadNode() {
        return headNode;
    }
}

//单个结点
class HeroNode {
    public int no;
    public String name;
    public HeroNode next;

    public HeroNode(int no, String name, HeroNode next) {
        this.no = no;
        this.name = name;
        this.next = next;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

}
