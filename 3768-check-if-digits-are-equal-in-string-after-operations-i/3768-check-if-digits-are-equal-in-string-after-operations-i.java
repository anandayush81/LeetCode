//Pascal Triangle and Binomial Coeffcient Solution:
//https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/solutions/7293868/pascal-s-triangle-combinatorial-modulo-arithmetic-java/


//proof that mod can be taken either at every step or at the end: https://chatgpt.com/c/68fa4dbe-1320-8320-bd13-5d7f5e37a3bf

//(x+y)mod m=((x mod m)+(y mod m))mod m

class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        int k = n - 2;
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) digits[i] = s.charAt(i) - '0';

        int[] row = new int[k + 1];
        row[0] = 1;
        for (int r = 1; r <= k; r++) {
            int[] next = new int[r + 1];
            next[0] = 1;
            next[r] = 1;
            for (int j = 1; j < r; j++) {
                next[j] = (row[j - 1] + row[j]) % 10;
            }
            row = next;
        }

        // int first = 0, second = 0;
        // for (int i = 0; i <= k; i++) {
        //     // first = (first + row[i] * digits[i]) % 10;
        //     // second = (second + row[i] * digits[i + 1]) % 10;
        // }
        // return first == second;

        int first = 0, second = 0;
        for (int i = 0; i <= k; i++) {
            
            first = (first + row[i] * digits[i]) ;
            second = (second + row[i] * digits[i + 1]) ;
        }

        return first%10 == second%10;
    }
}


//my sol
// class Solution {
//     public boolean hasSameDigits(String s) {
//         String str=s;
//         while(str.length()>2){
//             String str3="";
//             int len=str.length();
//             for(int i=0;i<len-1;i++){
//                 String str2=str.substring(i,i+2);
//                 int temp= ( (Integer.parseInt(""+str2.charAt(0))) + (Integer.parseInt(""+str2.charAt(1))) )%10;
//                 str3+=temp;
//             }
//             System.out.println("At each step str= "+str3);
//             str=str3;
//         }
//         if(str.length()==2 && str.charAt(0)==str.charAt(1)) return true;
//         return false; 
//     }
// }



// public class Solution {
//     public boolean hasSameDigits(String s) {
//         int n = s.length();
//         char[] sArray = s.toCharArray();
//         for (int i = 1; i <= n - 2; i++) {
//             for (int j = 0; j <= n - 1 - i; j++) {
//                 int digit1 = sArray[j] - '0';
//                 int digit2 = sArray[j + 1] - '0';
//                 sArray[j] = (char) (((digit1 + digit2) % 10) + '0');
//             }
//         }
//         return sArray[0] == sArray[1];
//     }
// }