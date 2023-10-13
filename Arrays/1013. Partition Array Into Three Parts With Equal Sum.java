class Solution {
    public boolean canThreePartsEqualSum(int[] a) {
        int n=a.length; int sum=0;
        for(int x:a){
            sum+=x;
        } 
        if(sum%3!=0) return false; 
        int s=0, cnt=0; 
        int k=sum/3;
        for(int i=0;i<n;i++ ){
            s+=a[i];
            if(s==k){
                System.out.println("sum is "+s);
                cnt++;
                s=0;
            }
        }
        System.out.println("sum is "+s);
        //if(s!=0) return false; what if s : -2 -2 -2 -2 -2 4
        return cnt>=3?true:false;  
    }
}
