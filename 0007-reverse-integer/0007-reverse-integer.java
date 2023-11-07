class Solution {
    public int reverse(int x) {
        int ans=0;
        while(x!=0){
            int d=x%10;
            if(ans>Integer.MAX_VALUE/10 || ans<Integer.MIN_VALUE/10)
            return 0;

            ans=(ans*10)+d;
            x=x/10;
        }
        return ans;
    }
}





// class Solution {
//     public int reverse(int x) {
//         int sign=1;
//         if(x<0) sign=-1;
//         x=x*sign;
//         String str=""+x;
//         if(str.length()>10) return 0;
//         String s=new StringBuilder(str).reverse().toString();
//         // long val=Integer.parseInt(s);
//         long val=Long.parseLong(s);
//         if(val>2147483647 || sign*val<2147483648) return 0;
//         return (int)sign*val;
//     }
// }



// class Solution {
//     public int reverse(int x) {
//         int sign=1;
//         if(x<0) sign=-1;
//         x=x*sign;
//         String str=""+x;
//         if(str.length()>10) return 0;
        
//         String s=new StringBuilder(str).reverse().toString();
//         long val=(long)Integer.parseInt(s);
//         if(val>2147483647) return 0;
//         return (int)sign*val;

//     }
// }