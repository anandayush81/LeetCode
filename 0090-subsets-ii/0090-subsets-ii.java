class Solution {
    private void generate(List<List<Integer>> ans, List<Integer>temp, int nums[], int idx, int n){
        
        ///Using Pick Don't pick
        // if(idx>=n){
        //     ans.add(new ArrayList<>(temp));
        //     return;
        // }
        // temp.add(nums[idx]);
        // generate(ans, temp, nums, idx+1, n);
        // temp.remove(temp.size()-1);
        // while(idx+1<n && nums[idx]==nums[idx+1]){
        //     idx++;
        // }
        // generate(ans, temp, nums, idx+1, n);

        //Using For Loop
        ans.add(new ArrayList<>(temp));
        for (int i = idx; i < nums.length; i++) {
            temp.add(nums[i]);
            generate(ans, temp, nums, i+1, n);
            temp.remove(temp.size()-1);
            while(i+1<n && nums[i]==nums[i+1]){
                i++;
            }
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        int idx=0;
        List<Integer>temp=new ArrayList<>();
        generate(ans, temp, nums, idx, n);
        return ans;
    }
}