package Chapter25BST.algs;

import Chapter25BST.pratice.MyBST;
import Chapter25BST.pratice.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * morris遍历的实现原则
 * 记作当前节点为cur。
 *
 * 如果cur无左孩子，cur向右移动（cur=cur.right）
 * 如果cur有左孩子，找到cur左子树上最右的节点，记为mostright
 * 如果mostright的right指针指向空，让其指向cur，cur向左移动（cur=cur.left）
 * 如果mostright的right指针指向cur，让其指向空，cur向右移动（cur=cur.right）
 * 实现以上的原则，即实现了morris遍历。
 *
 */

public class MorrisTest { //也叫线索化二叉树
    public static void main(String[] args) {
        MyBST myBST = new MyBST(
                new Integer[]{9 , 4 , 6, 3 ,14 , 12 , 17});//unbalanced
        //printTree(myBST);
        System.out.println("Inorder:");
        System.out.println(Morris_InOrder(myBST.getRoot()));
        System.out.println("Preorder:");
        System.out.println(Morris_PreOrder(myBST.getRoot()));
        Morris_PreOrder(myBST.getRoot());
        System.out.println("Postorder:");
        System.out.println(Morris_PostOrder(myBST.getRoot()));
        Morris_PostOrder(myBST.getRoot());

    }

    /**
     * Morris 遍历算法整体步骤如下（假设当前遍历到的节点为 xx）：
     *  如果 xx 无左孩子，先将 xx 的值加入答案数组，再访问 xx 的右孩子，即 x=x.right。
     *  如果 xx 有左孩子，则找到 xx 左子树上最右的节点（即左子树中序遍历的最后一个节点，xx 在中序遍历中的前驱节点），我们记为 predecessor。根据 predecessor 的右孩子是否为空，进行如下操作。
     *  如果 predecessor 的右孩子为空，则将其右孩子指向 xx，然后访问 xx 的左孩子，即 x = x.left。
     *  如果 predecessor 的右孩子不为空，则此时其右孩子指向 xx，说明我们已经遍历完 xx 的左子树，我们将 predecessor 的右孩子置空，将 xx 的值加入答案数组，然后访问 xx 的右孩子，即 x = x.right。
     *  重复上述操作，直至访问完整棵树。
     *
     */
    public static List<Integer> Morris_InOrder(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add((Integer) root.element);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add((Integer) root.element);
                root = root.right;
            }
        }
        return res;
    }


    /**
     *
     * 其前序遍历规则总结如下：
     * 新建临时节点，令该节点为 root；
     *
     * 如果当前节点的左子节点为空，将当前节点加入答案，并遍历当前节点的右子节点；
     *
     * 如果当前节点的左子节点不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点：
     *
     * 如果前驱节点的右子节点为空，将前驱节点的右子节点设置为当前节点。然后将当前节点加入答案，
     * 并将前驱节点的右子节点更新为当前节点。当前节点更新为当前节点的左子节点。
     *
     * 如果前驱节点的右子节点为当前节点，将它的右子节点重新设为空。当前节点更新为当前节点的右子节点。
     * 重复步骤 2 和步骤 3，直到遍历结束。
     *
     */
    public static List<Integer> Morris_PreOrder(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        TreeNode p1 = root, p2 = null;

        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {//keep going right
                    p2 = p2.right;
                }
                if (p2.right == null) {//to the end
                    res.add((Integer) p1.element);
                    p2.right = p1;//connect cur node with the returned node
                    p1 = p1.left;//go left
                    continue;
                } else {
                    p2.right = null;
                }
            }
            else {//left subtree finished
                res.add((Integer) p1.element);
            }
            p1 = p1.right;//return to upper node
        }
        return res;

    }

    /**
     * 其后序遍历规则总结如下：
     *
     * 新建临时节点，令该节点为 root；
     *
     * 如果当前节点的左子节点为空，则遍历当前节点的右子节点；
     *
     * 如果当前节点的左子节点不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点；
     *
     * 如果前驱节点的右子节点为空，将前驱节点的右子节点设置为当前节点，当前节点更新为当前节点的左子节点。
     *
     * 如果前驱节点的右子节点为当前节点，将它的右子节点重新设为空。倒序输出从当前节点的左子节点到该前驱节点这条路径上的所有节点。当前节点更新为当前节点的右子节点。
     *
     * 重复步骤 2 和步骤 3，直到遍历结束。
     *
     */

    /**
    public static List<Integer> Morris_PostOrder(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        TreeNode p1 = root, p2 = null;

        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1) {
                    p2 = p2.right;
                }
                if (p2.right == null) {
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                    addPath(res, p1.left);
                }
            }
            p1 = p1.right;
        }
        addPath(res, root);
        return res;
    }

    public static void addPath(List<Integer> res, TreeNode node) {
        int count = 0;
        while (node != null) {
            ++count;
            res.add((Integer) node.element);
            node = node.right;
        }
        int left = res.size() - count, right = res.size() - 1;
        while (left < right) {
            int temp = res.get(left);
            res.set(left, res.get(right));
            res.set(right, temp);
            left++;
            right--;
        }
    }

     */

    public static List<Integer> Morris_PostOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        TreeNode virNode = new TreeNode(-1);  //建立临时节点
        virNode.left = root;    //设置临时节点的左子节点为根节点
        TreeNode cur = virNode;
        while(cur != null) {
            if(cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode tmp = cur.left;
                while(tmp.right != null && tmp.right != cur)
                    tmp = tmp.right;
                if(tmp.right == null) {
                    tmp.right = cur;  //找到当前节点的前驱节点
                    cur = cur.left;
                } else {
                    tmp.right = null;  //恢复二叉树
                    TreeNode t = cur.left;
                    List<Integer> tmpList = new ArrayList<>();
                    while(t != null) {  //倒序输出当前节点左子节点到当前节点前驱节点路径上的所有节点
                        tmpList.add(0, (Integer) t.element);
                        t = t.right;
                    }
                    res.addAll(tmpList);
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    public static void printTree(MyBST tree){
        System.out.println("Inorder: ");
        tree.inorder();
        System.out.println("\nPreorder: ");
        tree.preorder();
        System.out.println("\nPostorder: ");
        tree.postorder();
    }
}
