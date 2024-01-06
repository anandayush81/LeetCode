class Solution {
    public int longestSubstring(String str, int k) {
        int n=str.length();
        return solve(str.toCharArray(), 0, n-1, k);   
    }
    private int solve(char ar[], int start, int end, int k){

        Map<Character, Integer>map=new HashMap<>();
        if(end-start+1<k) return 0;

        for(int i=start;i<=end; i++){
            map.put(ar[i], map.getOrDefault(ar[i],0)+1);
        }
        for(int i=start;i<=end; i++){
            if(map.get(ar[i]) <k ){
                int j=i+1;
                while(j<=end && map.get(ar[j])<k){
                    j++;
                }
                return Math.max( solve(ar,start,i-1,k), solve(ar,j,end,k));
            }
        }
        return end-start+1;
    }
}

// class Solution {
//     public int longestSubstring(String str, int k) {
//         int n=str.length();
//         return solve(str.toCharArray(), 0, n, k);   
//     }
//     private int solve(char ar[], int start, int end, int k){
//         Map<Character, Integer>map=new HashMap<>();
//         if(end-start<k) return 0;
//         for(int i=start;i<end; i++){
//             map.put(ar[i], map.getOrDefault(ar[i],0)+1);
//         }
//         for(int i=start;i<end; i++){
//             if(map.get(ar[i]) <k ){
//                 int j=i+1;
//                 while(j<end && map.get(ar[j])<k){
//                     j++;
//                 }
//                 return Math.max( solve(ar,start,i,k), solve(ar,j,end,k));
//             }
//         }
//         return end-start;
//     }
// }























// class Solution {
//     public boolean check(Map<Character, Integer>map, int k){
//         for(char key:map.keySet()){
//             if(map.get(key)<k)
//             return false;
//         }
//         return true;
//     }
//     public int longestSubstring(String str, int k) {
//         Map<Character, Integer>map=new HashMap<>();
        
//         int n=str.length();
//         int maxlen=0;

//         Map<Character, Integer>countmap=new HashMap<>();

//         for(char ch:str.toCharArray()){
//             countmap.put(ch, countmap.getOrDefault(ch,0)+1);
//         }
//         Set<Character>set=new HashSet<>();
//         for(char key:countmap.keySet()){
//             if(countmap.get(key)<k){
//                 set.add(key);
//             }
//         }
//         System.out.println(countmap.toString());
//         System.out.println(set.toString());
//         int s=0,e=0;
//         while(e<n){
//             char ch=str.charAt(e);
//             if(set.contains(ch)){
//                 s=e+1;
//                 e++;
//                 map.clear();
//                 continue;
//             }
//             map.put(ch, map.getOrDefault(ch,0)+1);
//             System.out.println("map is "+map.toString());
//             if(check(map,k)){
//                 maxlen=Math.max(maxlen, e-s+1);
//                 System.out.println("maxlen is "+maxlen);
//             }
//             e++;
//             System.out.println("e is "+e);
//         }
//         System.out.println(" while loop over ");
//         return maxlen;
//     }
// }

































// class Solution {
//     public boolean check(Map<Character, Integer>map, int k){
//         for(char key:map.keySet()){
//             if(map.get(key)<k)
//             return false;
//         }
//         return true;
//     }
//     public int longestSubstring(String s, int k) {
//         Map<Character, Integer>map=new HashMap<>();
//         int i=0,j=0;
//         int n=s.length();
//         int maxlen=-1;
//         while(j<n){
//             char ch=s.charAt(j);
//             map.put(ch, map.getOrDefault(ch,0)+1);
//             if(!check(map,k))
//                 j++;
//             else{
//                 maxlen=Math.max(maxlen, j-i+1);
                
//             }
//             // else if(map.size()==k){
//             //     maxlen=Math.max(maxlen, j-i+1);
//             //     j++;
//             // }
//             // else if(map.size()k){
//             //     while(map.size()>k ){
//             //         map.put(s.charAt(i), map.get(s.charAt(i))-1);
//             //         if(map.get(s.charAt(i))==0)
//             //             map.remove(s.charAt(i));
//             //         i++;
//             //     }
//             //     j++;   
//             // }
            
//         }
//         return maxlen;
//     }
// }