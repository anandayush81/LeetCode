class Solution {
    private boolean isBalanced(int n){
        int hash[]=new int[10]; int digitcnt=0;
        while(n>0){
            int d=n%10;
            hash[d]+=1;
            n=n/10;
            digitcnt+=1;
        }
        int s=0;
        // for(int i=1;i<10;i++){
        //     s+=hash[i];
        // }
        // if(s!=digitcnt) return false;
        for(int i=0;i<10;i++){
            if(hash[i]!=0 && hash[i]!=i) return false;
        }
        return true;
    }
    public int nextBeautifulNumber(int n) {
        int last=1224444;
        for(int i=n+1;i<=last;i++){
            if (isBalanced(i))  return i;
        }
        return -1;
        
    }
}