class Solution {
    private void dfs(char grid[][], boolean vis[][], int n, int m, int i, int j){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]!='O' )
        return;
        
        grid[i][j]='Z';
        dfs(grid, vis,n,m,i-1,j);
        dfs(grid, vis,n,m,i+1,j);
        dfs(grid, vis,n,m,i,j-1);
        dfs(grid, vis,n,m,i,j+1);

    }
    public void solve(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        boolean vis[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if( (i==0 || i==n-1 || j==0 || j==m-1) &&  grid[i][j]=='O'){
                    dfs(grid, vis, n,m,i,j);
                }
            }
        } 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if( grid[i][j]=='O'){
                    grid[i][j]='X';
                }
                //this else if correctly works bcoz, once we traverse a cell and change Z to O
                //we won't visit back that cell and change O to X'
                else if(grid[i][j]=='Z')
                grid[i][j]='O';
                
            }
        } 
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if( grid[i][j]=='Z'){
        //             grid[i][j]='O';
        //         }      
        //     }
        // }
        
    }
}

