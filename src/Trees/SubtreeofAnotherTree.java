package Trees;
//572. Subtree of Another Tree
/*Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself. */
public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null){
            return true;
        }
        else if(root==null)
        //事实上这种情况已经暗含了subroot！=null，看上一步，只是简写了而已
        {
            return false;
        }
        else if(isSameTree(root, subRoot)==true){
            return true;
        }
        return isSubtree(root.left, subRoot)||isSubtree(root.right, subRoot);
    }
    boolean isSameTree(TreeNode p, TreeNode q) {
        //recursive and dfs method
        if(p==null&&q==null){
            return true;
        }
        if(p!=null&&q!=null&&p.val==q.val){
            return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
        }
        return false;
        
    }
}

