
class Solution {
    public List<List<String>> groupAnagrams(String[] ar) {
        int n=ar.length;
        Map<String, List<String>>map=new HashMap<>();
        for(int i=0;i<n;i++){
            String s=ar[i];
            char str[]=s.toCharArray();
            Arrays.sort(str);
            String sorted=new String(str);
            // Arrays.sort(s);//doesn't work'
            // String sorted=s;
            
            // map.putIfAbsent(sorted, new ArrayList<String>());
            map.putIfAbsent(sorted, new ArrayList());
            map.get(sorted).add(s);
        }
        List<List<String>>ans=new ArrayList<>();
        for(String key:map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
        
    }
}






















// class Pair{
//     String s; int idx;
//     Pair(ss,i){
//         s=ss;
//         idx=i;
//     }
// }
// class Solution {
//     public List<List<String>> groupAnagrams(String[] ar) {
//         int n=ar.length;
//         List<Pair>al=new ArrayList<>();
//         Map<String, Integer>map=new HashMap<>();
//         for(int i=0;i<n;i++){
//             al.add(new Pair(sr[i],i));
//             map.put()
//         }
//         for(int i=0;i<n;i++){
//             char str[]=al.get(i).s.toCharArray();
//             Arrays.sort(str);
//             String sorted=new String(str);
//             al.get(i).s=sorted;
//         }
//         Map<String, List<Integer>>map=new HashMap<>();
//         for(int i=0;i<n;i++){
//             map.putIfAbsent(al.get(i).s, new ArrayList<Integer>());
//             map.get(al.get(i).s).add(i);
//         }
//     }
// }