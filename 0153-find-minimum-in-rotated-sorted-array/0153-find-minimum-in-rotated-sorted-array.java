class Solution {
    public int findMin(int[] a) {
        int n=a.length;
        int ans=-1;
        int l=0,r=n-1;
        // if(a[l]<a[r]) return a[l];
        while(l<=r){
            int mid=(l+r)/2;
            if(a[mid]>=a[0])
                l=mid+1;
            else{
                ans=mid;
                r=mid-1;
            }
        }
        return (ans==-1)?a[0]:a[ans];
        // return a[ans];
    }
}