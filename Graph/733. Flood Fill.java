class Solution {
    private void dfs(int grid[][], int n, int m, int i, int j, int oldcol, int newcol){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]!=oldcol || grid[i][j]==newcol )
        return;
        grid[i][j]=newcol;
        dfs(grid, n,m,i-1,j,oldcol,newcol);
        dfs(grid, n,m,i+1,j,oldcol,newcol);
        dfs(grid, n,m,i,j-1,oldcol,newcol);
        dfs(grid, n,m,i,j+1,oldcol,newcol);

    }
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int n=grid.length;
        int m=grid[0].length;
        int oldcol=grid[sr][sc];
        int newcol=color;
        dfs(grid, n,m,sr,sc, oldcol, newcol);
        return grid;
    }
}