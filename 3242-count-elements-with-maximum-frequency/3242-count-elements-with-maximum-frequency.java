class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n=nums.length;
        int ans=0;
        int mxcnt=0;
        Map<Integer, Integer>mp=new HashMap<>();
        for(int x:nums){
            mp.put(x, mp.getOrDefault(x,0)+1);
            if (mxcnt<mp.get(x)) mxcnt=mp.get(x);

        }
        for(int key:mp.keySet()){
            if(mp.get(key)==mxcnt) ans+=mp.get(key);
        }
        return ans;
        
    }
}