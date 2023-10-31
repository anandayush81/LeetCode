// class Solution {
//     public String addStrings(String s1, String s2) {
//         int n1=s1.length(), n2=s2.length();
//         StringBuilder ans=new StringBuilder();
//         int i=n1-1, j=n2-1;
//         int carry=0;
//         while(i>=0 && j>=0){
//             int v1=s1.charAt(i)-'0';
//             int v2=s2.charAt(j)-'0';
//             int sum=carry+v1+v2;
//             int val=sum%10;
//             carry=sum/10;
//             ans.append(val);
//             i--;j--;
//         }
//         while(i>=0){

//             int sum=carry+s1.charAt(i)-'0';
//             int val=sum%10;
//             carry=sum/10;
//             ans.append(val);         
//             i--;
//             //optimisation, but doesn't help since substring also takes O(n) time
//             if(carry==0){
//                 ans.append(new StringBuilder(s1.substring(0,i+1)).reverse());
//                 break;
//             }
//         }
//         while(j>=0){

//             int sum=carry+s2.charAt(j)-'0';
//             int val=sum%10;
//             carry=sum/10;
//             ans.append(val);
//             j--;
//             //optimisation
//             if(carry==0){
//                 ans.append(new StringBuilder(s2.substring(0,j+1)).reverse());
//                 break;
//             }
//         }
//         if(carry!=0)
//         ans.append(carry);
//         return ans.reverse().toString();

        
//     }
// }

public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}