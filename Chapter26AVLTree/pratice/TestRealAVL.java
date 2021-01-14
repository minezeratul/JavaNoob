package Chapter26AVLTree.pratice;

public class TestRealAVL {
    public static void main(String[] args) {
        realAVLtree tree = new realAVLtree();
        tree.insert(25);
        tree.insert(20);
        tree.insert(5);
        printTree(tree);
        tree.insert(9);
        tree.insert(15);
        System.out.println("\nAfter insertion: ");
        printTree(tree);
        System.out.println("\n" + tree.path(15));
    }

    public static void printTree(realAVLtree tree){
        System.out.println("In:");
        tree.inorder();
        System.out.println("\nPre");
        tree.preorder();
        System.out.println("\nPost");
        tree.postorder();
        System.out.println("\nBFS");
        tree.breadthFirstTraversal();
    }
}
