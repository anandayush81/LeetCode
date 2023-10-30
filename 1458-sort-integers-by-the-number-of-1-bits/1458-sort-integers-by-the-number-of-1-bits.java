
class Solution {
    // class Cmp implements Comparator<Integer>{
    //     public int compare(Integer a, Integer b){

    //     }
    // }
    public int[] sortByBits(int[] arr) {
        int n=arr.length;
        List<Integer>al=new ArrayList<>();
        for(int x:arr){
            al.add(x);
        }
        Collections.sort(al, (a,b)->{
            int bits1=Integer.bitCount(a);
            int bits2=Integer.bitCount(b);
            if(bits1==bits2) return a-b;
            return bits1-bits2;
        });
        int ans[]=new int[n]; int k=0;
        for(Integer x:al){
            ans[k++]=(int)x;
        }
        return ans;
    }
}