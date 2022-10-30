package Trees;
//98. Validate Binary Search Tree
/*
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        int min=Integer.MIN_VALUE;
        int max=Integer.MAX_VALUE;
        return ValidBST(root, min, max);
        //下面新设的方法很重要，设置min边界和max是重中之重！
}
    public boolean ValidBST(TreeNode root, int min, int max){
        if(root==null){
            return true;
        }
        else if(root.val>=max||root.val<=min){
                return false;
        }
        return ValidBST(root.left, min, root.val)&&ValidBST(root.right, root.val, max);
        }
}

