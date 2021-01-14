package Chapter26AVLTree.pratice;

public class AVLTreeNode<E extends Comparable<E>> extends TreeNode<E> {
    protected int height = 0 ;

    public AVLTreeNode(E element){
        super(element);
    }

    @Override
    public String toString(){
        return ""+ element;
    }
}
