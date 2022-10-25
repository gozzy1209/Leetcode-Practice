package Math;
//48Rotate Image
public class RotateImage {
    
}
class Solution {
    public void rotate(int[][] matrix) {
        int left=0;
        int right=matrix.length-1;
        while(left<right){
            //every time just rotate right-1 times, or it would go into loop
            //i<right-left is so important
            for(int i=0;i<right-left;i++){
                int top=left;
                int bottom=right;
                int topleft=matrix[top][left+i];
                matrix[top][left+i]=matrix[bottom-i][left];
                matrix[bottom-i][left]=matrix[bottom][right-i];
                matrix[bottom][right-i]=matrix[top+i][right];
                matrix[top+i][right]=topleft;
            }
            //make problem go into sub problem
            right--;
            left++;
        }
    }
}