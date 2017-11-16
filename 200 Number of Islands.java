/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*/

class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length ==0 | grid == null){
            return 0;
        }
        
        int numOfIslands = 0;
        
        for(int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    explore(grid, i, j);
                    numOfIslands ++;
                }
            }
        }
        
        return numOfIslands;
    }
    
    private void explore(char[][] grid, int i, int j){
        grid[i][j] = 'x';
        
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};
        
        for (int k =0; k<4;k++){
            int i_new = i+dx[k];
            int j_new = j+dy[k];
            
            if (i_new <grid.length && i_new >=0 && j_new <grid[0].length && j_new >=0 && grid[i_new][j_new] == '1'){
                explore(grid, i_new, j_new);
            }
        }
    }
}