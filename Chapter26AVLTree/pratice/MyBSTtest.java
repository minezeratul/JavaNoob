package Chapter26AVLTree.pratice;

public class MyBSTtest {
    public static void main(String[] args) {
        MyBST bst = new MyBST(new Integer[]{8 ,6 ,7 ,9 ,11});

        printTree(bst);
        System.out.println(bst.isFull());

        bst.delete(8);
        printTree(bst);

        System.out.println();
        System.out.println("The leaves are " + bst.getNumberOfLeaves());
        System.out.println("The non-leaves are " + bst.getNumberOfNonLeaves());
        System.out.println("The count is " + bst.count(bst.root));
        System.out.println("The size is " + bst.size());
        System.out.println("The path is " + bst.path(2) );
        System.out.println("The max depth of the tree is " + bst.maxDepth());
        System.out.println("The min depth of the tree is " + bst.minDepth());

    }

    public static void printTree(MyBST bst){
        System.out.println("Inorder: ");
        bst.inorder();
        System.out.println("\nPreorder: ");
        bst.preorder();
        System.out.println("\nPostorder: ");
        bst.postorder();

        System.out.println("\n-----------------");
        System.out.println("non Recursive inorder");
        bst.nonRecursiveInorder();
        System.out.println("\nnon Recursive preorder");
        bst.nonRecursivePreorder();
        System.out.println("\nnon Recursive postorder: ");
        bst.nonRecursivePostorder();

        System.out.println("\n-----------------");
        System.out.println("depth-First traversal");
        bst.depthFirstTraversal();
        System.out.println("\nBreadth-first Search: ");
        bst.breadthFirstTraversal();
        System.out.println();
    }
}
