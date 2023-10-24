//instead of trying to find the minimum number of operations, why don't we focus on finding the longest subarray in the middle. One main thing to note is that our subarray should sum to sum - x (where sum is the sum of all elements in our array).
class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int sum=0;
        for(int e:nums){
            sum+=e;
        }
        if(x>sum) return -1;
        int k=sum-x;
        //find pf sum
        int pf[]=new int[n+1];
        for(int i=1;i<=n;i++){
            pf[i]=pf[i-1]+nums[i-1];
        }
        // System.out.println(Arrays.toString(pf));
        int i=0,j=0;
        int maxlen=Integer.MIN_VALUE;
        int len=0;
        int flag=0;
        while(j<=n && i<=n){
            if(pf[j]-pf[i]==k){
                len=j-i;
                maxlen=Math.max(maxlen, len);
                i++;
                j++;
                
            }
            else if(pf[j]-pf[i]<k)
                j++;
            else{
                i++;
                if(i==j)
                j++;
            }

        }
        if(maxlen==Integer.MIN_VALUE) return -1;
        return n-maxlen;
        


    }
}