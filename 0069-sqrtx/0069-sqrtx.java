class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1) return x;
        int l=1,r=x/2;
        // int l=1,r=x;
        int ans=-1;
        while(l<=r){
            // int mid=(l+r)/2;
            int mid=(l + (r-l)/2);
            if((long)mid*mid==(long)x){
                return mid;
            }
            else if((long)mid*mid<(long)x){
                ans=mid;//here we're storing ans=mid coz ques is asking for rounded down to the nearest integer
                //if the question had asked for exact integer (i.e. for perfect square's root) we wouldnt store it
                //we'd just directly return as we have in line 11
                l=mid+1;
            }
            else r=mid-1;
        }
        return ans;
        
    }
}