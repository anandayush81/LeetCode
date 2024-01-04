// class Solution {
//     public int minOperations(int[] nums) {
//         Map<Integer, Integer>map=new HashMap<>();
//         int n=nums.length;
//         for(int x:nums){
//             map.put(x, map.getOrDefault(x,0)+1);
//         }
//         int cnt=0;
//         for(int key:map.keySet()){
//             int v=map.get(key);
//             if(v%6==0) cnt+=(v/3);
//             else if(v%3==0) cnt+=(v/3);
//             else if(v>3 && (v%3==2 || v%3==1)) cnt+=(v/3)+1;
//             else if (v%2==0) cnt+=(v/2);
//             else return -1;    
//         }
//         return cnt;
        
//     }
// }


import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int t = entry.getValue();
            if (t == 1)
                return -1;
            
            count += t / 3; 
            if (t % 3 != 0) 
                count++;
        }
        return count;
    }
}

