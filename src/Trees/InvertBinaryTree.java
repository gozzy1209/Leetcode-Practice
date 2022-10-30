package Trees;
//226. Invert Binary Tree
//Given the root of a binary tree, invert the tree, and return its root.
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        //swap is the critical
        if(root==null){return null;}

        if(root.left!=null||root.right!=null){
         TreeNode temp=root.right;
         root.right=root.left;
         root.left=temp;
        }
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
    
