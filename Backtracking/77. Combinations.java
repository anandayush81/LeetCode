class Solution {
    private void generate(List<List<Integer>> ans, List<Integer> temp, int ar[], int idx, int k, int n){

        // if(temp.size()==k){
        //     ans.add(new ArrayList<>(temp));
        //     return;
        // }
        // for(int i=idx;i<n;i++){
        //     temp.add(ar[i]);
        //     generate(ans, temp, ar, i+1, k, n);
        //     temp.remove(temp.size()-1);
        // }
        
        if(idx>=n){
            if(temp.size()==k)
                ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(ar[idx]);
        generate(ans, temp, ar, idx+1, k, n);
        temp.remove(temp.size()-1);
        generate(ans, temp, ar, idx+1, k, n);
    }


    // private void generate2(List<List<Integer>> ans, Integer temp[], int ar[], int idx, int k, int n){
    //     if(idx>=k){
    //         List<Integer>a=new ArrayList<>(Arrays.asList(temp));
    //         ans.add(a);
    //         return;
    //     }
    //     for(int i=idx;i<n;i++){
    //         temp[idx]=ar[i];
    //         generate2(ans, temp, ar, idx+1, k, n);
    //     }
    // }


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        int ar[]=new int[n];
        for(int i=1;i<=n;i++){
            ar[i-1]=i;
        }
        List<Integer> temp=new ArrayList<>();
        generate(ans, temp, ar, 0, k, n);
        return ans;

        // int temp[]=new int [k];
        // Integer temp[]=new Integer [k];
        // generate2(ans, temp, ar, 0, k, n);
        // return ans;

    }
}