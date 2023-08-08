package date_structure_imp;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class BinaryTree {
    private PeopleNode root;

    public void preOrder() {
        if (root != null)
            root.preOrder();
    }

    public void midOrder() {
        if (root != null)
            root.midOrder();
    }

    public void posOrder() {
        if (root != null)
            root.posOrder();
    }

    //前序查找
    public PeopleNode proSearch(int no) {
        if (root != null)
            return root.proSearch(no);
        return null;
    }

    //中序查找
    public PeopleNode midSearch(int no) {
        if (root != null)
            return root.midSearch(no);
        return null;
    }

    //后序查找
    public PeopleNode posSearch(int no) {
        if (root != null)
            return root.posSearch(no);
        return null;
    }

    public void delete(int no) {

        if (root != null) {
            if (root.getNo() == no) {
                root = null;
                return;
            }
            root.delete(no);
        }
    }

    public PeopleNode getRoot() {
        return root;
    }

    public void setRoot(PeopleNode root) {
        this.root = root;
    }

}

class PeopleNode {
    private int no;
    private String name;
    private PeopleNode left;
    private PeopleNode right;

    public PeopleNode(int no, String name) {
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
    public PeopleNode proSearch(int no) {
        if (this.no == no) {
            return this;
        }
        PeopleNode findNode = null;
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
    public PeopleNode midSearch(int no) {
        PeopleNode findNode = null;
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
    public PeopleNode posSearch(int no) {
        PeopleNode findNode = null;
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

    //删除结点
    public void delete(int no) {
        if (this.left != null && this.left.getNo() == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.getNo() == no) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delete(no);
        }
        if (this.right != null) {
            this.right.delete(no);
        }
    }

    public void delete2(int no) {
        if (this.left != null && this.left.getNo() == no) {
            //删除this.left
//            move(this, 0);
        }
        if (this.right != null && this.left.getNo() == no) {
            //删除this.right
//            move(this, 0);
        }
        if (this.left != null) {
            this.left.delete2(no);
        }
        if (this.right != null) {
            this.right.delete2(no);
        }
    }

//    public void move(PeopleNode lastNode, int next) {
//        if (next == 0) {
//            PeopleNode deleteNode = lastNode.left;
//            //非叶子结点
//            PeopleNode nextNode = new PeopleNode(deleteNode.left.getNo(), deleteNode.left.getName());
//            nextNode.setLeft(deleteNode.left.getLeft());
//            nextNode.setRight(deleteNode.left.getRight());
//            lastNode.left = deleteNode.left;
//            deleteNode.left.right = deleteNode.right;
//            //叶子结点
//
//        } else {
//
//        }
//    }

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

    public PeopleNode getLeft() {
        return left;
    }

    public void setLeft(PeopleNode left) {
        this.left = left;
    }

    public PeopleNode getRight() {
        return right;
    }

    public void setRight(PeopleNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "PeopleNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}