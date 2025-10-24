class Solution {
    public String digitSum(String s, int k) {
        int n=s.length(); String str=s;
        while(str.length()>k){
            char ar[]=str.toCharArray();
            String temp="";
            int i=0;
            while(i<ar.length){
                int sum=0;
                for(int j=i;j<(i+k) && j<ar.length;j++){
                    sum+=(ar[j]-'0');
                }
                // System.out.println("sum="+sum);
                temp+=""+sum;
                i+=k;
            }
            // System.out.println("str="+str);
            str=temp;
        }
        return str;
        
    }
}