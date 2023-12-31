class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n=nums.length;
        int i=0;
        while(i<n){
            if(nums[i]>=1 && nums[i]<=n){
                int correctidx=nums[i]-1;
                if(nums[i]!=nums[correctidx]){
                    int temp=nums[i];
                    nums[i]=nums[correctidx];
                    nums[correctidx]=temp;
                }
                else{
                    i++;
                }
            }
            else{
                i++;
            }
        }
        List<Integer>ans=new ArrayList<>();
        for(int j=0;j<n;j++){
            if(nums[j]!=j+1){
                ans.add(nums[j]);
            }
        }
        return ans;
    }
}