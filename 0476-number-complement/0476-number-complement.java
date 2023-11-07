class Solution {
    public int findComplement(int n) {

        if(n==0) return 1;//base case
        int m=n, mask=0;
        while(m!=0){
            mask=(mask<<1)|1;
            m=m>>1;
        }
        return (~n)&mask;
        
    }
}