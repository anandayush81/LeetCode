class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int v1=nums[0]*nums[1]*nums[n-1];
        int v2=nums[n-1]*nums[n-2]*nums[n-3];
        return (v1>v2)?v1:v2;
    }
}