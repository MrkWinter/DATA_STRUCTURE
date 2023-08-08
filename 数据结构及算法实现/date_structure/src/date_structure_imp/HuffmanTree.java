package date_structure_imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class HuffmanTree {
    private Node root;//哈夫曼树根结点

    public void createHuffmanTree(int[] arr) {
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.remove(0);
            Node righttNode = nodes.remove(0);
            Node parent = new Node(leftNode.getValue() + righttNode.getValue());
            parent.setLeft(leftNode);
            parent.setRight(righttNode);
            nodes.add(parent);
        }
        root = nodes.get(0);
    }

    public void preOrder() {
        if (root != null) {
            root.preOrder();
        }
    }
}

class Node implements Comparable<Node> {
    private int value;//权重
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null)
            this.left.preOrder();
        if (this.right != null)
            this.right.preOrder();
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
