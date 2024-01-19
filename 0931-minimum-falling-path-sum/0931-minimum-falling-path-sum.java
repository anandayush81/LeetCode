/*

class Solution {
    public int minFallingPathSum(int[][] a) {
        int min = Integer.MAX_VALUE;
        int m = a.length;
        int n = a[0].length;
        
        for(int j = 0; j<n; j++){
            int temp = help(m-1,j,a);
            min = Math.min(min,temp);
        }
        return min;
    }
    public int help(int i, int j, int[][] a){
        
        if(i<0 || j<0 || j>a[0].length-1) return (int)Math.pow(10,9);
        if(i==0) return a[i][j];
        
        int left = a[i][j] + help(i-1,j-1,a);
        int up = a[i][j] + help(i-1,j,a);
        int right = a[i][j] + help(i-1,j+1,a);
        
        return Math.min(left,Math.min(up,right));
    }
}

*/


// class Solution {
//     public int minFallingPathSum(int[][] a) {
//         int min = Integer.MAX_VALUE;
//         int m = a.length;
//         int n = a[0].length;
//         int[][] dp=new int[m][n];
//         for(int[] row: dp) Arrays.fill(row,-1);
//         for(int j = 0; j<n; j++){
//             int temp = help(m-1,j,a,dp);
//             min = Math.min(min,temp);
//         }
//         return min;
//     }
//     public int help(int i, int j, int[][] a,int[][] dp){
        
//         if(i<0 || j<0 || j>a[0].length-1) return (int)Math.pow(10,9);
//         if(i==0) return a[i][j];
//         if(dp[i][j] != -1) return dp[i][j];
//         int left = a[i][j] + help(i-1,j-1,a,dp);
//         int up = a[i][j] + help(i-1,j,a,dp);
//         int right = a[i][j] + help(i-1,j+1,a,dp);
        
//         return dp[i][j] = Math.min(left,Math.min(up,right));
//     }
// }



class Solution {
    public int minFallingPathSum(int[][] a) {
        int min = Integer.MAX_VALUE;
        int m = a.length;
        int n = a[0].length;
        
        int[][] dp=new int[m][n];
        for(int[] row: dp) Arrays.fill(row,-1);
        for(int j = 0; j<n; j++) dp[0][j] = a[0][j];
        
        for(int i = 1; i<m; i++){
            for(int j =0; j<n; j++){
                
                int left = a[i][j];
                if(j>0) left += dp[i-1][j-1];
                else left += (int)Math.pow(10,9);
                
                int up = a[i][j] + dp[i-1][j];
                
                int right = a[i][j];
                if(j<a[0].length-1) right += dp[i-1][j+1];
                else right = (int)Math.pow(10,9);
                
                dp[i][j] = Math.min(left,Math.min(up,right));
            }
        }
        
        for(int j = 0; j<n; j++){
            min = Math.min(min,dp[n-1][j]);
        }
        return min;
    }
}
