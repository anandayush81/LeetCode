public class Solution {
    private String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String maxStr = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i + 1);
            if (odd.length() > maxStr.length()) {
                maxStr = odd;
            }
            if (even.length() > maxStr.length()) {
                maxStr = even;
            }
        }
        return maxStr;
    }   
}


//My recursion+memoization solution
/*
public class Solution {
    private Boolean dp[][];
    private Boolean solve(String s, int l, int r) {
        if (l>=r) {
            return true;
        }
        if (dp[l][r] != null) {
            return dp[l][r];
        }
        if(s.charAt(l)==s.charAt(r)){
            return dp[l][r]=solve(s,l+1,r-1);
        }
        return dp[l][r]=false;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int maxlen = Integer.MIN_VALUE;
        int startingIndex = 0;
        dp=new Boolean[1001][1001];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (solve(s, i, j) && j - i + 1 > maxlen) {
                    startingIndex = i;
                    maxlen = j - i + 1;
                }
            }
        }
        return s.substring(startingIndex, startingIndex + maxlen);
    }
}

*/
//////////////////////////////////////////////////////////////////////////////////////////////


/*
class Solution {
    int l,r;
    int max_len = 1;int st = 0, end = 0;
    private void findPalin(String s, int l, int r, int n){
        while(l >= 0 && r < n){
                if(s.charAt(l) == s.charAt(r)){
                    l--; r++;
                }else
                    break;
            }
        int len = r-l-1;
        if(len > max_len){
            max_len = len;
            st = l+1;
            end = r-1;
        }
    }
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        int n = s.length();
        // Odd length
        for(int i = 0; i<n; ++i){
            l = i; r = i;
            findPalin( s,l,r,n);
        }
        // Even length
        for(int i = 0; i < n; ++i){
            l = i; r = i+1;
            findPalin( s,l,r,n);
        }
        return s.substring(st, end + 1);
    }
}

*/


/*
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int maxlen=0;
        int stind=-1, endind=-1;
        boolean dp[][]=new boolean[n][n];
        int k=0;
        while(k<n){
            int i=0, j=k;
            while(j<n){
                if(i==j){
                    dp[i][j]=true;
                }
                else if(j==1+i){
                    if(s.charAt(i)==s.charAt(j))
                        dp[i][j]=true;
                    else
                        dp[i][j]=false;
                }
                else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true)
                        dp[i][j]=true;
                    else
                        dp[i][j]=false;
                }
                if(dp[i][j]==true){
                    if(j-i+1>maxlen){
                        maxlen=j-i+1;
                        stind=i;
                        endind=j;
                    }
                }
                i++;
                j++;
            }
            k++;
        }
        return s.substring(stind, endind+1);

        // int n=s.length();
        // String s2="";
        // for(int i=n-1;i>=0;i--){
        //     s2+=s.charAt(i);
        // }
        // int dp[][]=new int [n+1][n+1];
        // int len=0;
        // int indi=-1, indj=-1;
        // for(int i=0;i<=n;i++){
        //     for(int j=0;j<=n;j++){
        //         if(i==0||j==0)
        //             dp[i][j]=0;
        //         else if(s.charAt(i-1)==s2.charAt(j-1))
        //             dp[i][j]=1+ dp[i-1][j-1];
        //         else
        //             dp[i][j]=0;
        //         if(dp[i][j]>len){
        //             len=dp[i][j];
        //             indi=i;
        //             indj=j;
        //         }
        //     }
        // }
        // String str="";
        // // if(len==1){
        // //     //return (String)(s.charAt(0));
        // //     str+=s.charAt(0);
        // //     return str;
        // // }
        // int i=indi,j=indj;
        // // while(i>=0 && j>=0){
        // //     if(dp[i][j]!=len){
        // //         i--;
        // //         j--;
        // //     }
        // //     else
        // //     break;
        // // }
        // // String str="";
        // while(i>=0 && j>=0 && dp[i][j]!=0){
        //     str+=s.charAt(i-1);
        //     i--;
        //     j--;
        // }
        // return str;
    }
}

*/