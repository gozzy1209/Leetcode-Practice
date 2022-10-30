package Trees;
//235. Lowest Common Ancestor of a Binary Search Tree
/*Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).” */
public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //判断ancestor的条件是，p和q一个在ancestor左边，一个在右边
        //这个判断条件太难想到了，非常关键
        
        //all in right
        if(p.val>root.val&&q.val>root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        //all in left
        if(p.val<root.val&&q.val<root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
        
    }
}

