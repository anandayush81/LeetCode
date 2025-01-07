class Solution {
    Set<String>ansset;
    // public boolean isSubstring(String p, String c){
    //     int lenp=p.length(), lenc=c.length();
    //     // int i=0,j=0;
    //     // while(i<lenp && j<lenc){
    //     //     if(p.charAt(i)==c.charAt(j)){
    //     //         int 
    //     //         while(p.charAt(i)==c.charAt(j)){
    //     //         }
    //     //     }
    //     //     // while(p.charAt(i)==c.charAt(j)){
    //     //     // }
    //     // }

    //     // if(p.length()<c.length()) return false;

    //     for(int j=0;j<lenc;j++){
    //         for(int i=0;i<lenp;i++){
    //             if(c.charAt(j)==p.charAt(i)){
    //                 int x=j,y=i;
    //                 while(x<lenc && y<lenp && c.charAt(x)==p.charAt(y)){
    //                     x++;
    //                     if(x==lenc) return true;
    //                     y++;
    //                 }
                    
    //             }
    //         }

    //     }
    //     return false;
    // }

    public boolean isSubstring(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        // Iterate through txt
        for (int i = 0; i <= n - m; i++) {

            // Check for substring match
            int j;
            for (j = 0; j < m; j++) {

                // Mismatch found
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }

            // If we completed the inner loop, we found a match
            if (j == m) {

                // Return starting index
                return true;
            }
        }

        // No match found
        return false;
    }
    public List<String> stringMatching(String[] words) {
        ansset=new HashSet<>();
        int n=words.length;
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(isSubstring(words[i],words[j])) {
                        System.out.println("i is "+ i + " j is "+j);
                        ansset.add(words[j]);
                    }
                }
            }
        }
        return new ArrayList<>(ansset);
    }
}