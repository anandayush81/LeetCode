// class Solution {
//     public String digitSum(String s, int k) {
//         int n=s.length(); String str=s;
//         while(str.length()>k){
//             char ar[]=str.toCharArray();
//             String temp="";
//             int i=0;
//             while(i<ar.length){
//                 int sum=0;
//                 for(int j=i;j<(i+k) && j<ar.length;j++){
//                     sum+=(ar[j]-'0');
//                 }
//                 // System.out.println("sum="+sum);
//                 temp+=""+sum;
//                 i+=k;
//             }
//             // System.out.println("str="+str);
//             str=temp;
//         }
//         return str;
        
//     }
// }

class Solution {
    private String modify(String s2){
        int l=s2.length();
        int sum=0;
        for (int i=0;i<l;i++){
            sum=sum + (s2.charAt(i)-'0');
        }
        return ""+sum;
        
    } 
    public String digitSum(String s, int k) {
        int n=s.length();
        String str=s;
        while(str.length()>k){
            int len=str.length();
            String currtemp="";
            int i=0;
            while(i<len){
                String s1="";
                if(i+k<=len){
                    s1=str.substring(i,i+k);
                    i+=k;

                }
                else{
                    s1=str.substring(i,len);
                    i+=k;

                }
                
                currtemp+=modify(s1);
                // System.out.println("currtemp="+currtemp);

            }
            str=currtemp;
            // System.out.println("str="+str);
        }
        return str;
        
    }
}