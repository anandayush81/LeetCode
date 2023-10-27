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