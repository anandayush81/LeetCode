class Solution {
    public int findPivot(int[] a) {
        int n=a.length;
        int ans=-1;
        int l=0,r=n-1;
        while(l<=r){
            int mid=(l+r)/2;
            // System.out.println("mid is "+mid);
            if(a[mid]>=a[0])
                l=mid+1;
            else{
                ans=mid;
                r=mid-1;
            }
        }
        return ans;
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
    public int search(int[] a, int k) {
        int n=a.length;
        int pivot=findPivot(a);
        if(pivot==-1){
            return binsearch(a,k,0,n-1);
        }
        else{
            if(k>=a[0])
            return binsearch(a,k,0,pivot-1);
            else
            return binsearch(a,k,pivot,n-1);
        }
        
    }
}