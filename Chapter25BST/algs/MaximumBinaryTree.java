package Chapter25BST.algs;

import Chapter25BST.pratice.TreeNode;

public class MaximumBinaryTree {
    public static void main(String[] args) {
        int[] arr = {3 , 2, 1, 6 ,0 ,5};
        System.out.println(constructMaximumBinaryTree(arr));
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums){
        return constructMaximumBinaryTree(nums , 0 , nums.length - 1);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums , int low , int high){
        if (low > high)
            return null;

        int index = 0 , maxVal = Integer.MIN_VALUE ;

        for (int i = low ; i <= high ; i++){
            if (maxVal < nums[i]){
                index = i ;
                maxVal = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxVal);
        root.left = constructMaximumBinaryTree(nums , low , index - 1);
        root.right = constructMaximumBinaryTree(nums , index + 1 , high);
        return root;
    }


}
