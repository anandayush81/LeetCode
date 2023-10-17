class Solution {
    public static void swap(int[] arr, int si, int ei){
        int t = arr[si];
        arr[si] = arr[ei];
        arr[ei] = t;
    }
    public static void generate(int[] arr, int n, int ind, List<List<Integer>> ans){
        if(ind == n){
            List<Integer> temp = new ArrayList<>();
            for(int it : arr){
                temp.add(it);
            }
            ans.add(temp);
            return;
        }
        for(int i=ind; i<n;i++){
            swap(arr, i, ind);
            generate(arr, n, ind+1, ans);
            swap(arr, i, ind);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // Arrays.sort(nums);
        generate(nums, nums.length, 0, ans);
        return ans;
    }
}