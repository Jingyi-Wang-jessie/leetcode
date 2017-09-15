/*
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.
*/

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int r = A.length;
        int c = A[0].length;
        int m = B[0].length;
        
        int[][] res = new int[r][m];
        
        for (int i=0;i<r;i++){
            for (int j=0;j<m;j++){
                res[i][j] = 0;
                for (int k=0;k<c;k++){
                    if (A[i][k] != 0 && B[k][j] != 0){
                        res [i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        
        return res;
        
        
    }
}