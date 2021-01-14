package Chapter25BST.pratice;

public class TreeNode<E extends Comparable<E>> {
    public E element;
    public TreeNode<E> left;
    public TreeNode<E> right;
    public TreeNode<E> next;// for the solution

    public TreeNode(E element){
        this.element = element;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    @Override
    public String toString(){
        return ""+ element;
    }
}
