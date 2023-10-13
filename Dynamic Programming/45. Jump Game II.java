// The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd], curFarthest is the farthest point that all points in [curBegin, curEnd] can reach. Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest, then keep the above steps, as the following:
//Greedy
class Solution{
		public int jump(int[] A) {
		int jumps = 0, curEnd = 0, curFarthest = 0;
		for (int i = 0; i < A.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + A[i]);
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;
			}
		}
		return jumps;
	}
}




//memoization
//This is O(n2) solution
class Solution {
    int dp[]; //dp[i] stores min steps to reach end from this index
    private int solve(int nums[], int idx, int n){
        if(idx>=n-1) return 0;
        // if(idx>=n) return 0;
        // if(idx==n-1) return 1;
        // if(nums[idx]==0) return 0;
        if(dp[idx]!=-1) return dp[idx];
        
        int minsteps=(int)1e9;
        for(int i=1;i<=nums[idx];i++){ //This O(n2) since we're travrsing from 1 to a[i] which could be ~10^9'
            int steps=solve(nums,idx+i,n);
            minsteps=Math.min(minsteps,steps);
            
        }
        return dp[idx]=1+minsteps;
    }
    public int jump(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums, 0, nums.length);//we've not handles the case if the end is not reachable, bcoz the ques says the end will always be reachable'

    }
}


Better Solution


class Solution {
    public int jump(int[] nums) {
        long[] memo = new long[nums.length];
        Arrays.fill(memo, -1);
        return (int) slv(0, nums, memo);
    }

    private long slv(int n, int[] jumps, long[] memo) {
        if (n == jumps.length - 1) return 0;
        if (memo[n] != -1) return memo[n];
        long min = Integer.MAX_VALUE;
        for (int i = n + 1; i <= Math.min(jumps.length - 1, n + jumps[n]); i++)
            min = Math.min(min, 1 + slv(i, jumps, memo));
        return memo[n] = min;
    }
}


// class Solution {
//     int dp[];
//     int solve(int i, int n, int nums[], int prev){
//         if(i>=n-1) return 0;
//         // if(i==prev) return (int)1e9;
//         if(dp[i]!=-1) return dp[i];
//         int mini=(int)1e9;
//         // if nums[i]==0, then this below loop would not execute.
//         //And if the the first value of nums array would be 0, 
//         //then 1e9+1 would be returned indicating that 
//         //it's impossible to reach the end from here
//         for(int k=1;k<=nums[i];k++){
//             int jump=solve(i+k, n, nums, i);
//             mini=Math.min(mini, jump);
//         }
//         return dp[i]=1+mini;
//     }
//     public int jump(int[] nums) {
//         int n=nums.length;
//         //dp state dp[i] indicates the minimum no of steps to reach the end from this index i
//         dp=new int[n];
//         Arrays.fill(dp,-1);
//         return solve(0,n,nums, -1);//Passing initial value of parent as -1
//         //In the question it says that we can jump j poisitions where 0<=j<=nums[i]
//         //So I have taken a parent variable to prevent infinite loop when k=0
//         //However taking k=1 also works since it's logical that why would we want to 
//         //remain at the same position just to increase the numberof jumps and infinite loop'
//     }
// }



