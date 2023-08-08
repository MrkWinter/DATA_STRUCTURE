package date_structure_imp;

/**
 * @author MrkWinter
 * @version 1.0
 * 7. 顺序存储二叉树
 * 即存入数组的二叉树  (按二叉树编号依次存入的数组) 将数组当成二叉树
 * 只有在满二叉树或完全二叉树存储时较合适 不然浪费内存
 */
public class ArrayBinaryTree {
    private int[] arrayBinaryTree;

    public ArrayBinaryTree(int[] arrayBinaryTree) {
        this.arrayBinaryTree = arrayBinaryTree;
    }

    //顺序存储二叉树的前序遍历
    public void preOrder() {
        if (arrayBinaryTree == null || arrayBinaryTree.length == 0) {
            return;
        }
        preOrder(0);
        System.out.println();
    }

    private void preOrder(int index) {
        //打印当前结点
        System.out.print(arrayBinaryTree[index] + " ");
        //遍历左子树
        if (index * 2 + 1 < arrayBinaryTree.length) {
            preOrder(index * 2 + 1);
        }
        //遍历右子树
        if (index * 2 + 2 < arrayBinaryTree.length) {
            preOrder(index * 2 + 2);
        }
    }

    //顺序存储二叉树中序遍历
    public void midOrder() {
        if (arrayBinaryTree == null || arrayBinaryTree.length == 0) {
            return;
        }
        midOrder(0);
        System.out.println();
    }

    private void midOrder(int index) {
        //遍历左子树
        if (index * 2 + 1 < arrayBinaryTree.length) {
            preOrder(index * 2 + 1);
        }
        //打印当前结点
        System.out.print(arrayBinaryTree[index] + " ");
        //遍历右子树
        if (index * 2 + 2 < arrayBinaryTree.length) {
            preOrder(index * 2 + 2);
        }
    }

    //顺序存储二叉树的后遍历
    public void porOrder() {
        if (arrayBinaryTree == null || arrayBinaryTree.length == 0) {
            return;
        }
        porOrder(0);
        System.out.println();
    }

    private void porOrder(int index) {
        //遍历左子树
        if (index * 2 + 1 < arrayBinaryTree.length) {
            preOrder(index * 2 + 1);
        }
        //遍历右子树
        if (index * 2 + 2 < arrayBinaryTree.length) {
            preOrder(index * 2 + 2);
        }
        //打印当前结点
        System.out.print(arrayBinaryTree[index] + " ");
    }
}
