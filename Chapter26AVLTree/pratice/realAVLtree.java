package Chapter26AVLTree.pratice;

import java.util.ArrayList;
import java.util.LinkedList;

public class realAVLtree<E extends Comparable> {
     class AVLTreeNode<E extends Comparable>{
        public E val;
        AVLTreeNode<E> left;
        AVLTreeNode<E> right;
        int height;

        AVLTreeNode(E val){
            this.val = val;
        }

        @Override
        public String toString(){
            return ""+ val;
        }
    }

    private int size;
    AVLTreeNode<E> root;

    public realAVLtree(){
        size = 0;
    }

    public realAVLtree(E[] objs){
        for (int i = 0; i < objs.length ; i++)
            insert(objs[i]);
    }

    public boolean insert(E e){
        if (root == null)
            root = createNode(e);
        else {
            AVLTreeNode<E> parent = null;
            AVLTreeNode<E> cur = root;

            while (cur != null) {
                if (e.compareTo(cur.val) < 0) {
                    parent = cur;
                    cur = cur.left;
                } else if (e.compareTo(cur.val) > 0) {
                    parent = cur;
                    cur = cur.right;
                } else
                    return false;
            }

            if (e.compareTo(parent.val) > 0) {
                parent.right = createNode(e);
            } else {
                parent.left = createNode(e);
            }

            balancePath(e);
        }
        size++;
        return true;
    }

    private void updateHeight(AVLTreeNode<E> node){
        if (node.left == null && node.right == null)
            node.height = 0 ;
        else if (node.left == null)
            node.height = 1 + node.right.height;
        else if (node.right == null)
            node.height = 1 + node.left.height;
        else
            node.height = 1 + Math.max(node.left.height , node.right.height);
    }

