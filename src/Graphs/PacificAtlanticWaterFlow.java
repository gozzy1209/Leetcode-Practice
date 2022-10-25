package Graphs;
import java.util.ArrayList;
import java.util.Arrays;
//417. Pacific Atlantic Water Flow
//https://www.bilibili.com/video/BV1754y1v7jt/?spm_id_from=333.337.search-card.all.click&vd_source=cb373396d076ae1cf2982fbf8f4e7c53
import java.util.LinkedList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    
}
class Solution {
    private boolean[][] atlantic, pacific, visited;
    private int M, N;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        M = matrix.length;
        if (M == 0) return res;
        N = matrix[0].length;
        atlantic = new boolean[M][N];
        pacific = new boolean[M][N];
        visited = new boolean[M][N];
        dfs(pacific, matrix, 0, 0, 0, 0);
        visited = new boolean[M][N];
        dfs(atlantic, matrix, M - 1, N - 1, M - 1, N - 1);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (atlantic[i][j] && pacific[i][j]) res.add(Arrays.asList(new Integer[]{i, j}));
            }
        }
        return res;
    }
    
    private void dfs(boolean[][] ocean, int[][] matrix, int i, int j, int i_border, int j_border) {
        ocean[i][j] = true;
        visited[i][j] = true;
        if (i - 1 >= 0 && !visited[i - 1][j] && (i - 1 == i_border || j == j_border || matrix[i - 1][j] >= matrix[i][j]))
            dfs(ocean, matrix, i - 1, j, i_border, j_border);
        if (j - 1 >= 0 && !visited[i][j - 1] && (j - 1 == j_border || i == i_border || matrix[i][j - 1] >= matrix[i][j]))
            dfs(ocean, matrix, i, j - 1, i_border, j_border);
        if (i + 1 < M && !visited[i + 1][j] && (j == j_border || i + 1 == i_border || matrix[i + 1][j] >= matrix[i][j]))
            dfs(ocean, matrix, i + 1, j, i_border, j_border);
        if (j + 1 < N && !visited[i][j + 1] && (i == i_border || j + 1 == j_border || matrix[i][j + 1] >= matrix[i][j]))
            dfs(ocean, matrix, i, j + 1, i_border, j_border);
    }
}
