class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for(int i = 0 ; i< rows; i++){
            for(int j = 0; j < cols ; j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid,int rows , int cols){
        if(rows<0 || cols<0||rows >= grid.length|| cols>=grid[0].length||grid[rows][cols]=='0'){
            return;
        }
        grid[rows][cols] = '0';
        dfs(grid,rows+1,cols);
        dfs(grid,rows-1,cols);
        dfs(grid,rows,cols+1);
        dfs(grid,rows,cols-1);
    }
}