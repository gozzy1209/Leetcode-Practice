package Math;

import java.util.Stack;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int row_first=1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                     matrix[0][j]=0;
                    if(i==0){
                        row_first=0;
                    }
                    else{
                    matrix[i][0]=0;
                    }
                }

            }
        }
        //skip the result row and col to change remain space's result
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[0][j]==0||matrix[i][0]==0){
                   matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
        if(row_first==0){
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i]=0;
            }
        }
        
    }
}

