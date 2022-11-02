package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//104. Maximum Depth of Binary Tree
/*Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node. */
class MaximumDepthofBinaryTree {
    public int maxDepth_recursive(TreeNode root) {
        //recursive
        //dfs
           if(root==null){return 0;}
           //1 represents the root itself
           return 1+Math.max(maxDepth_recursive(root.left), maxDepth_recursive(root.right));
       }

       public int maxDepth_dfs(TreeNode root) {
        //dfs
        if(root==null){return 0;}
        Stack<TreeNode> stack=new Stack<>();
        Stack<Integer> depth=new Stack<>();
        stack.push(root);
        depth.push(1);
        int max=0;
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            int temp=depth.pop();
            //这一步很关键
            max=Math.max(max, temp);
            //先左还是先右感觉不是很重要，毕竟最终都会被pop出
            if(node.left!=null){
                stack.push(node.left);
                depth.push(temp+1);
            }
            if(node.right!=null){
                stack.push(node.right);
                depth.push(temp+1);
            }
        }
        return max;
       }
       public int maxDepth_bfs(TreeNode root) {
        //bfs 一层一层数，而不是像dfs直接深入到最底
        //use queue
        // queue.offer(),TreeNode node=queue.poll(),int size=queue.size() are critical
        if(root==null){return 0;}
        //queue 的本质还是linkedlist？
        Queue<TreeNode> queue=new LinkedList<>();
        //add
        queue.offer(root);
        int count=0;
        while(!queue.isEmpty()){
            //扫描size
            int size=queue.size();
            //只传出size个元素，即一层全部元素，多一个不多，少一个不少
            while(size-->0){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    //传入下一层元素
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
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
    


