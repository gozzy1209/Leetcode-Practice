package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//102. Binary Tree Level Order Traversal
/*Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level). */
public class BinaryTreeLevelOrderTraversal {
    
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //only BFS can be used which means Queue
        //涉及到一层一层的遍历，尽量想到BFS
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> res=new LinkedList<>();
        if(root!=null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> temp=new LinkedList<>();
            while(size-->0){
                TreeNode node=queue.poll();
                temp.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
    public List<List<Integer>> levelOrder_2ndtry(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> res=new LinkedList<>();
        if(root!=null){
            queue.offer(root);
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> temp=new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode out=queue.poll();
                temp.add(out.val);
                if(out.left!=null) queue.offer(out.left);
                if(out.right!=null) queue.offer(out.right);
            }
            res.add(temp);
        }
        return res;
    }
}