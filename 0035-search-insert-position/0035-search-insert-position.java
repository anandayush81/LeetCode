class Solution {
    public int binsearch(int nums[], int l, int r, int target){
        int ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target){
                
                r=mid-1;
            }
            else{
                ans=mid;
                l=mid+1;
            }
        }
        return ans;
    }
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int idx=binsearch(nums, 0, n-1, target);
        if(idx>=0 && idx<n && nums[idx]==target) return idx;
        return idx+1;
        
    }
}