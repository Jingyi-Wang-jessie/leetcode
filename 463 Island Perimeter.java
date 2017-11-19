/*
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        int peri = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};
        
        for(int i =0;i<m;i++){
            for(int j =0; j<n;j++){
                if(grid[i][j] == 1){
                    for(int k=0;k<4;k++){
                        int i_n = i+dx[k];
                        int j_n = j+dy[k];
                        if(i_n<0 |i_n>=m |j_n<0 |j_n>=n){
                            peri ++;
                        }else if(grid[i_n][j_n] == 0){
                            peri ++;
                        }
                    }
                }
            }
        }
        
        return peri;
    }
}