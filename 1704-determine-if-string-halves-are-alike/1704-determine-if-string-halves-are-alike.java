class Solution {
    boolean isVowel(char ch){
        if(ch=='a'|| ch=='A'||ch=='e'||ch=='E'||ch=='i'||ch=='I'||ch=='o'||ch=='O'||ch=='u'||ch=='U')
        return true;
        return false;
    }
    public boolean halvesAreAlike(String s) {
        int n=s.length();
        int c1=0,c2=0;
        for(int i=0;i<n;i++)
        {
            if(i<(n/2) && isVowel(s.charAt(i))) c1++;
            else if(i>=(n/2) && isVowel(s.charAt(i))) c2++;
        }
        return (c1==c2);

    }
}