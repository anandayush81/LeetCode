class Solution {
    public String addStrings(String s1, String s2) {
        int n1=s1.length(), n2=s2.length();
        StringBuilder ans=new StringBuilder();
        int i=n1-1, j=n2-1;
        int carry=0;
        while(i>=0 && j>=0){
            int v1=s1.charAt(i)-'0';
            int v2=s2.charAt(j)-'0';
            int sum=carry+v1+v2;
            int val=sum%10;
            carry=sum/10;
            ans.append(val);
            i--;j--;
        }
        while(i>=0){

            int sum=carry+s1.charAt(i)-'0';
            int val=sum%10;
            carry=sum/10;
            ans.append(val);         
            i--;
            if(carry==0){
                ans.append(new StringBuilder(s1.substring(0,i+1)).reverse());
                break;
            }
        }
        while(j>=0){

            int sum=carry+s2.charAt(j)-'0';
            int val=sum%10;
            carry=sum/10;
            ans.append(val);
            j--;
            if(carry==0){
                ans.append(new StringBuilder(s2.substring(0,j+1)).reverse());
                break;
            }
        }
        if(carry!=0)
        ans.append(carry);
        return ans.reverse().toString();

        
    }
}