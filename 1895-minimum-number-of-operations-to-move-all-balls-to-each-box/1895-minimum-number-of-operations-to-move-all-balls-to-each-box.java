class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int ans[]=new int [n];
        char charr[]=boxes.toCharArray();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(charr[j]!='0'){
                    ans[i]+=Math.abs(j-i);
                }
            }
        }
        return ans;
        
    }
}