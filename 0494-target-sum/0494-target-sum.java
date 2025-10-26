//BF
// class Solution {
//     private int solve(int nums[], int n, int idx, int sum, int target){
//         if(idx == n){
//             if(sum == target) return 1;
//             return 0;
//         }
//         int add=solve(nums,n, idx+1, sum+nums[idx], target);
//         int sub=solve(nums,n, idx+1, sum-nums[idx], target);
//         return add+sub;
        
//     }
//     public int findTargetSumWays(int[] nums, int target) {
//         Map<String, Integer> mp=new HashMap<>();
//         return solve(nums, nums.length, 0, 0, target);
       
        
//     }
// }


//Memoizatiom
class Solution {
    private int solve(int nums[], int n, int idx, int sum, int target, Map<String, Integer> mp){
        if(idx == n){
            if(sum == target) return 1;
            return 0;
        }
        String key=""+(""+idx)+"_"+(sum+"");
        if(mp.containsKey(key)) return mp.get(key);

        int add=solve(nums,n, idx+1, sum+nums[idx], target, mp);
        int sub=solve(nums,n, idx+1, sum-nums[idx], target, mp);

        // String key=""+(""+idx)+"_"+(sum+"");
        mp.put(key, (sub+add));
        return add+sub;
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> mp=new HashMap<>();
        return solve(nums, nums.length, 0, 0, target, mp);
       
        
    }
}


















// class Solution {
//     int cnt=0;
//     private void solve(int nums[], int target, List<Integer>temp, int idx, int n){
//         if(temp.size()==n){
//             System.out.println(temp);
//             int s=0;
//             for(int i=0;i<n;i++){
//                 s+=temp.get(i);
//             }
//             if(s==target) cnt+=1;
//             return;
//         }
//         if(idx>=n) return;
//         for(int i=idx;i<n;i++){
//             temp.add(nums[i]);
//             solve(nums, target, temp,i+1, n);
//             temp.remove(temp.size()-1);
//             temp.add((-1)*nums[i]);
//             solve(nums, target, temp,i+1, n);
//             temp.remove(temp.size()-1);
//         }
//     }
//     public int findTargetSumWays(int[] nums, int target) {
//         List<Integer>temp=new ArrayList<>();
//         solve(nums, target, temp, 0, nums.length);
//         return cnt;
        
//     }
// }


