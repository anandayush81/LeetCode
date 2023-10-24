//Approach-2 (Using O(1) space)
//T.C : O(max(m, n))
//S.C : O(1)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;
        
        while (i >= 0 || j >= 0) {
            
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            
            char first = (i < 0) ? '$' : s.charAt(i);
            char second = (j < 0) ? '$' : t.charAt(j);
            
            if (first != second) {
                return false;
            }
            
            i--;
            j--;
        }
        
        return true;
    }
}




// class Solution {
//     public boolean backspaceCompare(String s, String t) {
//         StringBuilder s1=new StringBuilder();
//         // String s1="";
//         for(int i=0;i<s.length();i++){
//             char ch=s.charAt(i);
//             if(s1.length()==0 && ch=='#')
//             continue;
//             if(ch!='#') 
//             // s1+=ch;
//             s1.append(ch);
//             else
//             // s1=s1.substring(0, s1.length()-1);
//             s1=new StringBuilder(s1.substring(0, s1.length()-1));
//         }
//         StringBuilder s2=new StringBuilder();
//         // String s2="";
//         for(int i=0;i<t.length();i++){
//             char ch=t.charAt(i);
//             if(s2.length()==0 && ch=='#')
//             continue;
//             if(ch!='#') 
//             // s2+=ch;
//             s2.append(ch);
//             else
//             // s2=s2.substring(0, s2.length()-1);
//             s2=new StringBuilder(s2.substring(0, s2.length()-1));
//         }
//         return s1.toString().equals(s2.toString());
        
//     }
// }

// class Solution {
    
//     private String getString(String str) {
//         int n=str.length(), count=0;
//         String result="";
//         for(int i=n-1; i>=0; i--) {
//             char ch=str.charAt(i);
//             if(ch=='#') 
//                 count++;
//             else {
//                 if(count>0)
//                     count--;
//                 else {
//                     result+=ch;
//                 }                     
//             }
//         }
//         return result;
//     }
    
//     public boolean backspaceCompare(String S, String T) {
//         return getString(S).equals(getString(T));
//     }
// }