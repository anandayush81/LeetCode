class Solution {
    public int lis(int dp[], int nums[], int n)
    {
        dp[0]=1;
        int ans=1;
        for(int i=1;i<n;i++)
        {
            int c=0;
            for(int j=i-1;j>=0;j--)
            {
                if(nums[j]<nums[i])
                c=Math.max(c, dp[j]);
            }
            dp[i]=1+c;
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return lis(dp,nums,n);
        // return dp[n-1];
        
    }
}