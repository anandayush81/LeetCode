class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            int rem = ((num % value) + value) % value; 
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        int mex = 0;
        while(true){
            int rem = mex % value; 
            if(map.containsKey(rem)){
                map.put(rem, map.get(rem) - 1); 
                if(map.get(rem) == 0) map.remove(rem); 
                mex++; 
            }else{
                break; 
            }
        }

        return mex;
    }
}


// class Solution {
//     public int findMEX(int[] nums) {
//         int n=nums.length;
//         int i=0;
//         while(i<n){
//             if(nums[i]>=0 && nums[i]<n){
//                 int correctidx=nums[i];
//                 if(nums[i]!=nums[correctidx]){
//                     int temp=nums[i];
//                     nums[i]=nums[correctidx];
//                     nums[correctidx]=temp;
//                 }
//                 else{
//                     i++;
//                 }
//             }
//             else{
//                 i++;
//             }
//         }
//         for(int j=0;j<n;j++){
//             if(nums[j]!=j){
//                 return j;
//             }
//         }
//         return n;
//     }

//     public int findSmallestInteger(int[] nums, int value) {
//         int n=nums.length;
//         for(int i=0; i<n; i++){
//             // nums[i]=Math.abs(nums[i])%value;
//             nums[i]=(nums[i])%value;
//         }
//         return findMEX(nums);
//     }
// }