class Solution {
    private boolean isVowel(char ch){
        if(ch=='a' || ch=='e'|| ch=='i' || ch=='o' || ch=='u') return true; return false;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=words.length;
        int pf[]=new int[n];
        for(int i=0;i<n;i++)
        {
            String str=words[i];
            if(isVowel(str.charAt(0)) && isVowel(str.charAt(str.length()-1)) )
            pf[i]=1;
        }
        for(int i=1;i<n;i++){
            pf[i]=pf[i]+pf[i-1];
        }

        int qn=queries.length;
        int ans[]=new int [qn];
        for(int i=0;i<qn;i++){
            int p=queries[i][0]; int q=queries[i][1];
            if(p==0) ans[i]=pf[q];
            else ans[i]=pf[q]-pf[p-1];

        }
        return ans;
        
    }
}
