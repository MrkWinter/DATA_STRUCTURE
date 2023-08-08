package date_structure_imp;

/**
 * @author MrkWinter
 * @version 1.0
 * 12.平衡二叉(搜索)树
 */
public class AVLTree {

    private ANode root;
    private DCNodes findNode;

    //成员内部类
    private class DCNodes {
        private ANode parent; //找到父结点位置
        int firstConnect; //0 代表空 左 1 代表左子树 2 代表右子树 3 代表左右子树
        int secondConnect;//同上

        public DCNodes(ANode parent, int firstConnect, int secondConnect) {
            this.parent = parent;
            this.firstConnect = firstConnect;
            this.secondConnect = secondConnect;
        }

        public ANode getParent() {
            return parent;
        }

        public void setParent(ANode parent) {
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
            addANode(new ANode(arr[i]));
        }
    }

    //添加结点
    public void addANode(ANode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //删除结点函数
    public void deleteANode(int value) {
        if (root == null) {
            System.out.println("根节点为空");
            return;
        }
        //删除的是根结点
        if (root.getValue() == value) {
            if (root.getRight() != null) {
                ANode aNode = retDeleteMinNode(root);
                root.setValue(aNode.getValue());
            } else if (root.getLeft() != null) {
                ANode aNode = retDeleteMaxNode(root);
                root.setValue(aNode.getValue());
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
        ANode parentNode = cParentNode.getParent();
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
                ANode aNode = retDeleteMaxNode(parentNode.getLeft());
                parentNode.getLeft().setValue(aNode.getValue());
            } else {
                ANode aNode = retDeleteMinNode(parentNode.getRight());
                parentNode.getRight().setValue(aNode.getValue());
            }
        }
    }

    //找到要删除的结点以及相关联的结点
    private DCNodes findConnectNode(ANode node, int value) {
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

    private ANode retDeleteMinNode(ANode node) {
        ANode tempNode = node.getRight();
        while (tempNode.getLeft() != null) {
            tempNode = tempNode.getLeft();
        }
        ANode minNode = tempNode;
        deleteANode(tempNode.getValue());
        return minNode;
    }

    private ANode retDeleteMaxNode(ANode node) {
        ANode tempNode = node.getLeft();
        while (tempNode.getRight() != null) {
            tempNode = tempNode.getRight();
        }
        ANode maxNode = tempNode;
        deleteANode(tempNode.getValue());
        return maxNode;
    }

    //中序遍历
    public void midOrder() {
        if (root == null) {
            return;
        }
        root.midOrder();
    }

    public ANode getRoot() {
        return root;
    }

    public void setRoot(ANode root) {
        this.root = root;
    }
}

class ANode {
    private int value;
    private ANode left;
    private ANode right;

    public ANode(int value) {
        this.value = value;
    }

    //以当前结点进行左旋转
    public void leftRotate() {
        //创建新的结点保存当前结点的值
        ANode newNode = new ANode(this.value);
        //把新结点的左子树设置成当前结点的左子树
        newNode.setLeft(this.left);
        //把新结点的柚子树设置成当前结点的柚子树的左子树
        newNode.setRight(this.right.left);
        //把当前结点的值替换成当前结点柚子树结点的值
        this.value = this.right.getValue();
        //把当前结点的柚子树设置成当前结点柚子树的柚子树
        this.setRight(this.getRight().getRight());
        //把当前结点的左子树设置成新结点
        this.setLeft(newNode);
    }

    //以当前结点进行左旋转
    public void rightRotate() {
        ANode newNode = new ANode(this.value);
        newNode.setRight(this.getRight());
        newNode.setRight(this.getLeft().getRight());
        this.setValue(this.getLeft().getValue());
        this.setLeft(this.getLeft().getLeft());
        this.setRight(newNode);
    }

    //返回左子树的高度
    public int getLeftHigh() {
        if (left == null) {
            return 0;
        }
        return left.getHigh();
    }

    //返回右子树的高度
    public int getRightHigh() {
        if (right == null) {
            return 0;
        }
        return right.getHigh();
    }

    //得到该结点为根的树的高度
    public int getHigh() {
        return Math.max(left == null ? 0 : left.getHigh(), right == null ? 0 : right.getHigh()) + 1;
    }

    //添加结点函数
    public void add(ANode node) {
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
        //添加完后因为是递归 退出返回函数时进行平衡检测 左右旋转
        if (this.getRightHigh() - this.getLeftHigh() > 1) {
            //如果当结点的柚子树的左子树高度大于柚子树的高度 需要先对柚子树结点进行右旋转
            if (this.getRight().getLeftHigh() > this.getRight().getRightHigh()) {
                this.getRight().rightRotate();
            }
            this.leftRotate();
        } else if (this.getLeftHigh() - this.getRightHigh() > 1) {
            //如果当前结点左子树的柚子树高度大于左子树的高度 需要先对左子树结点进行左旋转
            if (this.getLeft().getRightHigh() > this.getLeft().getLeftHigh()) {
                this.getLeft().leftRotate();
            }
            this.rightRotate();
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

    public ANode getLeft() {
        return left;
    }

    public void setLeft(ANode left) {
        this.left = left;
    }

    public ANode getRight() {
        return right;
    }

    public void setRight(ANode right) {
        this.right = right;
    }
}