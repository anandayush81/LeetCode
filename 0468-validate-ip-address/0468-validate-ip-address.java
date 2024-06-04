// import java.util.regex.Pattern;

public class Solution {
    public String validIPAddress(String IP) {
        // Regular expression for IPv4
        String v4 = "^(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])(\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])){3}$";
        if (IP.matches(v4)) {
            return "IPv4";
        }

        // Regular expression for IPv6
        String v6 = "^([0-9a-fA-F]{1,4})(\\:([0-9a-fA-F]{1,4})){7}$";
        if (IP.matches(v6)) {
            return "IPv6";
        }

        return "Neither";
    }

    // public static void main(String[] args) {
    //     Solution solution = new Solution();

    //     // Test cases
    //     System.out.println(solution.validIPAddress("172.16.254.1"));  // Output: IPv4
    //     System.out.println(solution.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));  // Output: IPv6
    //     System.out.println(solution.validIPAddress("256.256.256.256"));  // Output: Neither
    //     System.out.println(solution.validIPAddress("2001:0db8:85a3::8A2E:037j:7334"));  // Output: Neither
    // }
}
