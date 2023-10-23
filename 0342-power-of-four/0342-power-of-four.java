class Solution {
    public boolean isPowerOfFour(int n) {
        
        // if(n==0) return false;
        // return Math.floor(Math.log(n)/Math.log(4))==Math.ceil(Math.log(n)/Math.log(4));

        // if(n<=0) return false;
        // if((n&(n-1))!=0) return false;
        // return (n-1)%3==0;


        if (n <= 0) {
            return false;
        }
        
        int a = (int) (Math.log(n) / Math.log(4));
        /*
            4^a = n
            a = log(n) to base 4
            a = log(n) to base e / log(4) to base e
        */
        
        return n == Math.pow(4, a);

        // int cnt=0;
        // for(int i=0;i<32;i++){
        //     if((n&(1<<i))!=0)
        //     cnt++;
        // }
        // if(cnt!=1) return false;
        // for(int i=0;i<32;i+=2){
        //     if((n&(1<<i))!=0)
        //     return true;
        // }
        // return false;
        
    }
}