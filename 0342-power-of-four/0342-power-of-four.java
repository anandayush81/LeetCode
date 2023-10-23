class Solution {
    public boolean isPowerOfFour(int n) {
        
        // if(n==0) return false;
        // return Math.floor(Math.log(n)/Math.log(4))==Math.ceil(Math.log(n)/Math.log(4));


        if((n&(n-1))!=0) return false;
        return (n-1)%3==0;


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