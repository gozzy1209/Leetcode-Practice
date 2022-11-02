package Trees;
//110Balanced Binary Tree
public class BalancedBinaryTree {
        int max_gap=0;
        public boolean isBalanced(TreeNode root) {
            //use recursive method to return root.left and root.right's height
            height(root);
            return 1>=max_gap;

        }
        private int height(TreeNode root) {
            //可以记住下面这个模板
            if(root==null) return 0;
            int left=height(root.left);
            int right=height(root.right);
            max_gap=Math.max(max_gap,left-right);
            max_gap=Math.max(max_gap,right-left);
            return Math.max(left, right)+1;
        }
    
}
