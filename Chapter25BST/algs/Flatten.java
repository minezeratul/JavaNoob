package Chapter25BST.algs;


import Chapter25BST.pratice.TreeNode;

import java.util.Stack;

public class Flatten {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);


        root.setLeft(a);
        root.setRight(d);

        a.setLeft(b);
        a.setRight(c);
        d.setRight(e);


        System.out.println("In");
        inorder(root);
        System.out.println("\nPre");
        preorder(root);
        System.out.println("\nPost");
        postorder(root);

        flatten2(root);

        System.out.println("\nIn");
        inorder(root);
        System.out.println("\nPre");
        preorder(root);
        System.out.println("\nPost");
        postorder(root);

    }

    public static void flatten(TreeNode root){
        if (root == null)
            return;

        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null){
            p = p.right;
        }

        p.right = right;
    }

    /**
     * 题目给定的遍历顺序其实就是先序遍历的顺序，
     * 所以我们能不能利用先序遍历的代码，
     * 每遍历一个节点，就将上一个节点的右指针更新为当前节点。
     * In-Place Method
     *
     */

    public static void flatten2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;

        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.right;
            }

            cur = stack.peek();// 已经访问到最右的节点了

            if (cur.left == null || cur.left == pre){
                stack.pop();
                cur.right = pre;
                cur.left = null;

                pre = cur;
                cur = null;
            }
            else {
                cur = cur.left; // 左节点还没有访问过就先访问左节点
            }
        }

    }

    public static void inorder(TreeNode root){
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    public static void preorder(TreeNode root){
        if (root == null)
            return;

        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(TreeNode root){
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

}
