package Trees;

import java.util.Stack;

//230. Kth Smallest Element in a BST
/*
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class KthSmallestElementinaBST {
    
}
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        //当你碰见tree的题目，要不递归，要不stack（dfs），要不queue（bfs）
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        int count=0;
        while(cur!=null){
            //先把最左边（最小）全打进去，如果可以的话
            stack.push(cur);
            cur=cur.left;
        }
        while(count<=k){
            //找目标最小是否存在，以及打右边
            cur=stack.pop();
            count++;
            if(count==k){
                return cur.val;
            }
            //下面这个很关键
            cur=cur.right;
            while (cur!= null) {
              stack.push(cur);
              cur = cur.left;
          }

        }
        return -1;


        
    }
}
