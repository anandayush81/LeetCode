class Solution {
    int area=0;
    private void dfs(int grid[][], boolean vis[][], int n, int m, int i, int j){
        if(i<0 || j<0 || i>=n || j>=m || vis[i][j]==true || grid[i][j]==0)
        return;
        area++;
        vis[i][j]=true;
        dfs(grid, vis,n,m,i-1,j);
        dfs(grid, vis,n,m,i+1,j);
        dfs(grid, vis,n,m,i,j-1);
        dfs(grid, vis,n,m,i,j+1);

    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=Integer.MIN_VALUE;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    area=0;
                    // vis[i][j]=true;
                    dfs(grid, vis, n,m,i,j);
                    ans=Math.max(area,ans);
                }
            }
        } 
        return ans==Integer.MIN_VALUE? 0:ans;
        
    }
}