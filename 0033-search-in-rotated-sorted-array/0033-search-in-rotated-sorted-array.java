/*


//in this question array elemnts are unique, won't work for duplicates'
//prac

//if the array is sorted in increasing order, there will be no pivot.
//pivot is the smallest elemnt from the left of the array that has an index>0
class Solution {
    public int findPivot(int[] a) {
        int l=0, r=a.length-1; int ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(a[mid]>=a[0]) l=mid+1; //in this case we've added equality sign bcoz pivot can never be 0
            //so if a[mid]==a[0] move agead towards the right
            else if(a[mid]<a[0]){
                ans=mid;
                r=mid-1;
            }
        }
        return ans;
    }
    public int binsearch(int a[], int k, int l, int r){
        
        int left=l, right=r;
        while(left<=right){
            int mid=(left+right)/2;
            if(a[mid]==k) return mid;
            else if(a[mid]>k) right=mid-1;
            else left=mid+1;
        }
        return -1;

    }
    public int search(int[] a, int k) {
        int n=a.length;
        int pivot=findPivot(a);
        if(pivot==-1) return binsearch(a, k, 0,n-1);
        else if(k>=a[0]) return binsearch(a,k, 0, pivot-1);
        else return binsearch(a,k,pivot,n-1);
        
    }
}


*/


class Solution {
 int search(int ar[], int low, int high, int k, int n){
    while (low <= high) {
            int mid = (low + high) / 2;

            // if mid points to the target
            if (ar[mid] == k)
                return mid;

            // if left part is sorted
            if (ar[low] <= ar[mid]) {
                if (ar[low] <= k && k <= ar[mid]) {
                    // element exists
                    high = mid - 1;
                } else {
                    // element does not exist
                    low = mid + 1;
                }
            } else { // if right part is sorted
                if (ar[mid] <= k && k <=ar[high]) {
                    // element exists
                    low = mid + 1;
                } else {
                    // element does not exist
                    high = mid - 1;
                }
            }
        }
        return -1;
  }
    public int search(int[] a, int k) {
        int n=a.length;
        // int pivot=findPivot(a);
        // if(pivot==-1) return binsearch(a, k, 0,n-1);
        // else if(k>=a[0]) return binsearch(a,k, 0, pivot-1);
        // else return binsearch(a,k,pivot,n-1);

        return search( a, 0, n-1, k,n);
        
    }
}

















// class Solution {
//     public int findPivot(int[] a) {
//         int n=a.length;
//         int ans=-1;
//         int l=0,r=n-1;
//         while(l<=r){
//             int mid=(l+r)/2;
//             // System.out.println("mid is "+mid);
//             if(a[mid]>=a[0])
//                 l=mid+1;
//             else{
//                 ans=mid;
//                 r=mid-1;
//             }
//         }
//         return ans;
//     }
//     public int binsearch(int a[], int k, int l, int r){
//         while(l<=r){
//             int mid=(l+r)/2;
//             if(a[mid]==k)
//             return mid;
//             else if(a[mid]>k){
//                 r=mid-1;
//             }
//             else{
//                 l=mid+1;
//             }
//         }
//         return -1;
//     }
//     public int search(int[] a, int k) {
//         int n=a.length;
//         int pivot=findPivot(a);
//         if(pivot==-1){
//             return binsearch(a,k,0,n-1);
//         }
//         else{
//             if(k>=a[0])
//             return binsearch(a,k,0,pivot-1);
//             else
//             return binsearch(a,k,pivot,n-1);
//         }
        
//     }
// }