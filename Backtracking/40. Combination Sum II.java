class Solution {
    private void solve(List<List<Integer>>ans, List<Integer>temp, int can[], int target, int sum, int idx, int n){
        // if(idx >= n || sum>=target){
        //     if(sum==target){
        //         ans.add(new ArrayList<>(temp));
        //     }
        //     return;
        // }
        // temp.add(can[idx]);
        // sum+=can[idx];
        // solve(ans, temp, can, target, sum, idx+1, n);
        // temp.remove(temp.size()-1);
        // sum-=can[idx];
        // while(idx+1<n && can[idx]==can[idx+1])
        //     idx++;
        // solve(ans, temp, can, target, sum, idx+1, n);

        //For Loop
        // if(sum>=target){
        //     if(sum==target){
        //         ans.add(new ArrayList<>(temp));
        //     }
        //     return;
        // }
        // for(int i=idx; i<n;i++){
        //     temp.add(can[i]);
        //     sum+=can[i];
        //     solve(ans, temp, can, target, sum, i+1, n);
        //     temp.remove(temp.size()-1);
        //     sum-=can[i];

        //     while(i+1<n && can[i]==can[i+1])
        //     i++;
        // }

        //Better way Using For Loop (No need to use sum variable)
        if(target<=0){
            if(target==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i=idx; i<n;i++){
            temp.add(can[i]);
            solve(ans, temp, can, target-can[i], sum, i+1, n);
            temp.remove(temp.size()-1);
            while(i+1<n && can[i]==can[i+1])
            i++;
        }
    }
    public List<List<Integer>> combinationSum2(int[] can, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(can);
        int n=can.length;
        int sum=0;
        int idx=0;
        List<Integer>temp=new ArrayList<>();
        solve(ans, temp, can, target, sum, idx, n);
        return ans;
    }
}














/*
class Solution {
public:
    void findAns(int index, int target, vector<int>& arr, vector<vector<int>>& ans, vector<int>& helper) {
        if(target == 0) {
            ans.push_back(helper);
            return;
        }
        for(int i = index; i < arr.size(); i++) {
            if(i > index && arr[i] ==arr[i-1]) continue;
            if(arr[i] > target) break;
            helper.push_back(arr[i]);
            findAns(i+1, target-arr[i], arr, ans, helper);
            helper.pop_back();
        }
    }
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<vector<int>> ans;
        vector<int> helper;
        findAns(0, target, candidates, ans, helper);
        return ans;
    }
};
*/