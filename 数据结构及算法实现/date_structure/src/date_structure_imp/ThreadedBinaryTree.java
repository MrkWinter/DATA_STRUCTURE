package date_structure_imp;

/**
 * @author MrkWinter
 * @version 1.0
 */
@SuppressWarnings("all")
public class ThreadedBinaryTree {
    public static boolean flag = false;
    private PoNode root;
    private PoNode preNode;


    //二叉树的中序线索化
    public void midThreadBinaryTree() {
        if (root == null || flag)
            return;
        flag = true;
        midThreadBinaryTree(root);
    }

    private void midThreadBinaryTree(PoNode poNode) {
        //线索化左子树
        if (poNode.getLeft() != null)
            midThreadBinaryTree(poNode.getLeft());
        //线索化当前结点
        //1. 处理左子树
        if (poNode.getLeft() == null) {
            poNode.setLeft(preNode);
            poNode.setLeftFlag(1);
        }
        //2. 处理右子树
        if (preNode != null && preNode.getRight() == null) {
            preNode.setRight(poNode);
            preNode.setRightFlag(1);
        }
        preNode = poNode;
        //线索化柚子社
        if (poNode.getRight() != null)
            midThreadBinaryTree(poNode.getRight());
    }

    //二叉树的先序线索化 ！！！
    public void preThreadBinaryTree() {
        if (root == null || flag)
            return;
        flag = true;
        preThreadBinaryTree(root);
    }

    private void preThreadBinaryTree(PoNode poNode) {
        //线索化当前结点
        //1. 处理左子树
        if (poNode.getLeft() == null) {
            poNode.setLeft(preNode);
            poNode.setLeftFlag(1);
        }
        //2. 处理右子树
        if (preNode != null && preNode.getRight() == null) {
            preNode.setRight(poNode);
            preNode.setRightFlag(1);
        }
        preNode = poNode;
        //线索左子树
        if (poNode.getLeft() != null && poNode.getLeftFlag() != 1)
            preThreadBinaryTree(poNode.getLeft());
        //线索右子树
        if (poNode.getRight() != null && poNode.getRightFlag() != 1)
            preThreadBinaryTree(poNode.getRight());
    }

    //二叉树的后序线索化 ！！！
    public void porThreadBinaryTree() {
        if (root == null || flag)
            return;
        flag = true;
        porThreadBinaryTree(root);
    }

    private void porThreadBinaryTree(PoNode poNode) {
        //线索左子树
        if (poNode.getLeft() != null)
            porThreadBinaryTree(poNode.getLeft());
        //线索右子树
        if (poNode.getRight() != null && poNode.getRight() != null)
            porThreadBinaryTree(poNode.getRight());
        //线索化当前结点
        if (poNode.getLeft() == null) {
            poNode.setLeft(preNode);
            poNode.setLeftFlag(1);
        }
        if (preNode != null && preNode.getRight() == null) {
            preNode.setRight(poNode);
            preNode.setRightFlag(1);
        }
        preNode = poNode;
    }

    //二叉树线索化的先序遍历 ！！！
    public void preThreadOrder() {
        PoNode node = root;
        while (node != null) {
            while (node.getLeftFlag() == 0) {
                System.out.println(node);
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightFlag() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            while (node.getLeftFlag() == 0) {
                node = node.getLeft();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    //二叉树线索化的中序遍历
    public void midThreadOrder() {
        PoNode node = root;
        while (node != null) {
            while (node.getLeftFlag() == 0) {
                node = node.getLeft();
            }
            //找到一个中序遍历元素
            System.out.println(node);
            //右子树一定指向下一个遍历元素
            while (node.getRightFlag() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    //二叉树线索化的后序遍历 ！！！
    public void porThreadOrder() {
        //后序遍历没多大用处 无父指针无法遍历全部
        PoNode node = root;
        while (node != null) {
            while (node.getLeftFlag() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightFlag() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            if (node.getRightFlag() == 0) {
                node = node.getRight();
            break;
            }
        }
    }

    public void preOrder() {
        if (root != null || !flag)
            root.preOrder();
    }

    public void midOrder() {
        if (root != null || !flag)
            root.midOrder();
    }

    public void posOrder() {
        if (root != null || !flag)
            root.posOrder();
    }

    //前序查找
    public PoNode proSearch(int no) {
        if (root != null || !flag)
            return root.proSearch(no);
        return null;
    }

    //中序查找
    public PoNode midSearch(int no) {
        if (root != null || !flag)
            return root.midSearch(no);
        return null;
    }

    //后序查找
    public PoNode posSearch(int no) {
        if (root != null || !flag)
            return root.posSearch(no);
        return null;
    }

    public PoNode getRoot() {
        return root;
    }

    public void setRoot(PoNode root) {
        this.root = root;
    }
}

class PoNode {
    private int no;
    private String name;
    private PoNode left;
    private PoNode right;
    //代表指向前驱后继还是普通的子结点
    private int leftFlag;
    private int rightFlag;

    public PoNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null)
            this.left.preOrder();
        if (this.right != null)
            this.right.preOrder();
    }

    //中序遍历
    public void midOrder() {
        if (this.left != null)
            this.left.preOrder();
        System.out.println(this);
        if (this.right != null)
            this.right.preOrder();
    }

    //后序遍历
    public void posOrder() {
        if (this.left != null)
            this.left.preOrder();
        if (this.right != null)
            this.right.preOrder();
        System.out.println(this);
    }

    //前序查找
    public PoNode proSearch(int no) {
        if (this.no == no) {
            return this;
        }
        PoNode findNode = null;
        if (this.left != null) {
            findNode = this.left.proSearch(no);
        }
        if (findNode != null)
            return findNode;
        if (this.right != null) {
            findNode = this.right.proSearch(no);
        }
        return findNode;
    }

    //中序查找
    public PoNode midSearch(int no) {
        PoNode findNode = null;
        if (this.left != null) {
            findNode = this.left.proSearch(no);
        }
        if (findNode != null)
            return findNode;
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            findNode = this.right.proSearch(no);
        }
        return findNode;
    }

    //后序查找
    public PoNode posSearch(int no) {
        PoNode findNode = null;
        if (this.left != null) {
            findNode = this.left.proSearch(no);
        }
        if (findNode != null)
            return findNode;
        if (this.right != null) {
            findNode = this.right.proSearch(no);
        }
        if (findNode != null)
            return findNode;
        if (this.no == no) {
            return this;
        }
        return findNode;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PoNode getLeft() {
        return left;
    }

    public void setLeft(PoNode left) {
        this.left = left;
    }

    public PoNode getRight() {
        return right;
    }

    public void setRight(PoNode right) {
        this.right = right;
    }

    public int getLeftFlag() {
        return leftFlag;
    }

    public void setLeftFlag(int leftFlag) {
        this.leftFlag = leftFlag;
    }

    public int getRightFlag() {
        return rightFlag;
    }

    public void setRightFlag(int rightFlag) {
        this.rightFlag = rightFlag;
    }

    @Override
    public String toString() {
        return "PoNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
