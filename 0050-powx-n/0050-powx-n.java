class Solution {
    private double solve(double x, int n){
        System.out.println(" x is "+x +" n is "+n);
        if(x==0.0) return x;
        if(n==-1) return 1/x;
        if(n==0) return 1.0;

        double a=solve(x, n/2);
        // if(n%2==0) return a*a;
        //     else return a*a*(1/x);
        double d=a*a;
        if(n%2==0)
        return d;
            
        else{
            if(n<0) return d*(1/x);
            else return d*x;
        }
        
    }
    public double myPow(double x, int n) {
        // return Math.pow(x,n);
        return solve(x,n);

    }
}