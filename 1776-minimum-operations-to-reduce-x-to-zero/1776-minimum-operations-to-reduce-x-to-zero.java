// class Solution {
//     public int minOperations(int[] nums, int x) {
//         long sum=0; int n=nums.length;
//         for (int i=0;i<n;i++){
//             sum+=nums[i];
//         }
//         if(x>sum) return -1;
//         if(x==sum) return n; //edge case when the entire array needs to be subtracted from x
//         long target = sum-x;
//         int maxi=Integer.MIN_VALUE;
//         Map<Long, Integer>mp=new HashMap<>();
//         long s=0;
//         mp.put(0L,-1);
        
//         for(int i=0;i<n;i++){
//             s=s+nums[i];
//             if(mp.containsKey(s-target)){
//                 maxi=Math.max(maxi, (i-mp.get(s-target)));
//             }
//             if(!mp.containsKey(s)) mp.put(s,i);
//         }
//         if(maxi==Integer.MIN_VALUE) return -1;
//         return n-maxi;
        
//     }
// }


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