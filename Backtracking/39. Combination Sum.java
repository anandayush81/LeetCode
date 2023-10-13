class Solution {
    private void solve(List<List<Integer>>ans, List<Integer>temp, int can[], int target, int sum, int idx, int n){
        //Using Pick Don't Pick
        // if(idx >= n || sum>=target){
        //     if(sum==target){
        //         ans.add(new ArrayList<>(temp));
        //     }
        //     return;
        // }
        // temp.add(can[idx]);
        // sum+=can[idx];
        // solve(ans, temp, can, target, sum, idx, n);
        // temp.remove(temp.size()-1);
        // sum-=can[idx];
        // //No need of this step since integers are distinct
        // // while(idx+1<n && can[idx]==can[idx+1])
        // //     idx++;
        // solve(ans, temp, can, target, sum, idx+1, n);


        //Using For Loop
        // if(sum>=target){
        //     if(sum==target){
        //         ans.add(new ArrayList<>(temp));
        //     }
        //     return;
        // }
        // for(int i=idx; i<n;i++){
        //     temp.add(can[i]);
        //     sum+=can[i];
        //     solve(ans, temp, can, target, sum, i, n);
        //     temp.remove(temp.size()-1);
        //     sum-=can[i];
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
            solve(ans, temp, can, target-can[i], sum, i, n);
            temp.remove(temp.size()-1);
            
        }
    }
    public List<List<Integer>> combinationSum(int[] can, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        // Arrays.sort(can);
        int n=can.length;
        int sum=0;
        int idx=0;
        List<Integer>temp=new ArrayList<>();
        solve(ans, temp, can, target, sum, idx, n);
        return ans;


        
    }
}