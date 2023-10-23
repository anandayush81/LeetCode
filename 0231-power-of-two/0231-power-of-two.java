class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        return ((n&(n-1))==0)? true:false;

        // if(n==0) return false;
        // System.out.println(Math.log(n)/Math.log(2));
        // System.out.println(Math.floor(Math.log(n)/Math.log(2)));
        // System.out.println(Math.ceil(Math.log(n)/Math.log(2)));
        // return (int)Math.floor(Math.log(n)/Math.log(2))==(int)Math.ceil(Math.log(n)/Math.log(2));
    }
}