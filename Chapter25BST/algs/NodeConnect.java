package Chapter25BST.algs;

import Chapter25BST.pratice.TreeNode;

import java.util.LinkedList;

public class NodeConnect {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(7);

        root.setLeft(a);
        root.setRight(b);

        a.setLeft(c);
        a.setRight(d);
        b.setLeft(e);
        b.setRight(f);

        System.out.println("Breadth-First");
        breadthFirstTraversal(root);
        System.out.println();
        connect(root);
        System.out.println("a: " + a.element);
        System.out.println("a.next: " + a.next.element);
        System.out.println("c: " + c.element);
        System.out.println("c.next: " + c.next.element);
        System.out.println("c.next.next: " + c.next.next.element);
        System.out.println("c.next.next.next: " + c.next.next.next.element);
    }

    public static void breadthFirstTraversal(TreeNode root) {
        if (root == null)
            return;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.removeFirst();
            System.out.print(cur.element + " ");
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }
    
    public static TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftmost = root;
        while (leftmost.left != null) {

            TreeNode head = leftmost;
            while (head != null) {

                if (head.left != null) {
                    head.left.next = head.right;
                }

                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;//[2] -> [3] -> null stop ....[4] -> [5] -> [6] -> [7] -> null
            }

            leftmost = leftmost.left;// reset the level [1st] -> [2th] -> ...
        }

        return root;
    }

    
    public static TreeNode nodeConnect(TreeNode root){
        if (root == null)
           return root;

        nodeConnect(root.left , root.right);
        return root;
    }

    /**
     * 利用辅助函数来连接不同子树的节点
     * @param root1 左子树
     * @param root2 右子树
     *
     */
    public static void nodeConnect(TreeNode root1 , TreeNode root2){
        if (root1 == null || root2 == null)
            return;

        root1.next = root2;
        nodeConnect(root1.left , root1.right);
        nodeConnect(root1.right , root2.left);
        nodeConnect(root2.left , root2.right);
    }
}
