class Solution {
    public int totalMoney(int n) {
        int weeks=n/7;
        int d=n%7;
        int sum=0;
        if(weeks>=1){
            sum+=(28*weeks);
            int k=weeks-1;
            // ((weeks-1)*7));
            sum+=7*(k*(k+1)/2);

        } 
        for (int i=0;i<d;i++){
            sum+=(i+(weeks+1));
        }
        return sum;
        
    }
}