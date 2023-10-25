// class Solution {
//     public int findPivot(int[] a) {
//         int n=a.length;
//         int pivot=-1;
//         int l=0,r=n-1;
//         while(a[r]==a[l] && r>l){
//             r--;
//         }
//         while(l<=r){
//             int mid=(l+r)/2;
//             // System.out.println("mid is "+mid);
//             if(a[mid]>=a[0])
//                 l=mid+1;
//             else{
//                 pivot=mid;
//                 r=mid-1;
//             }
//         }
//         return pivot;
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
//     public boolean search(int[] a, int k) {
//         int n=a.length;
//         int pivot=findPivot(a);
//         System.out.println("pivot is "+pivot);
//         int ans=-1;
//         if(pivot==-1){
//             ans= binsearch(a,k,0,n-1);
//         }
//         else{
//             if(k>=a[0])
//             ans= binsearch(a,k,0,pivot-1);
//             else
//             ans= binsearch(a,k,pivot,n-1);
//         }
//         return ans==-1?false:true;
        
//     }
// }


class Solution {
    public int findPivot(int[] a, int l, int r) {
        // int n=a.length;
        // int pivot=-1;
        // int l=0,r=n-1;
        // while(a[r]==a[l] && r>l){
        //     r--;
        // }
        int pivot=-1;
        while(l<=r){
            int mid=(l+r)/2;
            // System.out.println("mid is "+mid);
            if(a[mid]>=a[0])
                l=mid+1;
            else{
                pivot=mid;
                r=mid-1;
            }
        }
        return pivot;
    }
    public int binsearch(int a[], int k, int l, int r){
        while(l<=r){
            int mid=(l+r)/2;
            if(a[mid]==k)
            return mid;
            else if(a[mid]>k){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }
    public boolean search(int[] a, int k) {
        int n=a.length;
        // int pivot=-1;
        int l=0,r=n-1;
        while(a[r]==a[l] && r>l){
            r--;
        }
        int pivot=findPivot(a,l,r);
        System.out.println("pivot is "+pivot);
        int ans=-1;
        if(pivot==-1){
            ans= binsearch(a,k,0,r);
        }
        else{
            if(k>=a[0])
            ans= binsearch(a,k,0,pivot-1);
            else
            ans= binsearch(a,k,pivot,n-1);
        }
        return ans==-1?false:true;
        
    }
}