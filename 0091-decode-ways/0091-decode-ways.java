class Solution {
    int dp[];
    private int solve(String s, int idx, int n){
        if(idx>=n) return 1;
        if(dp[idx]!=-1) return dp[idx];
        int cnt=0;
        for(int i=idx;i<n;i++){
            String str=s.substring(idx,i+1);
            // int val=Integer.parseInt(str);
            // if((str.length()==1 && str.charAt(0)!='0') || (str.length()==2 && str.charAt(0)!='0' && val>=1 && val<=26)){
            //     cnt+=solve(s,i+1,n);
            // }
            if( (str.length()==1 && str.charAt(0)!='0')){
                cnt+=solve(s,i+1,n);
            }
            else if(str.length()==2 && str.charAt(0)!='0'){
                int val=Integer.parseInt(str);
                if(val>=1 && val<=26){
                    cnt+=solve(s,i+1,n);
                }
            }


        }
        return dp[idx]=cnt;
    }
    public int numDecodings(String s) {
        dp=new int[105];
        Arrays.fill(dp,-1);
        return solve(s,0,s.length());
        
    }
}