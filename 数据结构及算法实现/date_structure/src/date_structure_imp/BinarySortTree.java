package date_structure_imp;

/**
 * @author MrkWinter
 * @version 1.0
 * 1.二叉排序树
 */
public class BinarySortTree {
    private TNode root;
    private DCNodes findNode;

    //成员内部类
    private class DCNodes {
        private TNode parent; //找到父结点位置
        int firstConnect; //0 代表空 左 1 代表左子树 2 代表右子树 3 代表左右子树
        int secondConnect;//同上

        public DCNodes(TNode parent, int firstConnect, int secondConnect) {
            this.parent = parent;
            this.firstConnect = firstConnect;
            this.secondConnect = secondConnect;
        }

        public TNode getParent() {
            return parent;
        }

        public void setParent(TNode parent) {
            this.parent = parent;
        }

        public int getFirstConnect() {
            return firstConnect;
        }

        public void setFirstConnect(int firstConnect) {
            this.firstConnect = firstConnect;
        }

        public int getSecondConnect() {
            return secondConnect;
        }

        public void setSecondConnect(int secondConnect) {
            this.secondConnect = secondConnect;
        }
    }

    //以一个数组构建二叉排序树
    public void createBinarySortTree(int[] arr) {
        if (arr == null && arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            addTNode(new TNode(arr[i]));
        }
    }

    //添加结点
    public void addTNode(TNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //删除结点函数
    public void deleteTNode(int value) {
        if (root == null) {
            System.out.println("根节点为空");
            return;
        }
        //删除的是根结点
        if (root.getValue() == value) {
            if (root.getRight() != null) {
                TNode tNode = retDeleteMinNode(root);
                root.setValue(tNode.getValue());
            } else if (root.getLeft() != null) {
                TNode tNode = retDeleteMaxNode(root);
                root.setValue(tNode.getValue());
            } else {
                root = null;
                return;
            }
            return;
        }
        //找到删除结点以及父结点
        DCNodes cParentNode = findConnectNode(root, value);
        if (cParentNode == null) {
            System.out.println("未找到");
            return;
        }
        TNode parentNode = cParentNode.getParent();
        //1.删除结点为叶子结点
        if (cParentNode.getSecondConnect() == 0) {
            if (cParentNode.getFirstConnect() == 1) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }
        }

        //2.删除结点有一个子结点
        else if (cParentNode.getSecondConnect() == 1 || cParentNode.getSecondConnect() == 2) {
            if (cParentNode.getFirstConnect() == 1) {
                if (cParentNode.getSecondConnect() == 1) {
                    parentNode.setLeft(parentNode.getLeft().getLeft());
                } else {
                    parentNode.setLeft(parentNode.getLeft().getRight());
                }
            } else {
                if (cParentNode.getSecondConnect() == 1) {
                    parentNode.setRight(parentNode.getRight().getLeft());
                } else {
                    parentNode.setRight(parentNode.getRight().getRight());
                }
            }
        }
        //3.删除结点有两子结点
        else {
            if (cParentNode.getFirstConnect() == 1) {
                TNode tNode = retDeleteMaxNode(parentNode.getLeft());
                parentNode.getLeft().setValue(tNode.getValue());
            } else {
                TNode tNode = retDeleteMinNode(parentNode.getRight());
                parentNode.getRight().setValue(tNode.getValue());
            }
        }
    }

    //找到要删除的结点以及相关联的结点
    private DCNodes findConnectNode(TNode node, int value) {
        if (node.getLeft() != null && node.getLeft().getValue() == value) {
            //左子树
            int firstConnect = 1;
            int secondConnect = 0;
            if (node.getLeft().getLeft() != null && node.getLeft().getRight() == null) {
                secondConnect = 1;
            } else if (node.getLeft().getLeft() == null && node.getLeft().getRight() != null) {
                secondConnect = 2;
            } else if (node.getLeft().getLeft() != null && node.getLeft().getRight() != null) {
                secondConnect = 3;
            }
            return new DCNodes(node, firstConnect, secondConnect);
        }
        if (node.getRight() != null && node.getRight().getValue() == value) {
            //右子树
            int firstConnect = 2;
            int secondConnect = 0;
            if (node.getRight().getLeft() != null && node.getRight().getRight() == null) {
                secondConnect = 1;
            } else if (node.getRight().getLeft() == null && node.getRight().getRight() != null) {
                secondConnect = 2;
            } else if (node.getRight().getLeft() != null && node.getRight().getRight() != null) {
                secondConnect = 3;
            }
            return new DCNodes(node, firstConnect, secondConnect);
        }
        if (value <= node.getValue() && node.getLeft() != null) {
            findNode = findConnectNode(node.getLeft(), value);
        }
        if (findNode != null) {
            return findNode;
        }
        if (value >= node.getValue() && node.getRight() != null) {
            findNode = findConnectNode(node.getRight(), value);
        }
        return findNode;
    }

    private TNode retDeleteMinNode(TNode node) {
        TNode tempNode = node.getRight();
        while (tempNode.getLeft() != null) {
            tempNode = tempNode.getLeft();
        }
        TNode minNode = tempNode;
        deleteTNode(tempNode.getValue());
        return minNode;
    }

    private TNode retDeleteMaxNode(TNode node) {
        TNode tempNode = node.getLeft();
        while (tempNode.getRight() != null) {
            tempNode = tempNode.getRight();
        }
        TNode maxNode = tempNode;
        deleteTNode(tempNode.getValue());
        return maxNode;
    }

    //中序遍历
    public void midOrder() {
        if (root == null) {
            return;
        }
        root.midOrder();
    }
}

class TNode {
    private int value;
    private TNode left;
    private TNode right;

    public TNode(int value) {
        this.value = value;
    }

    //添加结点函数
    public void add(TNode node) {
        if (node == null)
            return;
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    @Override
    public String toString() {
        return "TNode{" +
                "value=" + value +
                '}';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TNode getLeft() {
        return left;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public TNode getRight() {
        return right;
    }

    public void setRight(TNode right) {
        this.right = right;
    }
}
