// class Solution {
//     private boolean ispalin(String str){
//         int n=str.length();
//         int l=0, r=n-1;
//         while(l<r){
//             if(str.charAt(l)!=str.charAt(r)){
//                 return false;
//             }
//             l++;
//             r--;
//         }
//         return true;
//     }
//     public boolean isPalindrome(String s) {
//         String str="";
//         int n=s.length();
//         for(int i=0;i<n;i++){
//             char ch=s.charAt(i);
//             if((ch>='A'&& ch<='Z')||(ch>='a' && ch<='z')||(ch>='0' && ch<='9')){
//                 if(ch>='A'&& ch<='Z'){
//                     ch=(char)((int)ch+32);
//                 }
//                 str+=ch;
//             }
//         }
//         return ispalin(str);
//     }
// }


//Constant space
class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
        	char currFirst = s.charAt(start);
        	char currLast = s.charAt(last);
        	if (!Character.isLetterOrDigit(currFirst )) {
        		start++;
        	} else if(!Character.isLetterOrDigit(currLast)) {
        		last--;
        	} else {
        		if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
        			return false;
        		}
        		start++;
        		last--;
        	}
        }
        return true;
    }
}