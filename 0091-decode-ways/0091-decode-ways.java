// class Solution {
//     //This is similar to Palindrome partitioning problem, and here the #cuts is not defined.
//     int dp[];//dp[i]=#ways to decode starting from i
//     private int solve(String s, int idx, int n){
//         if(idx>=n) return 1;
//         if(dp[idx]!=-1) return dp[idx];
//         int cnt=0;
//         for(int i=idx;i<n;i++){
//             String str=s.substring(idx,i+1);
//             // int val=Integer.parseInt(str);
//             // if((str.length()==1 && str.charAt(0)!='0') || (str.length()==2 && str.charAt(0)!='0' && val>=1 && val<=26)){
//             //     cnt+=solve(s,i+1,n);
//             // }
//             if( (str.length()==1 && str.charAt(0)!='0')){
//                 cnt+=solve(s,i+1,n);
//             }
//             else if(str.length()==2 && str.charAt(0)!='0'){
//                 int val=Integer.parseInt(str);
//                 // int val=Integer.valueOf(str);
//                 if(val>=1 && val<=26){
//                     cnt+=solve(s,i+1,n);
//                 }
//             }
//             //note how we're not doing any backtrackig step here like temp.remove(size-1);
//             //this is bcoz temp.remove() is not needed, and the "not take" / "don't pick" part happens by default in the for loop
//         }
//         return dp[idx]=cnt;
//     }
//     public int numDecodings(String s) {
//         dp=new int[105];
//         Arrays.fill(dp,-1);
//         return solve(s,0,s.length());
        
//     }
// }

class Solution {
    //This is similar to Palindrome partitioning problem, and here the #cuts is not defined.
    int dp[];//dp[i]=#ways to decode starting from i
    private int solve(StringBuilder s, int idx, int n){
        if(idx>=n) return 1;
        if(dp[idx]!=-1) return dp[idx];
        int cnt=0;
        for(int i=idx;i<n;i++){
            StringBuilder str=new StringBuilder(s.substring(idx,i+1));
            if( (str.length()==1 && str.charAt(0)!='0')){
                cnt+=solve(s,i+1,n);
            }
            else if(str.length()==2 && str.charAt(0)!='0'){
                int val=Integer.parseInt(str.toString());
                // int val=Integer.valueOf(str);
                if(val>=1 && val<=26){
                    cnt+=solve(s,i+1,n);
                }
            }
            //note how we're not doing any backtrackig step here like temp.remove(size-1);
            //this is bcoz temp.remove() is not needed, and the "not take" / "don't pick" part happens by default in the for loop
        }
        return dp[idx]=cnt;
    }
    public int numDecodings(String s) {
        dp=new int[105];
        Arrays.fill(dp,-1);
        StringBuilder st=new StringBuilder(s);
        return solve(st,0,s.length());
        
    }
}