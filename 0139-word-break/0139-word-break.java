//This is not backtracking question
//This question doesn't actually need to consider all possible partitions
// 
class Solution {
    Set<String>set;
    Boolean dp[];
    private boolean check(String s, int idx, int n){
        if(idx==n){
            return true;
        }
        if(dp[idx]!=null)
        return dp[idx];
        String temp="";
        for(int i=idx;i<n;i++){
            temp=temp+s.charAt(i);
            if(set.contains(temp) && check(s, i+1, n)){
                return dp[idx]=true;
            }
        }
        return dp[idx]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        set=new HashSet<>();
        for(String str:wordDict){
            set.add(str);
        }
        int n=s.length();
        dp=new Boolean[n]; // dp[i]=if string from index ito n is present in the dictionary
        List<String>temp=new ArrayList<>();
        return check(s, 0, s.length());
        
    }
}