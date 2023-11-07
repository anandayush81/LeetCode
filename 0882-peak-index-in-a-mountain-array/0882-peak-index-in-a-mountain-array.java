// class Solution {
//     public int peakIndexInMountainArray(int[] a) {
//         int n=a.length;
//         // int l=0, r=n-1;
//         int l=1,r=n-2;
//         while(l<=r){
//             int mid=(l+r)/2;
//             if( mid>0 && mid<n && a[mid]>a[mid-1] && a[mid]>a[mid+1]) return mid;
//             else if( mid>0 && mid<n && a[mid] >a[mid-1] && a[mid]<a[mid+1]) l=mid+1;
//             else if( mid>0 && mid<n && a[mid] >a[mid+1] && a[mid]<a[mid-1]) r=mid-1;
//         }
//         return -1;        
//     }
// }

class Solution {
    public int peakIndexInMountainArray(int[] a) {
        int n=a.length;
        int l=1,r=n-2;
        while(l<=r){
            int mid=(l+r)/2;
            if( a[mid]>a[mid-1] && a[mid]>a[mid+1]) 
            return mid;
            else if(a[mid] >a[mid-1] && a[mid]<a[mid+1]) 
            l=mid+1;
            else  
            r=mid-1;
        }
        return -1;        
    }
}
