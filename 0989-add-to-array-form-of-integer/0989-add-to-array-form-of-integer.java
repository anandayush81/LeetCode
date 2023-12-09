class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n=num.length;
        int i=n-1, carry=0;
        List<Integer>ans=new ArrayList<>();
        while(i>=0 || k!=0 || carry!=0){
            int v1=0, v2=0;
            if(i>=0) v1=num[i];
            if(k!=0){
                v2=k%10;
                k=k/10;
            }
            int sum=v1+v2+carry;
            int digit=sum%10;
            carry=sum/10;
            ans.add(digit);
            i--;
        }
        Collections.reverse(ans);
        return ans;
    }
}