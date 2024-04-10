// class Solution {
//     private void solve(List<List<Integer>>ans, List<Integer>temp, int can[], int target, int sum, int idx, int n, int len){
//         // if(idx >= n){
//         //     if(sum==target && temp.size()==len){
//         //         ans.add(new ArrayList<>(temp));
//         //     }
//         //     return;
//         // }
//         // temp.add(can[idx]);
//         // sum+=can[idx];
//         // solve(ans, temp, can, target, sum, idx+1, n, len);
//         // temp.remove(temp.size()-1);
//         // sum-=can[idx];
//         // solve(ans, temp, can, target, sum, idx+1, n, len);

//         //For Loop
//         // if(temp.size()==len && sum>=target){
//         //     if(sum==target){
//         //         ans.add(new ArrayList<>(temp));
//         //     }
//         //     return;
//         // }
//         // for(int i=idx; i<n;i++){
//         //     temp.add(can[i]);
//         //     sum+=can[i];
//         //     solve(ans, temp, can, target, sum, i+1, n,len);
//         //     temp.remove(temp.size()-1);
//         //     sum-=can[i];
//         // }


//         //For Loop better way without sum
        
//         // if(target<=0 && temp.size()==len)
//         if(temp.size()==len && target<=0){
//             if(target==0){
//                 ans.add(new ArrayList<>(temp));
//             }
//             return;
//         }
//         for(int i=idx; i<n;i++){
//             temp.add(can[i]);
//             solve(ans, temp, can, target-can[i], sum, i+1, n,len);
//             temp.remove(temp.size()-1);
//         }
//     }
//     public List<List<Integer>> combinationSum3(int len, int target) {
//         List<List<Integer>>ans=new ArrayList<>();
//         int sum=0;
//         int idx=0;
//         int can[]=new int[9];
//         for(int i=1;i<=9;i++) can[i-1]=i;
//         List<Integer>temp=new ArrayList<>();
//         solve(ans, temp, can, target, sum, idx, 9, len);
//         return ans;
        
//     }
// }

class Solution {
    private void solve(List<List<Integer>>ans, List<Integer>temp, int target, int idx, int len){
        
        if(temp.size()==len && target<=0){
            if(target==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        for(int i=idx; i<=9;i++){
            temp.add(i);
            solve(ans, temp, target-i, i+1, len);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int len, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        solve(ans, temp, target, 1, len);
        return ans;
        
    }
}