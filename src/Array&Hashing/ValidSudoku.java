//36. Valid Sudoku
public class ValidSudoku {
    
}
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row=new boolean[9][9];
        boolean[][] col=new boolean[9][9];
        boolean[][] square=new boolean[9][9];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if (board[i][j] == '.') {
                    continue;
                  }
                  int num = board[i][j] - '1';
                  //to verify if row[i][num] is already exist
                  //if exsit, then repeat,then return false
                  if (row[i][num]) {
                    return false;
                  }
                  row[i][num] = true;
                  if (col[j][num]) {
                    return false;
                  }
                  col[j][num] = true;
                  if (square[(i / 3) * 3 + j / 3][num]) {
                    return false;
                  }
                  square[(i / 3) * 3 + j / 3][num] = true;
                }
              }
              return true;

            }
}

