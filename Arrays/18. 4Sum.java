//With extra space
class Solution {
    public List<List<Integer>> fourSum(int[] a, int target) {
        int n=a.length;
        Arrays.sort(a);
        List<List<Integer>>ans=new ArrayList<>();
        Set<List<Integer>>set=new HashSet<>();
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                long val=target-((long)a[i]+a[j]);
                System.out.println(val);
                int left=j+1, right=n-1;
                while(left<right){
                    if((long)a[left]+a[right]==val){
                        System.out.println(a[left]+" "+a[right]);
                        List<Integer>temp=new ArrayList<>();
                        temp.add(a[i]);
                        temp.add(a[j]);
                        temp.add(a[left]);
                        temp.add(a[right]);
                        set.add(temp);
                        left++;
                        right--;
                    }
                    else if((long)a[left]+a[right]>val)
                    right--;
                    else
                    left++;
                }
                
            }
        }
        ans.addAll(set);
        return ans;
    }
}

//Without extra space 

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<>();
        if(target==-294967296) return list;
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                int k=j+1;
                int l=n-1;
                while(k<l){
                    if((nums[i]+nums[j]+nums[k]+nums[l])<target) k++;
                    else if((nums[i]+nums[j]+nums[k]+nums[l])>target)l--;
                    else{
                        List<Integer> sublist=new ArrayList<>();
                        sublist.add(nums[i]);
                        sublist.add(nums[j]);
                        sublist.add(nums[k]);
                        sublist.add(nums[l]);
                        list.add(sublist);
                        int t1=k;
                        int t2=l;
                        while(k<l&&nums[t1]==nums[k]) k++;
                        while(k<l&&nums[t2]==nums[l]) l--;
                    }
                    while(j+1<n&&nums[j+1]==nums[j]) j++;
                    while(i+1<j&&nums[i+1]==nums[i]) i++;
                }
            }
        }
        return list;
    }
}