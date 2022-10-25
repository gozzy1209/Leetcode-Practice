package Graphs;

import java.util.LinkedList;

//200. Number of Islands
//很经典的题目，值得做十遍
/* Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 */
public class NumberofIslands {
    
}
class Solution {
    public int numIslands_dfs(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    // 通过dfsfill方法把当前点周围值是‘1’的所有点变为0
                    dfsfill(grid, i, j);
                    //陆地数加1
                    count++;
                }
            }
        }
        return count;
        
    }
    public void dfsfill(char[][] grid,int i,int j) {
        //通过dfs思想解决（深度优先，先直接一条路走到黑）
        // 通过dfsfill方法把当前点周围值是‘1’的所有点变为0
        //通过递归不断扫描周围点
        if(i>=0&&j>=0&&i<grid.length&&j<grid[0].length&&grid[i][j]=='1'){
            grid[i][j]='0';
            dfsfill(grid, i+1, j);
            dfsfill(grid, i-1, j);
            dfsfill(grid, i, j+1);
            dfsfill(grid, i, j-1);
        }
    }


    public int numIslands_bfs(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    // 通过bfsfill方法把当前点周围值是‘1’的所有点变为0
                    dfsfill(grid, i, j);
                    //陆地数加1
                    count++;
                }
            }
        }
        return count;
        
    }
    public void bfsfill(char[][] grid,int i,int j) {
        //通过bfs思想解决（层数优先）,bfs永远和queue有关
        //通过bfsfill方法把当前点周围值是‘1’的所有点变为0
        //bfs没有递归，通过queue！=null和while来不断遍历

        //把当前结点变为0
        grid[i][j]='0';
        int n=grid.length;
        int m=grid[0].length;
        LinkedList<Integer> queue=new LinkedList<>();
        //code的作用是为了下面算出坐标
        int code=i*m+j;
        queue.offer(code);
        while(!queue.isEmpty()){
            code=queue.poll();
            i=code/m;
            j=code%m;
            //mark ajacent '1' as '0'
            if(i>0&&grid[i-1][j]=='1'){
                //offer next code to continue while loop
                queue.offer((i-1)*m+j);
                grid[i-1][j]='0';
            }
            if(i<n-1&&grid[i+1][j]=='1'){
                queue.offer((i+1)*m+j);
                grid[i+1][j]='0';
            }
            if(j>0&&grid[i][j-1]=='1'){
                queue.offer(i*m+(j-1));
                grid[i][j-1]='0';
            }
            if(j>m-1&&grid[i-1][j]=='1'){
                queue.offer(i*m+(j+1));
                grid[i][j+1]='0';
            }
        }

        
        
    }
    
}
