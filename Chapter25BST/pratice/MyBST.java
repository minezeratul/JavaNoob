package Chapter25BST.pratice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * 满full二叉树一定是完全complete二叉树，但是完全complete二叉树不一定是满full二叉树
 *
 *没有子节点的节点就是叶leaf
 *
 *
 * 平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 *
 * */

public class MyBST<E extends Comparable<E>> {
    protected TreeNode<E> root;
    protected int size;

    public MyBST(){
        size = 0 ;
    }

    public MyBST(E[] objects){
        for (int i = 0 ; i < objects.length ; i++)
            insert(objects[i]);
    }

    public boolean insert(E element){
        if (root == null)
            root = createNode(element);
        else {
            TreeNode<E> parent = null;
            TreeNode<E> cur = root;

            while (cur != null)
                if (element.compareTo(cur.element) < 0) {
                    parent = cur;
                    cur = cur.left;
                } else if (element.compareTo(cur.element) > 0) {
                    parent = cur;
                    cur = cur.right;
                } else
                    return false;// Duplicate node not inserted

            // Create the new node and attach it to the parent node
            if (element.compareTo(parent.element) > 0)
                parent.right = createNode(element);
            else
                parent.left = createNode(element);
        }

        size++;
        return true;
    }

    private TreeNode<E> createNode(E element) {
        return new TreeNode<E>(element);
    }

    public boolean delete(E element){
        TreeNode<E> parent = null;
        TreeNode<E> cur = root;

        while (cur != null) {
            if (element.compareTo(cur.element) < 0) {
                parent = cur;
                cur = cur.left;
            }
            else if (element.compareTo(cur.element) > 0) {
                parent = cur;
                cur = cur.right;
            }
            else
                break; // Element is in the tree pointed at by current
        }

        if (cur == null)
            return false; // Element is not in the tree

        // Case 1: current has no left child
        if (cur.left == null) {
            // Connect the parent with the right child of the current node
            if (parent == null) {
                root = cur.right;
            }
            else {
                if (element.compareTo(parent.element) < 0)
                    parent.left = cur.right;
                else
                    parent.right = cur.right;
            }
        }
        else {
            // Case 2: The current node has a left child
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent
            TreeNode<E> parentOfRightMost = cur;
            TreeNode<E> rightMost = cur.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }

            // Replace the element in current by the element in rightMost
            cur.element = rightMost.element;

            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                // Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
        }

        size--;
        return true; // Element deleted successfully

    }

    public void inorder(){//show list
        inorder(this.root);
    }

    private void inorder(TreeNode<E> root){
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    public void preorder() {//quickSort
        preorder(this.root);
    }

    private void preorder(TreeNode<E> root){
        if (root == null)
            return;

        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(){ //mergeSort
        postorder(this.root);
    }

    private void postorder(TreeNode<E> root){
        if (root == null)
            return;
        
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    public void nonRecursiveInorder(){
        if (this.root == null)
            return;

        ArrayList<TreeNode<E>> list = new ArrayList<>();
        Stack<TreeNode<E>> stack = new Stack<>();

        stack.push(this.root);

        while (!stack.isEmpty()){
            TreeNode<E> node = stack.peek();
            if (node.left != null && !list.contains(node.left)){
                stack.push(node.left);
            }
            else {
                System.out.print(node.element + " ");
                stack.pop();
                list.add(node);
                if (node.right != null)
                    stack.push(node.right);
            }
        }
    }

    public void nonRecursivePreorder() {
        if (this.root == null)
            return;

        ArrayList<TreeNode<E>> list = new ArrayList<>();
        Stack<TreeNode<E>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode<E> node = stack.peek();
            stack.pop();
            list.add(node);
            System.out.print(node.element + " ");
            if (node.right != null && !list.contains(node.right))
                stack.push(node.right);
            if (node.left != null && !list.contains(node.left))
                stack.push(node.left);

        }
    }

    public void nonRecursivePostorder() {
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        Stack<TreeNode<E>> stack = new Stack<>();

        if (root == null)
            return;

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<E> node = stack.peek();
            if (node.left != null && !list.contains(node.left)) {
                stack.push(node.left); // Add the left node to the stack
            }
            else if (node.right != null && !list.contains(node.right)) {
                stack.push(node.right); // Add the right node to the stack
            }
            else {
                System.out.print(node.element + " ");
                stack.pop(); // Remove the node from the stack
                list.add(node);
            }
        }

    }

    public void depthFirstTraversal(){ //non recursive preorder
        if (this.root == null)
            return;

        Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode<E> node = stack.pop();
            System.out.print(node.element + " ");

            /*
            if (node.left != null)
                stack.add(node.left);
            if (node.right != null)
                stack.add(node.right);
           */

            if (node.right != null)
                stack.add(node.right);
            if (node.left != null)
                stack.add(node.left);

        }
    }

    public void breadthFirstTraversal() {//By level  [3] -> [3, 2, 4] -> [3 ,2 , 4, 1 ,5]
        LinkedList<TreeNode<E>> queue = new LinkedList<TreeNode<E>>();

        if (root == null)
            return;

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<E> cur = queue.removeFirst();

            System.out.print(cur.element + " ");
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    public int getNumberOfLeaves(){
        return getNumberOfLeaves(root);
    }

    public int getNumberOfLeaves(TreeNode<E> root){
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return 1;
        else
            return getNumberOfLeaves(root.left) + getNumberOfLeaves(root.right);
    }

    public int getNumberOfNonLeaves(){
        return getNumberOfNonLeaves(root);
    }

    public int getNumberOfNonLeaves(TreeNode<E> root){
        if (root == null)
            return 0;
        else if (root.left != null || root.right != null)
            return 1 + getNumberOfNonLeaves(root.left) + getNumberOfNonLeaves(root.right);
        else
            return 0;
    }

    public boolean search(E element){
        TreeNode<E> cur = root;

        while (cur != null){
            if (element.compareTo(cur.element) < 0)
                cur = cur.left;
            else if (element.compareTo(cur.element) > 0)
                cur =  cur.right;
            else
                return true;
        }

        return false;
    }

    /** Returns a path from the root leading to the specified element */
    public java.util.ArrayList<TreeNode<E>> path(E e) {
        if (search(e) == false)
            return null;

        ArrayList<TreeNode<E>> list = new ArrayList<>();
        TreeNode<E> current = root; // Start from the root

        while (current != null) {
            list.add(current); // Add the node to the list
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            }
            else if (e.compareTo(current.element) > 0) {
                current = current.right;
            }
            else
                break;
        }

        return list; // Return an array list of nodes
    }

    public boolean isEmpty(){
        if (root == null)
            return true;
        else
            return false;
    }

    public boolean isFull(){
        if (root == null)
            return false;

        return false;
    }

    public int maxDepth(){
        return maxDepth(this.root);
    }

    public int maxDepth(TreeNode<E> root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public TreeNode<E> getRoot(){
        return root;
    }

    public int count(TreeNode<E> root){
        if (root == null)
            return 0;

        return 1 + count(root.left) + count(root.right);
    }
    public int size(){
        return size;
    }

    public void clear() {
        root = null;
        size = 0;
    }
}
