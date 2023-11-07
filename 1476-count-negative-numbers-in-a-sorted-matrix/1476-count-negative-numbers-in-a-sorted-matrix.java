class Solution {
    public int countNegatives(int[][] mat) {
        int n=mat.length; int m=mat[0].length;
        int i=0,j=m-1; int cnt=0;
        while(i<n && j>=0){
            if(mat[i][j]<0){
                cnt+=n-i;
                j--;
            }
            else i++;
        }
        return cnt;
        
    }
}