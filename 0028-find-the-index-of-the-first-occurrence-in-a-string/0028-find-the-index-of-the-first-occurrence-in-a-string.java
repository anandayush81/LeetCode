// class Solution {
//     public int strStr(String haystack, String needle) {
//         //return haystack.indexOf(needle);
//     }
// }

class Solution {
    public int strStr(String s2, String s1) {
        int n1=s1.length(), n2=s2.length();
        for(int i=0;i<n2;i++){
            if(s2.charAt(i)==s1.charAt(0)){
                int k=0;
                while(i+k<n2 && k < n1){
                    if(s2.charAt(i+k)!=s1.charAt(k)){
                        break;
                    }
                    k++;
                }
                if(k==n1) return i;
            }
        }
        return -1;
        
    }
}