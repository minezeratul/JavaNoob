package Chapter26AVLTree.pratice;

public class TestMyAVL {
    public static void main(String[] args) {
        MyAVLTree tree = new MyAVLTree(new Integer[]{25 , 20 , 5});
        printTree(tree);
        tree.insert(9);
        tree.insert(15);
        System.out.println();
        printTree(tree);

    }

    public static void printTree(MyAVLTree tree){
        System.out.println("In:");
        tree.inorder();
        System.out.println("\nPre");
        tree.preorder();
        System.out.println("\nPost");
        tree.postorder();
    }
}
