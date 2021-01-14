package Chapter25BST.pratice;

import java.util.LinkedList;

public class BinaryTree {
    public static void main(String[] args) {
        BTnode root = new BTnode<>(1);
        
        BTnode a = new BTnode(2);
        BTnode b = new BTnode(3);
        root.setLeft(a);
        root.setRight(b);

        BTnode c = new BTnode(4);
        BTnode d = new BTnode(5);
        a.setLeft(c);
        a.setRight(d);

        BTnode e = new BTnode(6);
        BTnode f = new BTnode(7);
        b.setLeft(e);
        b.setRight(f);

        System.out.println("In");
        inorder(root);
        System.out.println("Pre");
        preorder(root);
        System.out.println("Post");
        postorder(root);
        System.out.println("Breadth-First");
        breadthFirstTraversal(root);
    }
    
    public static void inorder(BTnode root){
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    public static void preorder(BTnode root){
        if (root == null)
            return;

        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(BTnode root){
        if (root == null)
            return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    public static void breadthFirstTraversal(BTnode root){
        if (root == null)
            return;

        LinkedList<BTnode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            BTnode cur = queue.removeFirst();
            System.out.print(cur.element + " ");
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }

    private static class BTnode<E>{
        E element;
        BTnode<E> left;
        BTnode<E> right;
        
        BTnode(E element){
            this.element = element;
        }

        public void setLeft(BTnode<E> left) {
            this.left = left;
        }

        public void setRight(BTnode<E> right) {
            this.right = right;
        }
    }
}