    private void balancePath(E e){
        ArrayList<AVLTreeNode<E>> path = path(e);

        for (int i = path.size() - 1; i >= 0 ; i--){
            AVLTreeNode<E> A = path.get(i);
            updateHeight(A);
            AVLTreeNode<E> parentofA = (A == root) ? null : path.get(i - 1);

            switch (balanceFactor(A)){
                case -2:
                    if (balanceFactor(A.left) <= 0)
                        balanceLL(A , parentofA);
                    else
                        balanceLR(A , parentofA);
                    break;
                case +2:
                    if (balanceFactor(A.right) >= 0)
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
            return node.right.height - node.left.height;
    }

    private void balanceLL(AVLTreeNode<E> A , AVLTreeNode<E> parentofA){
        AVLTreeNode<E> B = A.left;//left-heavy

        if (A == root){
            root = B;
        }
        else {
            if (parentofA.left == A){
                parentofA.left = B;
            }
            else {
                parentofA.right = B;
            }
        }

        A.left = B.right;
        B.right = A;
        updateHeight(A);
        updateHeight(B);
    }

    private void balanceLR(AVLTreeNode<E> A , AVLTreeNode<E> parentofA){
        AVLTreeNode<E> B = A.left;// A is left-heavy
        AVLTreeNode<E> C = B.right;// B is right-heavy

        if (A == root){
            root = C;
        }
        else {
            if (parentofA.left == A){
                parentofA.left = C;
            }
            else {
                parentofA.right = C;
            }
        }

        A.left = C.right;
        B.right = C.left;
        C.left = B;
        C.right = A;
    }

    private void balanceRR(AVLTreeNode<E> A , AVLTreeNode<E> parentofA){
        AVLTreeNode<E> B = A.right ;//right-heavy

        if (A == root){
            root = B;
        }
        else{
            if (parentofA.left == A){
                parentofA.left = B;
            }
            else {
                parentofA.right = B;
            }
        }

        A.right = B.left;
        B.left = A;
        updateHeight(A);
        updateHeight(B);
    }

    private void balanceRL(AVLTreeNode<E> A , AVLTreeNode<E> parentofA){
        AVLTreeNode<E> B = A.right;
        AVLTreeNode<E> C = B.left;

        if (A == root){
            root = C;
        }
        else {
            if (parentofA.left == A) {
                parentofA.left = C;
            }
            else {
                parentofA.right = C;
            }
        }

        A.right = C.left;
        B.left = C.right;
        C.left = A;
        C.right = B;

        updateHeight(A);
        updateHeight(B);
        updateHeight(C);
    }

    public boolean delete(E e){
        if (root == null)
            return false;

        AVLTreeNode<E> parent = null;
        AVLTreeNode<E> cur = root;

        while (cur != null){
            if (e.compareTo(cur.val) < 0){
                parent = cur;
                cur = cur.left;
            }
            else if (e.compareTo(cur.val) > 0){
                parent = cur;
                cur = cur.right;
            }
            else
                break;
        }

        if (cur == null)
            return false;

        if (cur.left == null){
            if (parent == null){
                root = cur.right;
            }
            else{
                if (e.compareTo(parent.val) < 0)
                    parent.left = cur.right;
                else
                    parent.right = cur.right;

                balancePath(parent.val);
            }
        }
        else {
            AVLTreeNode<E> parentofRightMost = cur;
            AVLTreeNode<E> rightMost = cur.left;

            while (rightMost.right != null){
                parentofRightMost = rightMost;
                rightMost = rightMost.right;
            }

            cur.val = rightMost.val;

            if (parentofRightMost.val == rightMost.val)
                parentofRightMost.right = rightMost.left;
            else
                parentofRightMost.left = rightMost.left;

            balancePath(parentofRightMost.val);
        }

        size--;
        return true;
    }

    public ArrayList<AVLTreeNode<E>> path(E e) {
        if (search(e) == false)
            return null;

        ArrayList<AVLTreeNode<E>> list = new ArrayList<>();
        AVLTreeNode<E> current = root; // Start from the root

        while (current != null) {
            list.add(current); // Add the node to the list
            if (e.compareTo(current.val) < 0) {
                current = current.left;
            }
            else if (e.compareTo(current.val) > 0) {
                current = current.right;
            }
            else
                break;
        }

        return list; // Return an array list of nodes
    }

    public boolean search(E element){
        AVLTreeNode<E> cur = root;

        while (cur != null){
            if (element.compareTo(cur.val) < 0)
                cur = cur.left;
            else if (element.compareTo(cur.val) > 0)
                cur =  cur.right;
            else
                return true;
        }

        return false;
    }

    public void inorder(){
        inorder(this.root);
    }

    private void inorder(AVLTreeNode<E> root){
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public void preorder(){
        preorder(this.root);
    }

    private void preorder(AVLTreeNode<E> root){
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(){
        postorder(this.root);
    }

    public void postorder(AVLTreeNode<E> root){
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    public void breadthFirstTraversal(){
        LinkedList<AVLTreeNode<E>> queue = new LinkedList<>();
        if (root == null)
            return;

        queue.add(root);

        while (!queue.isEmpty()){
            AVLTreeNode<E> cur = queue.removeFirst();

            System.out.print(cur.val + " ");
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    public int getNumberOfLeaves(){
        return getNumberOfLeaves(root);
    }

    private int getNumberOfLeaves(AVLTreeNode<E> root){
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return 1;
        else
            return getNumberOfLeaves(root.left) + getNumberOfLeaves(root.right);
    }

    public int getNumberOfNonLeaves(){
        return getNumberOfNonLeaves(this.root);
    }

    public int getNumberOfNonLeaves(AVLTreeNode<E> root){
        if (root == null)
            return 0;
        else if (root.left != null || root.right != null)
            return 1 + getNumberOfNonLeaves(root.left) + getNumberOfNonLeaves(root.right);
        else
            return 0;
    }

    public boolean isFull(){
        return isFull(this.root);
    }

    private boolean isFull(AVLTreeNode root){
        if (root == null)
            return false;

        if (root.left == null && root.right == null)
            return true;
        else
            return isFull(root.left) && isFull(root.right);
    }

    public int maxDepth(){
        return maxDepth(this.root);
    }

    private int maxDepth(AVLTreeNode<E> root){
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left) , maxDepth(root.right));
    }

    public int count(AVLTreeNode<E> root){
        if (root == null)
            return 0;

        return 1 + count(root.left) + count(root.right);
    }

    public void clear(){
        root = null;
        size = 0;
    }

    private AVLTreeNode<E> createNode(E element) {
        return new AVLTreeNode<>(element);
    }
}
