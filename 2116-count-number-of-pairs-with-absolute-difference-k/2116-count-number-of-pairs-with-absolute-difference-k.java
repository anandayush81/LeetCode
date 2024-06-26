class Solution {
    public int countKDifference(int[] nums, int k) {
        int n=nums.length;
        Map<Integer, Integer>map=new HashMap<>();
        int c=0;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i]+k))
            c+=map.get(nums[i]+k);
            if(map.containsKey(nums[i]-k))
            c+=map.get(nums[i]-k);

            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        return c;

    }
}