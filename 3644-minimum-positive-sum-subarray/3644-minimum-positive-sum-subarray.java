class Solution {
    private int solve(int ar[], int k, int n){
        //this functions should return the min positive subarray sum of subarray size k
        int l=0, r=0; int s=0; int minpossum=Integer.MAX_VALUE;
        while(r<n){
            if((r-l+1)<k){
                s+=ar[r];
                r++;
            }
            else if((r-l+1)==k){
                s+=ar[r];
                if(s>0)
                    minpossum=Math.min(minpossum,s);
                s-=ar[l];
                l++;
                r++;
            }

        }
        System.out.println("For k = "+ k + " min pos sum is "+ minpossum);
        return minpossum;

    }
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int ar[]=new int[n];
        for(int i=0;i<n;i++){
            ar[i]=nums.get(i);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=l;i<=r;i++){
            int temp=solve(ar,i,n);
            if(temp!=Integer.MAX_VALUE)
                ans=Math.min(ans, temp);
        }
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}