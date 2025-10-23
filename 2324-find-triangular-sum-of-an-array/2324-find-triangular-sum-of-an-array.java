class Solution {
    public int triangularSum(int[] nums) {
        int n=nums.length;
        int k=n-1;

        int pascal[]=new int[1];
        pascal[0]=1;
        for (int row=1;row<=k;row++){
            int temp[]=new int[row+1];
            temp[0]=1; temp[row]=1;
            for(int j=1;j<row;j++){
                temp[j]=(pascal[j-1]+pascal[j])%10;
            }
            pascal=temp;
            // System.out.println(Arrays.toString(pascal));
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=(pascal[i]*nums[i])%10;
        }
        return sum%10;
        
    }
}