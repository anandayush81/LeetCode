//If we do not modify the input array
class Solution {

    public int findDuplicate(int[] nums) {
        
        int slow=nums[0];
        int fast= nums[0];
        slow= nums[slow];
        fast= nums[nums[fast]];
        
        while(slow!=fast) {
            slow= nums[slow];
            fast= nums[nums[fast]];
        } 
        //to get the repeated number, it will be the starting point of loop
        //So use floyd warshal to reach starting of loop
        fast= nums[0];
        while(slow!=fast) {
            slow= nums[slow];
            fast= nums[fast];
        }
        return slow;
    }
}

//If we can modify the input array
/*class Solution {
    public int findDuplicate(int[] A) {
        int n=A.length;
        int i=0;
        while(i<n){
            if(A[i]>=1 && A[i]<=n)
            {
                int correctIdx=A[i]-1;
                if(A[i]!=A[correctIdx])
                {
                    int temp=A[i];
                    A[i]=A[correctIdx];
                    A[correctIdx]=temp;
                }
                else
                i++;
            }
            else 
            i++;
        }

        for(i=0;i<n;i++)
        {
            if(A[i]!=i+1)
            return A[i];
        }
        return A[i];
        
    }
}*/

