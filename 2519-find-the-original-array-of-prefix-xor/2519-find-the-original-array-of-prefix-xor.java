// class Solution {
//     public int[] findArray(int[] pref) {
//         int n=pref.length;
//         int ans[]=new int [n];
//         ans[0]=pref[0];
//         for(int i=1;i<n;i++){
//             ans[i]=ans[i-1]^pref[i];
//         }
//         return ans;
        
//     }
// }


class Solution{
    public int[] findArray(int[] pref) {
        int ans[] = new int[pref.length];
        ans[0] = pref[0];
        for(int i = 1; i < pref.length; ++i)
            ans[i] = pref[i - 1] ^ pref[i];
        return ans;
    }
}