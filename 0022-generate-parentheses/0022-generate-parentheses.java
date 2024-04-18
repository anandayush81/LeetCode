// Time Complexity : O(4n * n), for each index in string, we try both the parenthesis which is 2*2*2...2n times = O(22n) = O(4n) and lastly, we spend an O(n) time to check for the formed string's validity.
// Space Complexity : O(4n) (A tighter bound exists)


//Both the below solutions are correct


// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> res = new ArrayList<String>();
//         recurse(res, 0, 0, "", n);
//         return res;
//     }    
//     public void recurse(List<String> res, int left, int right, String s, int n) {
//         if (s.length() == n * 2) {
//             res.add(s);
//             return;
//         }
//         if (left < n) {
//             recurse(res, left + 1, right, s + "(", n);
//         }
//         if (right < left) {
//             recurse(res, left, right + 1, s + ")", n);
//         }
//     }
// }


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        StringBuilder sb=new StringBuilder();
        recurse(res, 0, 0, sb, n);
        return res;
    }
    public void recurse(List<String> res, int left, int right, StringBuilder sb, int n) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }
        if (left < n) {
            recurse(res, left + 1, right, sb.append('('), n);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right < left) {
            recurse(res, left, right + 1, sb.append(')'), n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
