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

/*
here input array is nums = [1,2,3,4,5], so we have to construct a pascal triangle row with the same number of elements
i.e. [1, 4, 6, 4, 1], so that every individual elt will multiply with each other one at a time and give one integer
as a result.

here we have one output = [1*1 + 4*2 + 6*3 + 4*4 + 1*5]

if we wanted to stop as 2 elts in my final array like in this question: https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/

then we would need to construct the pascal array with 1 less elt than input array so that we could something like this:
pascal array: [1, 3, 3, 1]; nums = [1,2,3,4,5]

[(1*1+ 3*2 + 3*3 + 1*4), (1*2 + 3*3 +  3*4  + 1*5)]


“In Pascal triangle we only have one 1 2 1, right? Why do we see two here?”
✔️ Correct — there is only one row [1, 2, 1] in Pascal’s triangle.
✔️ But in our operation, we apply that same pattern multiple times,
once for each position in the sequence (each “window” of size 3).

Hence you see two results, both using [1, 2, 1].


*/





