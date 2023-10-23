class Solution {
    public boolean isPowerOfTwo(int n) {
        //Maths solution
        // if(n<=0) return false;
        // return ((n&(n-1))==0)? true:false;

        
        if (n <= 0) {
            return false;
        }
        
        int a = (int) (Math.log(n) / Math.log(2));
        /*
            4^a = n
            a = log(n) to base 4
            a = log(n) to base e / log(4) to base e
        */
        
        return n == Math.pow(2, a);
        
        
        // if(n==0) return false;
        // System.out.println(Math.log(n)/Math.log(2));
        // System.out.println(Math.floor(Math.log(n)/Math.log(2)));
        // System.out.println(Math.ceil(Math.log(n)/Math.log(2)));
        // return (int)Math.floor(Math.log(n)/Math.log(2))==(int)Math.ceil(Math.log(n)/Math.log(2));
    }
}