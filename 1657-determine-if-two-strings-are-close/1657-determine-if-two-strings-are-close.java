class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n1=word1.length(), n2=word2.length();
        if(n1!=n2) return false;
        int a[]=new int[123];
        int b[]=new int[123];

        //Set<Character>s1=new HashSet<>();
        //Set<Character>s2=new HashSet<>();

        for(int i=0;i<n1;i++){
            a[(int)word1.charAt(i)]++;
            //s1.add(word1.charAt(i));
            b[(int)word2.charAt(i)]++;
            //s2.add(word2.charAt(i));
        }
        for(int i=97;i<=122;i++){
            if( (a[i]!=0 && b[i]==0) || (a[i]==0 && b[i]!=0)) return false;
        }
        //if(s1.size()!=s2.size()) return false;
        //if(!s1.equals(s2)) return false;

        Arrays.sort(a); Arrays.sort(b);
        for(int i=97;i<=122;i++){
            if(a[i]!=b[i]) return false;
        }
        return true;

        
    }
}