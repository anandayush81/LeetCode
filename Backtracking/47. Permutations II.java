class Solution {
    private void swap(int nums[], int l, int r){
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }
    private void permute(List<List<Integer>> ans, int nums[], int idx, int n){
        if(idx>=n){
            List<Integer>temp=new ArrayList<>();
            for(int x:nums) temp.add(x);
            ans.add(temp);
            return;

        }
        Set<Integer>set=new HashSet<>();
        for(int i=idx;i<n;i++){
            if(set.contains(nums[i]))
            continue;
            else
            set.add(nums[i]);
            swap(nums, i, idx);
            permute(ans, nums, idx+1, n);

            // while(i+1<n && nums[i]==nums[i+1]) i++;

            swap(nums, i, idx);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        // Arrays.sort(nums);
        permute(ans, nums, 0, nums.length);
        return ans;
    }
}