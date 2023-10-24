class Solution {
    public boolean isPowerOfThree(int n) {
        // if(n<=0) return false;
        // double r=Math.log(n)/Math.log(3);
        // int x=(int)r;
        // if(Math.pow(3,x)==n) return true;
        // return false;




//Just wanted to ask in Second approach why log base 10 works but not log(base e) , I came up with the same approach but was using log instead of log10 and got WA.
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;

        // if (n <= 0) {
        //     return false;
        // }
        // // System.out.println(Math.log(n));
        // // System.out.println(Math.log(3));

        // int a = (int) (Math.log10(n) / Math.log10(3));
        // /*
        //     4^a = n
        //     a = log(n) to base 4
        //     a = log(n) to base e / log(4) to base e
        // */
        // // System.out.println(a);
        // return n == Math.pow(3, a);




        // if(n<=0) return false;
        // System.out.println(Math.log(n)/Math.log(3));
        // System.out.println(Math.floor(Math.log(n)/Math.log(3)));
        // System.out.println(Math.ceil(Math.log(n)/Math.log(3)));
        // return (int)Math.floor(Math.log(n)/Math.log(3))==(int)Math.ceil(Math.log(n)/Math.log(3));
    }
}