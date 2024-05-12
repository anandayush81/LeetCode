class Solution {
    public int solve(int nums[], int dp[], int l, int r)
    {
        if(r<l) return 0;
        else if(r==l) return nums[l];
        if(dp[r]!=-1) return dp[r];
        dp[r]=Math.max(nums[r]+solve(nums, dp, l, r-2), solve(nums, dp, l, r-1));
        return dp[r];
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        int maxi=Integer.MIN_VALUE;
        maxi=Math.max(maxi, solve(nums, dp, 0,n-2));
        Arrays.fill(dp,-1);
        maxi=Math.max(maxi, solve(nums, dp, 1,n-1));
        return maxi;
    }
}
