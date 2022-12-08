package DynamicProgramming.LongestPalindromicSubsequence;

// import java.util.Arrays;

/**
 * * Longest Palindromic Subsequence (Variation of LCS Problem)
 */
public class Solution {
    public static String longestPalindromicSubstring(String str) {
        // Write your code here.
        if(str == null || str.length() == 0)
            return "";
        int len = str.length();
        while(len > 0){
            for(int i=0; i + len <= str.length(); i++){
                String ss = str.substring(i, i + len);
                if(isPalindrome(ss))
                    return ss; }
            len--;
        }
        return "";
    }

    public static boolean isPalindrome(String ss){
        int left = 0;
        int right = ss.length() - 1;
        while(left < right){
            if(ss.charAt(left) != ss.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // should be 4
        System.out.println(solution.longestPalindromicSubstring("bbbab"));

        // should be 5
        System.out.println(solution.longestPalindromicSubstring("GEEKSFORGEEKS"));
    }
}
