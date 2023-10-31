class Solution {
    private boolean solve(String s, int l, int r, int cnt){
        if(l>=r) return true;
        if( (s.charAt(l)!=s.charAt(r) ) && cnt<=0 ) return false;
        if(s.charAt(l)==s.charAt(r)) return solve(s,l+1,r-1,cnt);
        else if( solve(s,l,r-1,cnt-1) || solve(s,l+1,r,cnt-1) ) return true;
        return false;
    }
    public boolean validPalindrome(String s) {
        return solve(s,0,s.length()-1, 1);
        
    }
}