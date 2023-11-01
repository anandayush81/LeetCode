// class Solution {
//     public int strStr(String haystack, String needle) {
//         //return haystack.indexOf(needle);
//     }
// }

// class Solution {
//     public int strStr(String s2, String s1) {
//         int n1=s1.length(), n2=s2.length();
//         for(int i=0;i<n2;i++){
//             if(s2.charAt(i)==s1.charAt(0)){
//                 int k=0;
//                 while(i+k<n2 && k < n1){
//                     if(s2.charAt(i+k)!=s1.charAt(k)){
//                         break;
//                     }
//                     k++;
//                 }
//                 if(k==n1) return i;
//             }
//         }
//         return -1;
        
//     }
// }

class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        int nIndex = 0;
        for(int i=0; i<hLen; i++){
            // as long as the characters are equal, increment needleIndex
            if(haystack.charAt(i)==needle.charAt(nIndex)){
                nIndex++;
            }
            else{
                // start from the next index of previous start index
                i=i-nIndex;
                // needle should start from index 0
                nIndex=0;
            }
            // check if needleIndex reached needle length
            if(nIndex==nLen){
                // return the first index
                return i-nLen+1;
            }
        }
        return -1;
    }
}