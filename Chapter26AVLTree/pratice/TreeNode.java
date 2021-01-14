package Chapter26AVLTree.pratice;

public class TreeNode<E extends Comparable<E>> {
    public E element;
    public TreeNode<E> left;
    public TreeNode<E> right;

    public TreeNode(E element){
        this.element = element;
    }

    @Override
    public String toString(){
        return ""+ element;
    }
}
