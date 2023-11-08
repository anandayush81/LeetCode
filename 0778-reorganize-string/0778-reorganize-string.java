public class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        StringBuilder res = new StringBuilder();
        while (maxHeap.size() >= 2) {
            char char1 = maxHeap.poll();
            char char2 = maxHeap.poll();

            res.append(char1);
            res.append(char2);

            freqMap.put(char1, freqMap.get(char1) - 1);
            freqMap.put(char2, freqMap.get(char2) - 1);

            if (freqMap.get(char1) > 0) maxHeap.add(char1);
            if (freqMap.get(char2) > 0) maxHeap.add(char2);
        }

        if (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            if (freqMap.get(ch) > 1) return "";
            res.append(ch);
        }

        return res.toString();
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