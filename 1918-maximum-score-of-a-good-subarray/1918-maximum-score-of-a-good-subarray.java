// class Solution {
//     public int maximumScore(int[] nums, int k) {
//         Stack<Integer> stack = new Stack<>();
//         stack.push(-1);
//         int n = nums.length;
//         int max = nums[k];

//         for(int i = 0; i < n; i++) {
           
//             while(stack.peek() != -1 && nums[stack.peek()] >= nums[i]) {
//                 int currentHeight = nums[stack.pop()];
//                 int currentWidth = i - stack.peek() - 1;
                
//                 if(stack.peek() < k && i > k){
                    
//                     max = Math.max(max, currentHeight * currentWidth);
                    
//                 }
//             }
//             stack.push(i);
//         }
//         while(stack.peek() != -1) {
//             int currentHeight = nums[stack.pop()];
//             int currentWidth = n - stack.peek() - 1;
//             if(stack.peek() < k){
                
//                 max = Math.max(max, currentHeight * currentWidth);
                
//             }
//         }
//         return max;
//     }
// }


class Solution {
    private void calls(int a[], int ls[]){
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<a.length;i++){
            while(!st.isEmpty() && a[i]<=a[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) ls[i]=-1;
            else ls[i]=st.peek();
            st.push(i);
        }
    }
    
    private void calrs(int a[], int rs[]){
        Stack<Integer>st=new Stack<>();
        for(int i=a.length-1;i>=0;i--){
            while(!st.isEmpty() && a[i]<=a[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) rs[i]=a.length;
            else rs[i]=st.peek();
            st.push(i);
        }
    }
    
    public int maximumScore(int[] heights, int k) {
        int n=heights.length;
        int ls[]=new int[n];
        int rs[]=new int[n];
        calls(heights,ls); 
        calrs(heights,rs); 
        // System.out.println(Arrays.toString(lg));
        // System.out.println(Arrays.toString(rg));
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int sl=ls[i]+1; //left end of the sub array that we will use for calculation
            int sr=rs[i]-1; //right end of the sub array that we will use for calculation
            if(sl<=k && sr>=k){
                int area=heights[i]*(sr-sl+1);
                maxi=Math.max(maxi,area);
            }
            
        }
        return maxi;

        
    }
}