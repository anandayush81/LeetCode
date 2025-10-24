class Solution {
    public int minOperations(int[] nums, int x) {
        long sum=0; int n=nums.length;
        for (int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(x>sum) return -1;
        if(x==sum) return n;
        long target = sum-x;
        int maxi=Integer.MIN_VALUE;
        Map<Long, Integer>mp=new HashMap<>();
        long s=0;
        mp.put(0L,-1);
        
        for(int i=0;i<n;i++){
            s=s+nums[i];
            if(mp.containsKey(s-target)){
                maxi=Math.max(maxi, (i-mp.get(s-target)));
            }
            if(!mp.containsKey(s)) mp.put(s,i);
        }
        if(maxi==Integer.MIN_VALUE) return -1;
        return n-maxi;
        
    }
}