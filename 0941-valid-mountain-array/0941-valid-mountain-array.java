class Solution {
    public boolean validMountainArray(int[] a) {
        int n=a.length;
        if(n<=2) return false;
        boolean inc=false, dec=false;
        int i=1;
        while(i<n && a[i]>a[i-1]){
            inc=true; i++;
        }
        while(i<n && a[i]<a[i-1]){
            dec=true; i++;
        }
        if(i==n && inc && dec) return true;
        return false;

        
    }
}

// Two people climb from left and from right separately.
// If they are climbing the same mountain,
// they will meet at the same point.
    // public boolean validMountainArray(int[] A) {
    //     int n = A.length, i = 0, j = n - 1;
    //     while (i + 1 < n && A[i] < A[i + 1]) i++;
    //     while (j > 0 && A[j - 1] > A[j]) j--;
    //     return i > 0 && i == j && j < n - 1;
    // }