package BackTracking;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//39. Combination Sum
/*Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input. */
public class CombinationSum {
    
}
class Solution {
    //backtracking回溯的关键思想就是一条路走到黑，不行就是下一种，直到全部可能性走完
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        backtracking(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> templist,int[] candidates,int remain,int start){
            if(remain<0){
                return;
            }
            else if(remain==0){
                //如果刚刚好到target那就返回当前值
                //new ArrayList<>(templist)是表示复制当前的templist，而不能直接加templist
                res.add(new ArrayList<>(templist));
            }
            else{
                //如果小于target，那就继续加元素
                for(int i=start;i<candidates.length;i++){
                    templist.add(candidates[i]);
                    // not i + 1 because we can reuse same elements
                    backtracking(res, templist, candidates, remain-candidates[i], i);
                    templist.remove(templist.size());
                }
            }
    }
}
