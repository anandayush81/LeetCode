// import java.util.regex.Pattern;

public class Solution {
    public String validIPAddress(String IP) {
        
        // Regular expression for IPv4
        String v4 = "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        if (IP.matches(v4)) {
            return "IPv4";
        }

        // Regular expression for IPv6
        String v6 = "((([0-9a-fA-F]){1,4})\\:){7}([0-9a-fA-F]){1,4}";
        if (IP.matches(v6)) {
            return "IPv6";
        }

        return "Neither";
    }
}
