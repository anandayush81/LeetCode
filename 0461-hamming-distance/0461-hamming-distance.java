class Solution {
    public int hammingDistance(int x, int y) {
        boolean xset=false, yset=false; int cnt=0;
        for(int i=31;i>=0;i--){
            if(((x>>i)&1)==1) xset=true; else xset=false;
            if(((y>>i)&1)==1) yset=true; else yset=false;
            if(xset==!yset) cnt++;
        }
        return cnt; 
    }
}

//copied

// public class Solution {
//     public int hammingDistance(int x, int y) {
//         return Integer.bitCount(x ^ y);
//     }
// }

// //copied

// public int hammingDistance(int x, int y) {
//     int res = 0;
//     int m = x^y;                  // take the xor of two numbers
//     while(m != 0){                // count the no of "1"s 
//         if((m&1) == 1)
//             res++;
//         m = m>>1;
//     }
//     return res;
// }