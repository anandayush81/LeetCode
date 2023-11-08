class Solution {
    public String reorganizeString(String S) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
         
            if (count > (S.length() + 1) / 2) 
                return "";
            
            map.put(c, count);
        }

        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (char c : map.keySet()) {
            pq.add(new int[] {map.get(c), c});
        }
        
        // Build the result.
        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            int[] first  = pq.poll();
            int[] second = pq.poll();
            
            sb.append((char) first[1]);
            sb.append((char) second[1]);
            
            first[0]--;
            second[0]--;
            
            if(first[0] > 0)
                pq.add(first);
            
            if(second[0] > 0)
                pq.add(second);

        }
        if(!pq.isEmpty()) {
            int[] first  = pq.poll();
            
            sb.append((char) first[1]);
        }
        
        return sb.toString();
    }
}























// class Pair{
//     char ch;int cnt;
//     public Pair(char ch, int cnt){
//         this.ch=ch; this.cnt=cnt;
//     }
// }
// class Solution {
//     public String reorganizeString(String s) {
//         int n=s.length();
//         List<Pair>al=new ArrayList<>();
        
//         // int ar[][]=new int[26][2];
//         int ar[]=new int[26];
//         for(int i=0;i<n;i++){
//             char ch=s.charAt(i);
//             // ar[ch-'a'][0]=ch-'a';
//             // ar[ch-'a'][1]+=1;
//             ar[ch-'a']++;
//         }
//         for(int i=0;i<26;i++){
//             if(ar[i]!=0)
//             al.add(new Pair((char)(i+97), ar[i]));
//         }
//         int maxval=Integer.MIN_VALUE;
//         char maxchar=' ';
//         for(int i=0;i<al.size();i++){
//             if(al.get(i).cnt>maxval){
//                 maxval=al.get(i).cnt;
//                 maxchar=al.get(i).ch;
//             }
//         }
//         // PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
//         //     return b.cnt-a.cnt;
//         // });
//         Collections.sort(al, (a,b)->( b.cnt-a.cnt));
//         Queue<Pair>pq=new LinkedList<>();
//         int sum=0;
//         for(int i=0;i<al.size();i++){
//             if(al.get(i).ch!=maxchar){
//                 sum+=al.get(i).cnt;
//             }
//             pq.add(al.get(i));
//         }
//         if(maxval-sum>1) return "";
        

//         // StringBuilder ans=new StringBuilder();
//         // while(true){
//         //     int flag=0;
//         //     for(int i=0;i<al.size();i++){
//         //         if(al.get(i).cnt!=0) flag=1;
//         //         ans.append(al.get(i).ch);
//         //         al.get(i).set(al);
//         //     }
//         //     if(flag==0) break;
//         // }
//         // return ans.toString();



//         StringBuilder ans=new StringBuilder();
//         for(int i=0;i<al.size();i++){
//             System.out.println(al.get(i).ch + "--"+al.get(i).cnt);
//         }
//         System.out.println("********");
//         while(!pq.isEmpty()){
//             Pair p=pq.poll();
//             System.out.println(p.ch);
//             ans.append(p.ch);
//             p.cnt--;
//             if(p.cnt!=0)
//             pq.add(p);
//         }
//         return ans.toString();
        
        
//     }
// }