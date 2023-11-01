// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         int n=nums.length;
//         PriorityQueue<Integer>q=new PriorityQueue<>();
//         for(int i=0;i<k;i++){
//             q.add(nums[i]);
//         }
//         for(int i=k;i<n;i++){
//             if(nums[i]>q.peek()){
//                 q.poll();
//                 q.add(nums[i]);
//             }
//         }
//         return q.peek();






//         // for(int i=k;i<n;i++){
//         //     if(nums[i]<q.peek())
//         // }
//         // int nn=n-k+1;
//         // while(nn>1){
//         //     q.poll();
//         //     nn--;
//         // }
//         // return q.peek();

//     }
// }


class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<Integer>q=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            q.add(nums[i]);
            if(q.size()>k) q.poll();
        }
        return q.peek();
    }
}