class Solution {
    int maxLen=Integer.MIN_VALUE;
    private boolean allUnique(String str){
        char c[]=str.toCharArray();
        Arrays.sort(c);
        // System.out.println("Sorted String is "+ new String(c));
        for(int i=0;i<str.length()-1;i++){
            if(c[i]==c[i+1])
            return false;
        }
        return true;
    }
    private void solve(List<String> arr, List<String>temp, int idx, int n){
        StringBuilder sb=new StringBuilder();
        for(String str:temp){
            sb.append(str);
        }
        if(allUnique(sb.toString())){
            // System.out.println("String is "+sb.toString());
            maxLen=Math.max(maxLen, sb.toString().length());
        }
        for(int i=idx;i<n;i++){
            temp.add(arr.get(i));
            solve(arr,temp,i+1,n);
            temp.remove(temp.size()-1);
        }
    }
    public int maxLength(List<String> arr) {
        int n=arr.size();
        List<String>temp=new ArrayList<>();
        solve(arr, temp, 0, n);
        return maxLen;
        
    }
}