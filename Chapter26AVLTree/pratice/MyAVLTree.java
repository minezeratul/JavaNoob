package Chapter26AVLTree.pratice;

import java.util.ArrayList;

/**
 * AVL树，它的任何节点的两个子树的高度差别都 |height|<=1
 * balanceFactor could be -1 , 0 and 1.
 */
public class MyAVLTree<E extends Comparable<E>> extends MyBST<E> {

    public MyAVLTree(){
    }

    public MyAVLTree(E[] objects){
         super(objects);
    }

    @Override
    public boolean insert(E element) {
        boolean successful = super.insert(element);
        if (!successful)
            return false;//existed
        else
            balancePath(element);//balance the heavy side

        return true;

    }

    private void updateHeight(AVLTreeNode<E> node){
        if (node.left == null && node.right == null)
            node.height = 0 ;
        else if (node.left == null)
            node.height = 1 + ((AVLTreeNode<E>)(node.right)).height;
        else if (node.right == null)
            node.height = 1 + ((AVLTreeNode<E>)(node.left)).height;
        else
            node.height = 1 +
                    Math.max(((AVLTreeNode<E>)(node.left)).height ,
                            ((AVLTreeNode<E>)(node.right)).height);
    }

    private void balancePath(E e){
        ArrayList<TreeNode<E>> path = path(e);
        for(int i = path.size() - 1; i >= 0 ; i--){
            AVLTreeNode<E> A = (AVLTreeNode<E>)(path.get(i));
            updateHeight(A);
            AVLTreeNode<E> parentofA = (A == root) ? null : (AVLTreeNode<E>)(path.get(i - 1));

            switch (balanceFactor(A)){
                case -2:
                    if (balanceFactor((AVLTreeNode<E>) A.left) <= 0)
                        balanceLL(A , parentofA);
                    else
                        balanceLR(A , parentofA);
                    break;
                case +2:
                    if (balanceFactor((AVLTreeNode<E>) A.right) >= 0)
                        balanceRR(A , parentofA);
                    else
                        balanceRL(A , parentofA);

            }
        }
    }

    private int balanceFactor(AVLTreeNode<E> node){
        if (node.right == null)//no right subtree
            return -node.height;
        else if (node.left == null)//no left subtree
            return +node.height;
        else
            return ((AVLTreeNode<E>)node.right).height - ((AVLTreeNode<E>)node.left).height;
    }

    private void balanceLL(TreeNode<E> A, TreeNode<E> parentOfA) {
        TreeNode<E> B = A.left; // A is left-heavy and B is left-heavy

        if (A == root) {
            root = B;
        }
        else {
            if (parentOfA.left == A) {
                parentOfA.left = B;
            }
            else {
                parentOfA.right = B;
            }
        }

        A.left = B.right; // Make T2 the left subtree of A
        B.right = A; // Make A the left child of B
        updateHeight((AVLTreeNode<E>)A);
        updateHeight((AVLTreeNode<E>)B);
    }

    private void balanceLR(TreeNode<E> A, TreeNode<E> parentOfA) {
        TreeNode<E> B = A.left; // A is left-heavy
        TreeNode<E> C = B.right; // B is right-heavy

        if (A == root) {
            root = C;
        }
        else {
            if (parentOfA.left == A) {
                parentOfA.left = C;
            }
            else {
                parentOfA.right = C;
            }
        }

        A.left = C.right; // Make T3 the left subtree of A
        B.right = C.left; // Make T2 the right subtree of B
        C.left = B;
        C.right = A;

        // Adjust heights
        updateHeight((AVLTreeNode<E>)A);
        updateHeight((AVLTreeNode<E>)B);
        updateHeight((AVLTreeNode<E>)C);
    }

    private void balanceRR(TreeNode<E> A, TreeNode<E> parentOfA) {
        TreeNode<E> B = A.right; // A is right-heavy and B is right-heavy

        if (A == root) {
            root = B;
        }
        else {
            if (parentOfA.left == A) {
                parentOfA.left = B;
            }
            else {
                parentOfA.right = B;
            }
        }

        A.right = B.left; // Make T2 the right subtree of A
        B.left = A;
        updateHeight((AVLTreeNode<E>)A);
        updateHeight((AVLTreeNode<E>)B);
    }

    private void balanceRL(TreeNode<E> A, TreeNode<E> parentOfA) {
        TreeNode<E> B = A.right; // A is right-heavy
        TreeNode<E> C = B.left; // B is left-heavy

        if (A == root) {
            root = C;
        }
        else {
            if (parentOfA.left == A) {
                parentOfA.left = C;
            }
            else {
                parentOfA.right = C;
            }
        }

        A.right = C.left; // Make T2 the right subtree of A
        B.left = C.right; // Make T3 the left subtree of B
        C.left = A;
        C.right = B;

        // Adjust heights
        updateHeight((AVLTreeNode<E>)A);
        updateHeight((AVLTreeNode<E>)B);
        updateHeight((AVLTreeNode<E>)C);
    }


    @Override
    public boolean delete(E element) {
        if (root == null)
            return false;

        TreeNode<E> parent = null;
        TreeNode<E> cur = root;

        while (cur != null) {
            if (element.compareTo(cur.element) < 0) {
                parent = cur;
                cur = cur.left;
            } else if (element.compareTo(cur.element) > 0) {
                parent = cur;
                cur = cur.right;
            } else
                break;
        }

        if (cur == null)
            return false;

        if (cur.left == null) {
            if (parent == null) {
                root = cur.right;
            }
            else{
                if (element.compareTo(parent.element) < 0)
                    parent.left = cur.right;
                else
                    parent.right = cur.right;

                balancePath(parent.element);
            }
        }
        else {
            TreeNode<E> parentofRightMost = cur;
            TreeNode<E> rightMost = cur.left;

            while (rightMost.right != null){
                parentofRightMost = rightMost;
                rightMost = rightMost.right;
            }
            cur.element = rightMost.element;

            if (parentofRightMost.element == rightMost.element)
                parentofRightMost.right = rightMost.left;
            else
                parentofRightMost.left = rightMost.left;

            balancePath(parentofRightMost.element);
        }

        size--;
        return true;
    }

    @Override
    protected AVLTreeNode<E> createNode(E e){
        return new AVLTreeNode<E>(e);
    }
}
