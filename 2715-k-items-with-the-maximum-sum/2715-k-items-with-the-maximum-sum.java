class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        
        int ans=0;
        if(numOnes>k) return k;
        else if((numOnes+numZeros)>k) return numOnes;
        else{
            ans=numOnes-(k-(numOnes+numZeros));
        }
        return ans;
        
    }
}