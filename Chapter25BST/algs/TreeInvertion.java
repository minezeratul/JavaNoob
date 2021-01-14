package Chapter25BST.algs;

import Chapter25BST.pratice.MyBST;
import Chapter25BST.pratice.TreeNode;

public class TreeInvertion {
    public static void main(String[] args) {
        MyBST myBST = new MyBST(new Integer[]{4 ,1 ,2 ,3 ,7 ,6 ,9});
        myBST.inorder();
        System.out.println();
        invertTree(myBST.getRoot());
        myBST.inorder();
    }
    
    public static TreeNode invertTree(TreeNode root){
        if (root == null)
            return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
