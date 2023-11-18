// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         // String ar[]=s.split(" ");
//         // int n=ar.length;
//         int ns=s.length(), nt=t.length();
//         if(ns!=nt) return false;
//         if(ns==1) return true;

//         Map<Character, Character>smap=new HashMap<>();
//         Map<Character, Character>tmap=new HashMap<>();
//         // int k=0;
//         char k='a';
//         for(int i=0;i<ns;i++){
//             // if(!map.containsKey(ar[i]))
//             smap.putIfAbsent(s.charAt(i),k);
//             tmap.putIfAbsent(t.charAt(i),k);
//             k++;
//             // if(smap.size()>26 || tmap.size()>26) return false;
//         }
//         StringBuilder sb1=new StringBuilder();
//         StringBuilder sb2=new StringBuilder();
//         for(int i=0;i<ns;i++){
//             sb1.append(smap.get(s.charAt(i)));
//             sb2.append(tmap.get(t.charAt(i)) );
//         }
//         if(sb2.toString().equals(sb1.toString())) return true;
//         return false;
//     }
// }


//comment
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int map1[]=new int[200];
        int map2[]=new int[200];
        if(s.length()!=t.length())
            return false;
        for(int i=0;i<s.length();i++)
        {
            if(map1[s.charAt(i)]!=map2[t.charAt(i)])
                return false;
            map1[s.charAt(i)]=i+1;
            map2[t.charAt(i)]=i+1;
        }
        return true;
    }
}




// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         int ns=s.length(), nt=t.length();
//         if(ns!=nt) return false;
//         Map<Character, Character>maps=new HashMap<>();
//         Map<Character, Character>mapt=new HashMap<>();
//         for(int i=0;i<ns;i++){
            
//             char cs=s.charAt(i), ct=t.charAt(i);
            
//             if( (maps.containsKey(cs) && maps.get(cs)!=ct) || (mapt.containsKey(ct) && mapt.get(ct)!=cs) ) 
//             return false;

//             // maps.putIfAbsent(cs,ct);
//             // mapt.putIfAbsent(ct,cs);

//             maps.put(cs,ct);
//             mapt.put(ct,cs);
//         }
//         return true;
//     }
// }