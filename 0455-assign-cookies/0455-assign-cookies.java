// class Solution {
//     public int findContentChildren(int[] g, int[] s) {
//         int nchild=g.length;
//         int ncookie=s.length;
//         Arrays.sort(g); Arrays.sort(s);
//         int cnt=0;
//         for(int i=0;i<nchild;i++){
//             for(int j=0;j<ncookie;j++){
//                 if(g[i]<=s[j]){
//                     cnt++;
//                     s[j]=0;
//                     break;
//                 }
//             }
//         }
//         return cnt;

//     }
// }

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int nchild=g.length;
        int ncookie=s.length;
        Arrays.sort(g); Arrays.sort(s);
        int cnt=0;
        int i=0,j=0;
        while(i<nchild && j<ncookie){
            if(g[i]<=s[j]){
                cnt++;
                i++;
                j++;
            }
            else if(g[i]>s[j]){
                j++;
            }
        }
        return cnt;

    }
}