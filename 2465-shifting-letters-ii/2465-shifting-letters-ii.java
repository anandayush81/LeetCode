class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int mod[]=new int[n];
        for(int i=0;i<shifts.length;i++){
            int st=shifts[i][0], end=shifts[i][1], dir=shifts[i][2];
            if(dir==0){
                mod[st]+=-1;
                if(end+1<n)
                    mod[end+1]+=1;
            }
            else if(dir==1){
                mod[st]+=1;
                if(end+1<n)
                    mod[end+1]+=-1;
            }

        }
        for(int i=1;i<n;i++){
            mod[i]=mod[i]+mod[i-1];
        }
        System.out.println(Arrays.toString(mod));
        char charr[]=s.toCharArray();
        for(int i=0;i<n;i++){
            // int rem=((mod[i]%26)>=0)? mod[i]%26 : (mod[i]%26) + 26;
            // int newch=97+
            // charr[i]=(char)((int)charr[i]+rem);
            int newCharIndex = (s.charAt(i) - 'a' + mod[i] % 26 + 26) % 26;
            charr[i] = (char)(97 + newCharIndex);
            
        }
        return new String(charr);
        
    }
}