package Trees;
//543Diameter of Binary Tree
public class DiameterofBinaryTree {
    class Solution {
        public int[] res={0};
        public int diameterOfBinaryTree(TreeNode root) {
            //every treenode has 2 characters: height and diameter
            //height is easy to understand
            //diameter= root.left's height + root.right's height
            dfs(root);
            return res[0];

        }
        private int dfs(TreeNode root) {
            if(root==null) return 0;
            int left=dfs(root.left);
            int right=dfs(root.right);
            res[0]=Math.max(res[0], left+right);
            return Math.max(left, right)+1;
        }
    }
}
