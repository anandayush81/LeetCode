class Solution {
    Map<Character, String>map;
    private void solve(String d, int idx, int n, List<String>ans, StringBuilder temp){
        if(idx>=n){
            if(temp.length()!=0)
                ans.add(temp.toString());
            return;
        }
        // for(int i=idx;i<n;i++){
        //     String str=map.get(d.charAt(i));
        //     for(int j=0;j<str.length();j++){
        //         temp.append(str.charAt(j));
        //         solve(d,i+1,n,ans,temp);
        //         temp.deleteCharAt(temp.length()-1);
        //     }
        // }

        char ch=d.charAt(idx);
        String str=map.get(ch);
        for(int i=0;i<str.length();i++){
            temp.append(str.charAt(i));
            solve(d,idx+1,n,ans,temp);
            //StringBuilder is an object and not a primitive type like String
            //So we need to undo the changes
            temp.deleteCharAt(temp.length()-1);
        }

    }
    public List<String> letterCombinations(String digits) {
        map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String>ans=new ArrayList<>();
        StringBuilder temp=new StringBuilder();
        solve(digits,0,digits.length(),ans,temp);
        return ans;
        
        
    }
}