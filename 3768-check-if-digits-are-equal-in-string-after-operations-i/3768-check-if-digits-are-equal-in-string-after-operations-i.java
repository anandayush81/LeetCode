class Solution {
    public boolean hasSameDigits(String s) {
        String str=s;
        while(str.length()>2){
            String str3="";
            int len=str.length();
            for(int i=0;i<len-1;i++){
                String str2=str.substring(i,i+2);
                int temp= ( (Integer.parseInt(""+str2.charAt(0))) + (Integer.parseInt(""+str2.charAt(1))) )%10;
                str3+=temp;
            }
            System.out.println("At each step str= "+str3);
            str=str3;
        }
        if(str.length()==2 && str.charAt(0)==str.charAt(1)) return true;
        return false; 
    }
}